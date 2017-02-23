package socket;

// =================================================
// Client端代码：
// =================================================
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

public class Client {

    private Socket clientEndPoint;

    private InputStream in;

    private OutputStream out;

    private Logger log = Logger.getLogger(Client.class);

    public void connectToService() throws IOException, InterruptedException {
        clientEndPoint = new Socket("192.168.32.185", 516);
        in = clientEndPoint.getInputStream();
        out = clientEndPoint.getOutputStream();
        DataInputStream dis = new DataInputStream(in);
        DataOutputStream dos = new DataOutputStream(out);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Server is ready. Please type in file to get: ");
        String request;
        while (true) {
            System.out.print("Get: ");
            request = br.readLine() + "\r\n";
            dos.writeUTF(request);
            if (request.trim().equals("bye") || request.trim().equals("exit") || request.trim().equals("quit")) {
                break;
            }
            while (true) {
                if (in != null) {
                    System.out.println("Getting file(s)......");
                    int i;
                    long count = 0;
                    boolean fileExist = dis.readBoolean();
                    if (fileExist) {
                        log.info("文件存在打个log说一下");
                        File f = getTargetFile(request.trim());
                        FileOutputStream fos = new FileOutputStream(f);
                        long fileLength = dis.readLong();
                        byte[] buf = new byte[1024];
                        System.out.println(fileLength);
                        while (true) {
                            i = dis.read(buf, 0, 1024);
                            fos.write(buf, 0, i);
                            count += i;

                            if (count >= fileLength) {
                                break;
                            }
                        }
                        fos.close();
                    }
                    break;
                }
            }
            System.out.println(dis.readUTF());
        }

        System.out.println("Client ready to close......");
        Thread.sleep(5000);
        dis.close();
        dos.close();
        clientEndPoint.close();
    }

    private File getTargetFile(String path) {
        path = path.replace("/", "\\");
        path = path.substring(path.lastIndexOf("\\"));
        return new File(path);
    }

    public static void main(String[] args) {
        try {
            new Client().connectToService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
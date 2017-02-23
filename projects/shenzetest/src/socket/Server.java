package socket;

// Server端代码（支持多个客户端同时访问，端口号为516）：
// =================================================
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Server extends Thread {

    private ServerSocket serverSocket;

    private Socket serverEndPoint;

    private InputStream in;

    private OutputStream out;

    public Server() {

    }

    private Server(Socket serverEndPoint) {
        this.serverEndPoint = serverEndPoint;
    }

    public void startService(int port) throws IOException, InterruptedException {
        System.out.println("service started...");
        serverSocket = new ServerSocket(port);
        while (true) {
            new Server(serverSocket.accept()).start();
        }
    }

    @Override
    public void run() {
        try {
            Level level = Logger.getRootLogger().getLevel();
            Logger.getRootLogger().setLevel(Level.OFF);
            in = serverEndPoint.getInputStream();
            out = serverEndPoint.getOutputStream();

            DataInputStream dis = new DataInputStream(in);
            DataOutputStream dos = new DataOutputStream(out);

            String request;
            while (true) {
                if ((request = dis.readUTF()) != null) {
                    if (request.trim().equals("bye") || request.trim().equals("exit") || request.trim().equals("quit")) {
                        break;
                    }
                    System.out.println(serverEndPoint.getInetAddress().getCanonicalHostName() + " is getting '" + request.trim()
                            + "'......");
                    File f = new File(request.trim());
                    if (!f.exists()) {
                        dos.writeBoolean(false);
                        dos.writeUTF("File '" + f.getPath() + "' doesn't exist!");
                        continue;
                    }
                    if (f.isDirectory()) {
                        dos.writeBoolean(false);
                        dos.writeUTF("'" + f.getPath() + "' is a folder!");
                        continue;
                    }
                    FileInputStream fis = new FileInputStream(f);
                    int i;
                    int count = 0;
                    byte[] buf = new byte[1024];
                    dos.writeBoolean(true);
                    dos.writeLong(f.length());

                    while ((i = fis.read(buf)) != -1) {
                        dos.write(buf, 0, i);
                        count += i;
                    }
                    fis.close();
                    Thread.sleep(1000);
                    dos.writeUTF("File '" + f.getName() + "' has been saved in the current folder.");

                }
            }

            System.out.println("Connection to " + serverEndPoint.getInetAddress().getCanonicalHostName()
                    + " is ready to close......");
            Thread.sleep(5000);
            dis.close();
            dos.close();
            serverEndPoint.close();
            Logger.getRootLogger().setLevel(level);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new Server().startService(516);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
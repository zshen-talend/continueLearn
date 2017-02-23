// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package hdfs;

import java.net.URI;
import java.security.PrivilegedExceptionAction;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.security.UserGroupInformation;

/**
 * created by zshen on Jul 25, 2013
 * Detailled comment
 *
 */
public class FileSystemDoubleCat {

    public static void main(String[] args) throws Exception {
        UserGroupInformation ugi = UserGroupInformation.createRemoteUser("tdq");
        ugi.doAs(new PrivilegedExceptionAction<Void>() {

            //
            public Void run() throws Exception {

                String uri = "hdfs://hadoopmaster1.talend.lan:8020/user/tdq/shenzetest1/tMatchGroupHadoop_1/in";
                Configuration conf = new Configuration();
                FileSystem fs = FileSystem.get(URI.create(uri), conf);
                FSDataInputStream in = null;
                try {
                    in = fs.open(new Path(uri));
                    IOUtils.copyBytes(in, System.out, 1024, false);
                    in.seek(0);// go back to the start of the file
                    IOUtils.copyBytes(in, System.out, 1024, false);

                } finally {
                    IOUtils.closeStream(in);
                }
                return null;
            }
        });
    }
}

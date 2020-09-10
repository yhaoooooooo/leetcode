


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSocketServer {


    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {

            while (true) {
                Socket accept = serverSocket.accept();

                InputStream inputStream = accept.getInputStream();

                ByteArrayOutputStream o = new ByteArrayOutputStream();
                byte[] tmp = new byte[1024];
                int length = 0;
                while ((length = inputStream.read(tmp)) != -1) {
                    o.write(tmp, 0, length);
                }
                System.out.println(o.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

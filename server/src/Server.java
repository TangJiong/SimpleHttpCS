import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by TangJiong on 2016/4/27.
 * A simple http server
 */
public class Server {

    public static void main(String[] args) throws IOException{

        ServerSocket serverSocket = new ServerSocket(Constant.PORT);

        Logger.info("server staring!");

        while(true){
            Socket clientSocket = serverSocket.accept();
            new Thread(new Handler(clientSocket)).start();
        }

    }

}

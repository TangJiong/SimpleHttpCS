import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by TangJiong on 2016/4/27.
 * A simple http client
 */
public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Logger.info("client staring, and the default host is "+Constant.HOST+":"+Constant.PORT);

        Logger.info("Usage: Type \"GET /example\" and press \"Enter\" to explore what you want, type \"quit\" and press \"Enter\" to stop");

        Scanner scanner = new Scanner(System.in);

        String input;

        while(scanner.hasNext()){

            input = scanner.nextLine();

            if(input.equals("quit")){
                break;
            }else{

                Socket client = new Socket(Constant.HOST, Constant.PORT);

                //===============================================================================

                // construct ObjectOutputStream
                ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
                // construct Request object
                Request request = new Request(Constant.HOST, Constant.PORT, input);
                Logger.info("\n<Request>\n" + request.toString());
                // write Request object
                out.writeObject(request);
                out.flush();


                //================================================================================

                // read Response object
                ObjectInputStream in = new ObjectInputStream(client.getInputStream());
                Response response = (Response) in.readObject();
                Logger.info("\n<Response>\n" + response.toString());

                in.close();
                out.close();
                client.close();
            }

        }

    }

}

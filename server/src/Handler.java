import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created by TangJiong on 2016/4/27.
 * A handler for a request-response pair
 */
public class Handler implements Runnable {

    private Socket clientSocket;

    Handler(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try{

            // ==========================================================================
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            Request request = (Request) in.readObject();
            Logger.info("\n<Request>\n" + request.toString());

            Response response = new Response();
            // TODO here set response according to request
            response.setProtocol(Response.DEFAULT_PROTOCOL);
            response.setStatus(200);
            response.setMsg("OK");
            response.setHeader("Date", new Date());
            response.setHeader("Server", "Self Implemented HTTP Server");

            Logger.info("\n<Response>\n" + response.toString());

            // ==========================================================================
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.writeObject(response);
            out.flush();

            in.close();
            out.close();
            clientSocket.close();

        }catch(IOException e){
            Logger.info("server exception: "+e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

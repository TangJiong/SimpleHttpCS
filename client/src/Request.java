import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TangJiong on 2016/4/27.
 * wrapper of request
 */
public class Request implements Serializable{

    public Request(String host, int port, String inputStr) {
        buildRequest(host, port, inputStr);
    }

    public static final String PUT = "PUT";
    public static final String GET = "GET";
    public static final String DEFAULT_PROTOCOL = "HTTP/1.1";

    private String method;
    private String host;
    private int port;
    private String uri;
    private String protocol;
    private Map<String, Object> headers = new HashMap<>();

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setHeader(String key, Object value){
        headers.put(key, value);
    }

    public Object getHeader(String key){
        return headers.get(key);
    }

    private void buildRequest(String host, int port, String str){
        String[] elements = str.split(" ");
        if(elements.length <2){
            Logger.error("Incomplete Request");
        }else{
            if(elements[0].equals("GET")){
                setMethod(GET);
            }else if(elements[0].equals("PUT")){
                setMethod(PUT);
            }else{
                Logger.error("Unsupport Method");
            }
            setUri(elements[1]);
            setProtocol(DEFAULT_PROTOCOL);
            setHost(host);
            setPort(port);
            setHeader("User-Agent", "Self Implemented Http Client");
            setHeader("Host", host+":"+port);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(method).append(" ").append(uri).append(" ").append(protocol).append("\n");
        for(String key : headers.keySet()){
            sb.append(key).append(": ").append(headers.get(key)).append("\n");
        }
        return sb.toString();
    }

}

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TangJiong on 2016/4/27.
 * wrapper of response
 */
public class Response implements Serializable{

    public static final String DEFAULT_PROTOCOL = "HTTP/1.1";

    private String protocol;
    private int status;
    private String msg;
    private Map<String, Object> headers = new HashMap<>();

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setHeader(String key, Object value){
        headers.put(key, value);
    }

    public Object getHeader(String key){
        return headers.get(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(protocol).append(" ").append(status).append(" ").append(msg).append("\n");
        for(String key : headers.keySet()){
            sb.append(key).append(": ").append(headers.get(key)).append("\n");
        }
        return sb.toString();
    }
}

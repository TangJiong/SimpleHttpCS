import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by TangJiong on 2016/4/27.
 * Simple console logger class
 */
public class Logger {

    static boolean isShowDebug = true;

    public static void debug(Object info){
        if(isShowDebug){
            System.out.println("[DEBUG " +formattedTime()+ "] ===> " + info);
        }
    }

    public static void info(Object info){
        System.out.println("[INFO " +formattedTime()+ "] ===> " + info);
    }

    public static void warning(Object info){
        System.out.println("[WARNING " +formattedTime()+ "] ===> " + info);
    }

    public static void error(Object info){
        System.out.println("[ERROR " +formattedTime()+ "] ===> " + info);
    }

    private static String formattedTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

}

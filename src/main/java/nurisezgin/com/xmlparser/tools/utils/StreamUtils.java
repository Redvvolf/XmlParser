package nurisezgin.com.xmlparser.tools.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by nurisezgin on 03/12/2016.
 */
public class StreamUtils {

    public static void closeStreams(Closeable... objs) {
        for (Closeable o : objs) {
            if (o != null) {
                try {
                    o.close();
                } catch (IOException e) { }
            }
        }
    }

}

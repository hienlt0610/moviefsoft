package hutech.hienlt.movie.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HienLT9 on 3/2/2017.
 */

public class DateUtils {
    public static String dateFormat(Date date, String format){
        if(date == null || format == null) return null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }
}

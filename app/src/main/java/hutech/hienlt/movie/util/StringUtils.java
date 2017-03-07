package hutech.hienlt.movie.util;

import android.text.TextUtils;

/**
 * Created by HienLT9 on 3/3/2017.
 */

public class StringUtils {
    public static String limitWord(String text, int maxWord){
        if(text == null || TextUtils.isEmpty(text) || maxWord <= 0)
            return text;
        String[] words = text.split(" ");
        if(words.length < maxWord)
            return text;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i< maxWord; i++){
            if(i > 0)
                builder.append(" ");
            builder.append(words[i]);
        }
        return builder.toString();
    }

    public static String join(String[] strings, String delimiter){
        if(strings == null || strings.length == 0) return null;
        if(delimiter == null) delimiter = "";
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i< strings.length; i++){
            if(i > 0)
                builder.append(delimiter);
            builder.append(strings[i]);
        }
        return builder.toString();
    }
}

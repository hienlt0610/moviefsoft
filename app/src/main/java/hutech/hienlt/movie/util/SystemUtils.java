package hutech.hienlt.movie.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;

/**
 * Created by HienLT9 on 3/3/2017.
 */

public class SystemUtils {
    public static int getStatusBarHeight(Context context) {
        final Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
            return resources.getDimensionPixelSize(resourceId);
        else
            return (int) Math.ceil((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? 24 : 25) * resources.getDisplayMetrics().density);
    }
}

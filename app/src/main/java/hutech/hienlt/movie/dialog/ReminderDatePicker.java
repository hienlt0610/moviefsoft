package hutech.hienlt.movie.dialog;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

/**
 * Created by HienLT9 on 3/6/2017.
 */

public class ReminderDatePicker extends DatePickerDialog {
    Calendar calendar = Calendar.getInstance();
    @Override
    public boolean isOutOfRange(int year, int month, int day) {
        if(month < calendar.get(Calendar.MONTH) || year < calendar.get(Calendar.YEAR))
            return true;
        if(month == calendar.get(Calendar.MONTH)
                && year == calendar.get(Calendar.YEAR)
                && day < calendar.get(Calendar.DAY_OF_MONTH))
            return true;
        return false;
    }

    public static ReminderDatePicker newInstance(OnDateSetListener callBack, int year,
                                               int monthOfYear,
                                               int dayOfMonth) {
        ReminderDatePicker ret = new ReminderDatePicker();
        ret.initialize(callBack, year, monthOfYear, dayOfMonth);
        return ret;
    }
}

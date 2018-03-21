package ap.com.android_times_square;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.timessquare.CalendarPickerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    CalendarPickerView calendar;
    TextView calendarTip;
    StringBuffer buffer = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        calendarTip = (TextView) findViewById(R.id.calendar_tip);
        calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
        calendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(final Date date) {
                final int size = calendar.getSelectedDates().size();
                buffer.append(formatDate(date)).append("\t");
                calendarTip.setText(buffer.toString() + "\n总共：" + size + "天");
            }

            @Override
            public void onDateUnselected(Date date) {
            }
        });
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        Date today = new Date();
        calendar.init(today, nextYear.getTime()).withSelectedDate(today);
        calendar.init(today, nextYear.getTime()).inMode(CalendarPickerView.SelectionMode.MULTIPLE);

        //默认是只选择一个日期，如果想要选择多个日期，使用下面这行代码
        //calendar.init(today, nextYear.getTime()).inMode(CalendarPickerView.SelectionMode.RANGE);
    }

    private String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(date);
        return str;
    }

}

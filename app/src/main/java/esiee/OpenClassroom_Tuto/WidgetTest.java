package esiee.OpenClassroom_Tuto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import esiee.foodsaver.R;

/**
 * Created by Florian on 11/05/2015.
 */
public class WidgetTest extends AppCompatActivity {

    DatePicker vpicker;
    TextView vdateString = null;
    TextView vdateString2 = null;
    TimePicker vTimePicker = null;
    Calendar calendrier = Calendar.getInstance();
    private int heure = calendrier.get(Calendar.HOUR);
    private int minute = calendrier.get(Calendar.MINUTE);
    private int seconde = calendrier.get(Calendar.SECOND);


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_test);

        vpicker = (DatePicker) findViewById(R.id.datePicker);
        vdateString = (TextView) findViewById(R.id.date);
        vdateString2 = (TextView) findViewById(R.id.date2);
        vTimePicker = (TimePicker) findViewById(R.id.timePicker);

        vTimePicker.setIs24HourView(true);

        vTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(WidgetTest.this, "C'est vous qui voyez, il est donc " + String.valueOf(hourOfDay) + ":" + String.valueOf(minute), Toast.LENGTH_SHORT).show();
            }
        });

        vpicker.updateDate(vpicker.getYear(), 0, 1);
        vdateString.setText("Il est " + heure + ":" + minute + ":" + seconde);
        // Pause 1 seconde
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        calendrier = Calendar.getInstance();
        heure = calendrier.get(Calendar.HOUR);
        minute = calendrier.get(Calendar.MINUTE);
        seconde = calendrier.get(Calendar.SECOND);
        vdateString2.setText("Il est " + heure + ":" + minute + ":" + seconde);
    }
}

package esiee.OpenClassroom_Tuto;

import esiee.foodsaver.R;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Florian on 13/05/2015.
 */
public class OrientationTest extends AppCompatActivity {
    private int ReceivedMessage = 0;
    private TextView msg= null;
    private Button mButton1 = null;
    private Button mButton2 = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orientation_test);
        msg = (TextView) findViewById(R.id.txtAge);

        mButton1 = (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra(NextPageTest.BUTTONS, "1");
                setResult(RESULT_OK, result);
                finish();
            }
        });

        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra(NextPageTest.BUTTONS, "2");
                setResult(RESULT_OK, result);
                finish();
            }
        });

    }
}

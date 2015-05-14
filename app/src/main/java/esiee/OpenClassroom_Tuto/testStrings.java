package esiee.OpenClassroom_Tuto;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import esiee.foodsaver.R;

/**
 * Created by Florian.S on 07/05/2015.
 */
public class testStrings extends AppCompatActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
    
            setContentView(R.layout.test_strings);

            Resources res = getResources();
            // Anaïs ira en %1 et 22 ira en %2
            String chaine = res.getString(R.string.hello, "Anaïs", 22);
            TextView vue = (TextView) findViewById(R.id.textViewHello);
            vue.setText(chaine);
        }
}


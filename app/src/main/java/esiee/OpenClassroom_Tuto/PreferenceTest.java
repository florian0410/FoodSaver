package esiee.OpenClassroom_Tuto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.preference.PreferenceActivity;
import esiee.foodsaver.R;


/**
 * Created by Florian on 13/05/2015.
 */
public class PreferenceTest extends PreferenceActivity{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }
}

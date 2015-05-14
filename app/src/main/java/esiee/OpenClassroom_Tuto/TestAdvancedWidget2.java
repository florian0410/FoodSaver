package esiee.OpenClassroom_Tuto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

import esiee.foodsaver.R;


/**
 * Created by Florian.S on 08/05/2015.
 */
public class TestAdvancedWidget2 extends AppCompatActivity {
    private Spinner liste = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_advanced_widget2);

        liste = (Spinner) findViewById(R.id.spinner1);
        List<String> exemple = new ArrayList<String>();
        exemple.add("Element 1");
        exemple.add("Element 2");
        exemple.add("Element 3");
        exemple.add("Element 4");
        exemple.add("Element 5");
        exemple.add("Element 6");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exemple);
        //Le layout par défaut est android.R.layout.simple_spinner_dropdown_item
        // il permet la personnalisation de la liste
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste.setAdapter(adapter);
    }
}

package esiee.OpenClassroom_Tuto;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import esiee.foodsaver.R;

/**
 * Created by Florian.S on 08/05/2015.
 * @link http://openclassrooms.com/courses/creez-des-applications-pour-android/des-widgets-plus-avances-et-des-boites-de-dialogue
 */
public class TestAdvancedWidget extends AppCompatActivity {
    ListView listeSex = null;
    ListView listeLanguages = null;
    Button vSendButton = null;
    List<String> sex = new ArrayList<String>();
    List<String> languages = new ArrayList<String>();


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_advanced_widget);

        //Déclaration des éléments du layout
        vSendButton = (Button) findViewById(R.id.button);
        listeSex = (ListView) findViewById(R.id.ListView1);
        listeLanguages = (ListView) findViewById(R.id.ListView2);

        vSendButton.setOnClickListener(SendButton);

        sex.add("Masculin");
        sex.add("Feminin");
        languages.add("C");
        languages.add("Java");
        languages.add("COBOL");
        languages.add("Perl");

        ArrayAdapter<String> adapterSex = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice, sex);
        listeSex.setAdapter(adapterSex);
        listeSex.setItemChecked(0, true);

        ArrayAdapter<String> adapterLanguages = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,languages);
        listeLanguages.setAdapter(adapterLanguages);
        listeLanguages.setItemChecked(1,true);

    }

    private OnClickListener SendButton = new OnClickListener() {
        @Override
        public void onClick(View v){
            Toast.makeText(TestAdvancedWidget.this,"Merci pour vos réponses",Toast.LENGTH_LONG).show();
            // Désactiver les choix
            listeLanguages.setChoiceMode(ListView.CHOICE_MODE_NONE);
            listeSex.setChoiceMode(ListView.CHOICE_MODE_NONE);

            // Changer l'aperçu

            listeSex.setAdapter(new ArrayAdapter<String>(TestAdvancedWidget.this,android.R.layout.simple_list_item_1,sex));
            listeLanguages.setAdapter(new ArrayAdapter<String>(TestAdvancedWidget.this,android.R.layout.simple_list_item_1,languages));

            vSendButton.setEnabled(false);
        }
    };


}


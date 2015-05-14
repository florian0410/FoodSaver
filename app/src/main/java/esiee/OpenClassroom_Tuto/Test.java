package esiee.OpenClassroom_Tuto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextWatcher;
import android.text.Editable;

import esiee.foodsaver.R;

/**
 * Created by Florian.S on 06/05/2015.
 * TODO : Ajouter une exception quand pas de texte
 * @link http://openclassrooms.com/courses/creez-des-applications-pour-android/les-widgets-les-plus-simples
 */
public class Test extends AppCompatActivity  {

    private String MegaString = "Votre Poids est parfait... Félicitation !!!";
    private String txtDefault = "Vous devez cliquer sur le bouton « Calculer l'IMC » pour obtenir un résultat";
    public final static String AGE = "Donnée récupérée depuis classe Test";

    private Button bRAZ = null;
    private Button bIMC = null;
    private EditText poids = null;
    private EditText taille = null;
    private TextView resultat = null;
    private CheckBox megaFonction = null;
    private RadioGroup unite = null;

    // Animation
    //Animation animTest;
    LayoutAnimationController animation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_test2);

        // Récupérer chaque vue nécessaire INCOMPLET
        bRAZ = (Button) findViewById(R.id.buttonRAZ);
        bIMC = (Button) findViewById(R.id.buttonIMC);

        poids = (EditText) findViewById(R.id.editText);
        taille = (EditText) findViewById(R.id.editText2);
        resultat = (TextView) findViewById(R.id.result);
        megaFonction = (CheckBox) findViewById(R.id.checkBox);
        unite = (RadioGroup) findViewById(R.id.radioGroup);

        // Assigner sa/ses variable d'écoute au bouton définie plus bas : Click et/ou Touch
        bRAZ.setOnClickListener(ListenerRAZ);
        bIMC.setOnClickListener(ListenerIMC);
        poids.addTextChangedListener(textWatcher);


        // load the animation
        //animTest = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.test_anim);

    }

    // Toutes les classes variables de classes anonymes pour surveiller les événements

    // Surveillance des editable text avec TextWatcher
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            resultat.setText(txtDefault);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private OnClickListener ListenerRAZ = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            poids.getText().clear();
            taille.getText().clear();
            resultat.setText(txtDefault);
            megaFonction.setChecked(false);
           // bRAZ.startAnimation(animTest);
        }
    };

    // Listener du bouton IMC
    private OnClickListener ListenerIMC = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            float t = Float.parseFloat(taille.getText().toString());
            if (!megaFonction.isChecked()) {
                if (t > 0) {
                    if (unite.getCheckedRadioButtonId() == R.id.radioButton2) {
                        t = t / 100;
                    } else if (unite.getCheckedRadioButtonId() != R.id.radioButton) {
                        Toast.makeText(Test.this, "Choisir une unité de taille", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    float p = Float.parseFloat(poids.getText().toString());
                    float imc = p / t;
                    resultat.setText("Votre IMC est égal à : " + Float.toString(imc));
                } else {
                    Toast.makeText(Test.this, "Entrez une taille correcte s'il-vous-plait", Toast.LENGTH_SHORT).show();
                }
            } else {
                resultat.setText(MegaString);
            }
        }
    };

    // Listener du bouton de la megafonction.
    private OnClickListener checkedListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            // On remet le texte par défaut si c'était le texte de la megafonction qui était écrit
            if(!((CheckBox)v).isChecked() && resultat.getText().equals(MegaString))
                resultat.setText(txtDefault);
        }
    };

}
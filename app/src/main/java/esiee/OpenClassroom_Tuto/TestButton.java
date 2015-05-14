package esiee.OpenClassroom_Tuto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.MotionEvent;
import android.widget.Button;
import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;

import esiee.foodsaver.R;

/**
 * Created by Florian.S on 06/05/2015.
 */
public class TestButton extends AppCompatActivity implements View.OnTouchListener {
    private Button b = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_button);

        b = (Button) findViewById(R.id.bouton);
        b.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
    Button bouton = (Button) view;

        // On récupère la largeur du bouton
        int largeur = bouton.getWidth();
        // On récupère la hauteur du bouton
        int hauteur = bouton.getHeight();

        // On récupère la coordonnée sur l'abscisse (X) de l'évènement
        float x = event.getX();
        // On récupère la coordonnée sur l'ordonnée (Y) de l'évènement
        float y = event.getY();

        // Puis on change la taille du texte selon la formule indiquée dans l'énoncé
        bouton.setTextSize(Math.abs(x - largeur / 2) + Math.abs(y - hauteur / 2));
        // Le toucher est fini, on veut continuer à détecter les touchers d'après
        return true;
    }
}


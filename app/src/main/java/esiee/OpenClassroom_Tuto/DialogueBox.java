package esiee.OpenClassroom_Tuto;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.widget.Toast;

import java.util.Calendar;

import esiee.foodsaver.R;


/**
 * Created by Florian.S on 10/05/2015.
 */


    public class DialogueBox extends AppCompatActivity implements View.OnClickListener {

    private Button b = null;
    int count = 0;
    private final static int IDENTIFIANT_BOITE_UN = 0;
    private final static int IDENTIFIANT_BOITE_DEUX = 1;
    private final static int DIALOG_ALERT = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_button);

        b = (Button) findViewById(R.id.bouton);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button bouton = (Button) view;
        if (count < 5) {
            showDialog(IDENTIFIANT_BOITE_UN);
            count = count + 1;
        } else if (count == 5) {
            showDialog(IDENTIFIANT_BOITE_DEUX);
            count = count + 1;
        }
        else{
            showDialog(DIALOG_ALERT);
        }
    }

    @Override
    public Dialog onCreateDialog(int identifiant) {
        Dialog box = null;
        switch (identifiant) {
            case IDENTIFIANT_BOITE_UN:
                box = new Dialog(this);
                box.setTitle("Création de la boite de dialogue");
                break;

            case IDENTIFIANT_BOITE_DEUX:
                box = new Dialog(this);
                box.setTitle("ET MOI ALORS !!!");
                break;

            case DIALOG_ALERT:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("This ends the activity");
                builder.setCancelable(true);
                builder.setPositiveButton("I agree", new OkOnClickListener());
                builder.setNegativeButton("No, no", new CancelOnClickListener());
                AlertDialog dialog = builder.create();
                dialog.show();
        }
        return box;
    }

    // Fonction appellée à chaque création de la box
    @Override
    public void onPrepareDialog(int id, Dialog dialog) {
        if (id == IDENTIFIANT_BOITE_UN && count >= 1) {
            dialog.setTitle("Count = " + count );
        }
    }

    private final class OkOnClickListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            DialogueBox.this.finish();
        }
    }

    private final class CancelOnClickListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getApplicationContext(), "Cancel selected, activity continues",
                    Toast.LENGTH_LONG).show();
        }
    }
}

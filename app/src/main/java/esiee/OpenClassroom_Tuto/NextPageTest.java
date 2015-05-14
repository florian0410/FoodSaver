package esiee.OpenClassroom_Tuto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import esiee.foodsaver.R;
/**
 * Created by Florian on 13/05/2015.
 */
public class NextPageTest extends AppCompatActivity {

    public final static String BUTTONS = null;
    public final static int CHOOSE_BUTTON_REQUEST = 0;
    private Button mPasserelle = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transition_test);

        mPasserelle = (Button) findViewById(R.id.buttonNext);

        mPasserelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent secondeActivite = new Intent(NextPageTest.this, OrientationTest.class);
                // On associe l'identifiant à notre intent
                startActivityForResult(secondeActivite, CHOOSE_BUTTON_REQUEST);
            }
        });*/
                Uri telephone = Uri.parse("tel:0606060606");
                Intent secondeActivite = new Intent(Intent.ACTION_DIAL, telephone);
                startActivity(secondeActivite);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // On vérifie tout d'abord à quel intent on fait référence ici à l'aide de notre identifiant
        if (requestCode == CHOOSE_BUTTON_REQUEST) {
            // On vérifie aussi que l'opération s'est bien déroulée
            if (resultCode == RESULT_OK) {
                // On affiche le bouton qui a été choisi
                Toast.makeText(this, "Vous avez choisi le bouton " + data.getStringExtra(BUTTONS), Toast.LENGTH_SHORT).show();
            }
        }
    }
}

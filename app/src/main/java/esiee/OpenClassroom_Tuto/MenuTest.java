package esiee.OpenClassroom_Tuto;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;

import esiee.foodsaver.R;

/**
 * Created by Florian on 11/05/2015.
 */
public class MenuTest extends AppCompatActivity {
    private CheckBox item21 = null;
    private CheckBox item22 = null;
    private CheckBox item3 = null;
    private Menu m = null;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();

        //R.menu.menu est l'id de notre menu
        inflater.inflate(R.menu.test_menu, menu);
        m = menu;
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                //Dans le Menu "m", on active tous les items dans le groupe d'identifiant "R.id.group2"
                m.setGroupEnabled(R.id.group2, true);
                return true;
            case R.id.item3:
            case R.id.item7:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);   // Renvoi false car ne sait pas gérer l'item
        }
    }
}
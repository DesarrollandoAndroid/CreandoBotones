package desarrollandoandroid.creandobotones;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity {

    Button desAnd;
    RadioGroup radgroDesAnd;
    RadioButton radDesAnd;
    ImageButton imaDesAnd;
    ToggleButton togDesAnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        desAnd = (Button) findViewById(R.id.btDesAndWord);
        radgroDesAnd = (RadioGroup) findViewById(R.id.radioGroupDesAnd);
        imaDesAnd = (ImageButton) findViewById(R.id.imageButton);
        togDesAnd = (ToggleButton) findViewById(R.id.tbtDesAnd);


//Button
        desAnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.setData(Uri.parse("https://desarrollandoandroid.wordpress.com"));
                startActivity(intent);
            }
        });

// ImageButton
        imaDesAnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//RadioGroup y RadioButton
                int selectedId = radgroDesAnd.getCheckedRadioButtonId(); //Conseguimos el radioButton seleccionado dentro del radioGroup
                radDesAnd = (RadioButton) findViewById(selectedId);    //Buscamos el ID del radioButton seleccionado.

                Toast.makeText(MainActivity.this, radDesAnd.getText(), Toast.LENGTH_LONG).show();
            }
        });

//ToggleButton
        togDesAnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(togDesAnd.isChecked()){
                    Toast.makeText(getApplicationContext(), R.string.toggleButton1, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), R.string.toggleButton2, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

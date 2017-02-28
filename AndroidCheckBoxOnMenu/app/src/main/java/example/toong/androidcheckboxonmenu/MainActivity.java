package example.toong.androidcheckboxonmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        CheckBox checkBox = (CheckBox) menu.findItem(R.id.delete).getActionView();

        ImageButton locButton = (ImageButton) menu.findItem(R.id.menu_find).getActionView();

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);

        CheckBox checkBox = (CheckBox) menu.findItem(R.id.delete).getActionView();

        ImageButton locButton = (ImageButton) menu.findItem(R.id.menu_find).getActionView();

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        return true;
    }
}

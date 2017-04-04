package example.toong.understandmenuoptionmenucontextmenupopupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button contextMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contextMenu = (Button) findViewById(R.id.contextMenu);
        registerForContextMenu(contextMenu);

        final Button btnPopupMenu = (Button) findViewById(R.id.popupMenu);
        btnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnPopupMenu, Gravity.RIGHT);
                popupMenu.inflate(R.menu.menu_main);
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);
    }
}
package com.example.lihh.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


public class ActionBaActivity extends Activity {

    ActionBar actionBar;
    TextView textView;
    Button btnpopUpMenu;
    PopupMenu popUpMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_ba);

        textView = (TextView) findViewById(R.id.tv);
        btnpopUpMenu = (Button) findViewById(R.id.popUpMenu);
        actionBar = getActionBar();
//        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setHomeButtonEnabled(true);
//        actionBar.setDisplayOptions(ActionBar.NAVIGATION_MODE_STANDARD);
//        actionBar.setDisplayHomeAsUpEnabled(true);

        registerForContextMenu(textView);

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "长摁textview", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        btnpopUpMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUpMenu = new PopupMenu(getApplicationContext(), v);
                getMenuInflater().inflate(R.menu.contextmenu, popUpMenu.getMenu());
                popUpMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                popUpMenu.show();
            }
        });
    }

    public void showAction(View view) {
        actionBar.show();
        Toast.makeText(getApplicationContext(), "显示actionbar", Toast.LENGTH_SHORT).show();
    }

    public void hideAction(View view) {
        actionBar.hide();
        Toast.makeText(getApplicationContext(), "隐藏actionbar", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextmenu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        switch (item.getItemId()) {
            case R.id.font_color_red:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                break;
            case R.id.font_color_blue:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                break;
            case android.R.id.home:
                Toast.makeText(getApplicationContext(), "单击home键", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        Toast.makeText(getApplicationContext(),
                "onOptionsItemSelected:" + item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    public void onItemClick(MenuItem menuItem) {
        Toast.makeText(getApplicationContext(),
                "onItemClick:" + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
    }
}

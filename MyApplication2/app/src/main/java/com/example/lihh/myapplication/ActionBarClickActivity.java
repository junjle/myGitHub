package com.example.lihh.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;


public class ActionBarClickActivity extends Activity {

    ActionBar actionBar;
    private ShareActionProvider shareactionprovider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_click);

        actionBar = getActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem menuItem = menu.findItem(R.id.share_item);
        ActionProviderTest actionproviderTest = new ActionProviderTest(getApplicationContext());
        menuItem.setActionProvider(actionproviderTest);
//        shareactionprovider = (ShareActionProvider)menuItem.getActionProvider();
//        Intent shareIntent=getShareIntent();
//        shareactionprovider.setShareIntent(shareIntent);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public Intent getShareIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "这里是要分享的文字");
        intent.setType("text/plain");
        Intent.createChooser(intent, "Share");
        return intent;
    }

    class ActionProviderTest extends android.view.ActionProvider {
        private Context mContext;
        /**
         * Creates a new instance.
         *
         * @param context Context for accessing resources.
         */
        public ActionProviderTest(Context context) {
            super(context);
            mContext = context;
        }

        /**
         * Factory method for creating new action views.
         *
         * @return A new action view.
         */
        @Override
        public View onCreateActionView() {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            View view = layoutInflater.inflate(R.layout.action_provider, null);
            TextView tv = (TextView)view.findViewById(R.id.tvShow);
            tv.setText("ShowResult");
            Toast.makeText(getApplicationContext(), "show", Toast.LENGTH_SHORT).show();
            Button btn = (Button)view.findViewById(R.id.btn_show);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }
    }
}

package com.gilang.androidintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class CallIntentsActivity extends ActionBarActivity {

    private Spinner spinner1;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_intents);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.intents, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        btnStart = (Button)findViewById(R.id.button_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = spinner1.getSelectedItemPosition();
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.9gag.com"));
                        break;
                    case 1:
                        intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+62)83824455955"));
                        break;
                    case 2:
                        intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+62)83824455955"));
                        break;
                    case 3:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:50.123,7.1434?z=19"));
                        break;
                    case 4:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=query"));
                        break;
                    case 5:
                        intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        break;
                    case 6:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                        break;
                    case 7:
                        intent = new Intent(Intent.ACTION_EDIT, Uri.parse("content://contacts/people/1"));
                        break;

                }
                if (intent != null)
                    startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            String result = data.toUri(0);
            Toast.makeText(this, result, Toast.LENGTH_LONG);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_call_intents, menu);
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
}

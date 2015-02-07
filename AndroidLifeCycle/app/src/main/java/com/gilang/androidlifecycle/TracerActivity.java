package com.gilang.androidlifecycle;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class TracerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notify("onCreate");
    }

    @Override
    protected void onPause(){
        super.onPause();
        notify("onPause");
    }

    @Override
    protected void onResume(){
        super.onResume();
        notify("onResume");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        notify("onDestroy");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        notify("onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        notify("onSaveInstanceState");
    }

    private void notify(String methodName){
        String className = this.getClass().getName();
        String[] strings = className.split("\\.");
        Notification notif = new Notification.Builder(this)
                               .setContentTitle(methodName + " " + strings[strings.length-1])
                               .setAutoCancel(true)
                               .setSmallIcon(R.drawable.ic_launcher)
                               .setContentText(className).build();
        NotificationManager notifManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notifManager.notify((int)System.currentTimeMillis(), notif);
    }

    @Override
    protected void onStop(){
        super.onStop();
        notify("onStop");
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

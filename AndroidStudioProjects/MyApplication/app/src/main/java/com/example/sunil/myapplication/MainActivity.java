package com.example.sunil.myapplication;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import com.amazonaws.mobileconnectors.amazonmobileanalytics.*;


public class MainActivity extends AppCompatActivity {

    private static MobileAnalyticsManager analytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  //  Poc



        try {
           analytics = MobileAnalyticsManager.getOrCreateInstance(this.getApplicationContext(),getResources().getString(R.string.APP_ID), getResources().getString(R.string.COGNITO_IDENTITY_POOL));

            AnalyticsEvent event = analytics.getEventClient().createEvent("LevelComplete")
                    .withAttribute("xyz", "XYZ")
                    .withAttribute("abc", "ABC").withMetric("intVal",1.0);


            analytics.getEventClient().recordEvent(event);



        }
        catch (InitializationException  ex)
        {
            Log.d("Android","This sld not happen , Logcat message");
        }





        //






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

    @Override
    protected void onResume() {
        super.onResume();
        analytics.getSessionClient().resumeSession();
    }

    @Override
    protected void onPause() {
        super.onPause();
        analytics.getSessionClient().pauseSession();
        analytics.getEventClient().submitEvents();
    }

    public void HelloXYZ(View view) {

       Intent intent = new Intent(this, HelloXYZ.class);
        startActivity(intent);
    }


}

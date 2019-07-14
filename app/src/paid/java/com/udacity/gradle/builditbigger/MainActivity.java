package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.app.androidjokes.JokeActivity;
import com.udacity.gradle.builditbigger.IdlingResource.EspressoIdlingResource;

import java.util.concurrent.ExecutionException;

//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    public void tellJoke(View view) {
        EspressoIdlingResource.increment();
        Intent intent = new Intent(MainActivity.this, JokeActivity.class);
        intent.putExtra("joke", getJokes());
        startActivity(intent);

        EspressoIdlingResource.decrement();
    }


public String getJokes(){

//    Jokes jokes = new Jokes();
//    String joke = jokes.getJokes();
//    return joke;

    String joke = "";
    try {
        joke = new EndPointsAsyncTask().execute(new Pair<Context, String>(this, "hi")).get();
//joke = "paid joke";
    } catch (InterruptedException e) {
        e.printStackTrace();
    } catch (ExecutionException e) {
        e.printStackTrace();
    }
    return joke;
}


    @Override
    public void onResume() {
        super.onResume();
    }
}

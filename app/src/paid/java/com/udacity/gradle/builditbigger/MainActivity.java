package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.app.androidjokes.JokeActivity;
import com.udacity.gradle.builditbigger.IdlingResource.EspressoIdlingResource;

import java.util.concurrent.ExecutionException;

//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

public ProgressBar mProgressBar;
private TextView mTextView;
private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
mProgressBar = findViewById(R.id.pb_loading_indicator);
mTextView = findViewById(R.id.instructions_text_view);
mButton = findViewById(R.id.tellJoke_bn);

mProgressBar.setVisibility(View.INVISIBLE);
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
        mProgressBar.setVisibility(View.VISIBLE);
        mTextView.setVisibility(View.INVISIBLE);
        mButton.setVisibility(View.INVISIBLE);

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
        mProgressBar.setVisibility(View.INVISIBLE);
        mTextView.setVisibility(View.VISIBLE);
        mButton.setVisibility(View.VISIBLE);

    }
}

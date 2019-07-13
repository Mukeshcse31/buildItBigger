package com.google.app.androidjokes;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class JokeActivity extends AppCompatActivity {

    TextView joke_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        joke_tv = findViewById(R.id.joke);
        String joke = getIntent().getStringExtra("joke");
        joke_tv.setText(joke);

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onBackPressed(){
        finish();
    }
    @Override
    public void onPause() {
        super.onPause();
    }
}

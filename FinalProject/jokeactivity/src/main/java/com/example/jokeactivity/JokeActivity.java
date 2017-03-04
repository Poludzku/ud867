package com.example.jokeactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA = "joke_extra";
    public static final String AUTHOR_EXTRA = "author_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String joke = getIntent().getStringExtra(JOKE_EXTRA);
        String author = getIntent().getStringExtra(AUTHOR_EXTRA);
        if(!TextUtils.isEmpty(joke) && !TextUtils.isEmpty(author)){
            ((TextView) findViewById(R.id.joke_text)).setText(joke);
            ((TextView) findViewById(R.id.author_text)).setText(author);
        }

    }
}

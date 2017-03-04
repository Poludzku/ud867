package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jokeactivity.JokeActivity;

import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {
        new JokeLoaderAsyncTask() {
            @Override
            protected void onPostExecute(Joke joke) {
                Intent intent = new Intent(MainActivity.this, JokeActivity.class);
                intent.putExtra(JokeActivity.JOKE_EXTRA, joke.getData());
                intent.putExtra(JokeActivity.AUTHOR_EXTRA, joke.getAuthor());
                startActivity(intent);
            }
        }.executeOnExecutor(Executors.newFixedThreadPool(1));
    }

}

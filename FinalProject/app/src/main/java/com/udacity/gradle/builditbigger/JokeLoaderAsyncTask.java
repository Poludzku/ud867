package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;


public abstract class JokeLoaderAsyncTask extends AsyncTask<Void, Void, Joke> {

    private static OkHttpClient CLIENT;

    static {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        CLIENT = new OkHttpClient().newBuilder().addInterceptor(interceptor).build();

    }

    private static final Retrofit RETROFIT = new Retrofit.Builder()
            .baseUrl("https://poludzku-udacity-bib.appspot.com/_ah/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(CLIENT)
            .build();


    private static final JokeApi JOKE_SERVICE = RETROFIT.create(JokeApi.class);

    @Override
    protected Joke doInBackground(Void... voids) {
        try {
            return JOKE_SERVICE.loadAJoke().execute().body();
        } catch (Exception e) {
            Log.e("JokeLoaderAsyncTask", e.getMessage());
        }
        return null;
    }

    protected interface JokeApi {
        @POST("myApi/v1/sayHi")
        Call<Joke> loadAJoke();
    }
}

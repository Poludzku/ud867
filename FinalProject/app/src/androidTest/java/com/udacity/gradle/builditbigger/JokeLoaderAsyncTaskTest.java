package com.udacity.gradle.builditbigger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.CountDownLatch;


@RunWith(JUnit4.class)
public class JokeLoaderAsyncTaskTest {

    CountDownLatch countDownLatch = new CountDownLatch(1);
    @Test
    public void tellJoke() throws Exception {
        JokeLoaderAsyncTask systemUnderTest = new JokeLoaderAsyncTask() {
            @Override
            protected void onPostExecute(Joke joke) {
                Assert.assertEquals(joke.getAuthor(),"Me");
                Assert.assertNotNull(joke.getData());
                countDownLatch.countDown();
            }

            @Override
            protected void onCancelled() {
                Assert.fail("Unexpected onCancelled() called!");
            }

            @Override
            protected void onCancelled(Joke joke) {
                Assert.fail("Unexpected onCancelled(Joke joke) called! :"+joke);
            }
        };
        systemUnderTest.execute();
        while (countDownLatch.getCount() > 0){
            Thread.sleep(1000);
        }

    }

}
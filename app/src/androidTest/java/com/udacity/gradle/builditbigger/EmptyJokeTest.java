package com.udacity.gradle.builditbigger;

import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EmptyJokeTest
{
    //https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework/5722193#5722193

    @Test
    public void testAsyncTask() throws Throwable
    {
        // create  a signal to let us know when our task is done.
        final CountDownLatch signal = new CountDownLatch(1);

        final EndPointsAsyncTask myTaskInterface = new EndPointsAsyncTask(new EndpointsAsyncTaskInterface()
        {
            @Override
            public void returnJokeData(String result)
            {
//                Log.i("result", result);
                assertNotNull(result);
                signal.countDown();
            }
        });

        myTaskInterface.execute();

        signal.await(30, TimeUnit.SECONDS);
    }
}
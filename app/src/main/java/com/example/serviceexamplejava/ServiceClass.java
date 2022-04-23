package com.example.serviceexamplejava;

import static android.content.ContentValues.TAG;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;


public class ServiceClass extends Service {

    static final String Tag = "ServiceClass";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        String CurrentThread = Thread.currentThread().getName();
        Log.d(TAG, "onCreate: " + CurrentThread);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String CurrentThread = Thread.currentThread().getName();
        Log.d(TAG, "onStartCommand: " +CurrentThread);

        /*
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

         */

        AsyncTaskingClass asyncTaskingClass = new AsyncTaskingClass();
        asyncTaskingClass.execute(10000);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        String CurrentThread = Thread.currentThread().getName();
        Log.d(TAG, "onDestroy: " + CurrentThread);
        super.onDestroy();
    }



    class AsyncTaskingClass extends AsyncTask<Integer,Void,Void>{
        private static final String TAG = "AsyncTaskingClass";

        public AsyncTaskingClass() {
            super();
        }

        @Override
        protected void onPreExecute() {
            String CurrentThread = Thread.currentThread().getName();

            Log.d(TAG, "onPreExecute: " + CurrentThread);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void unused) {
            String CurrentThread = Thread.currentThread().getName();

            Log.d(TAG, "onPostExecute: " + CurrentThread );
            super.onPostExecute(unused);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            String CurrentThread = Thread.currentThread().getName();

            Log.d(TAG, "onProgressUpdate: " + CurrentThread);
            super.onProgressUpdate(values);
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            String CurrentThread = Thread.currentThread().getName();
            Log.d(TAG, "doInBackground: " + CurrentThread);
            int sleepTime = integers[0];
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}

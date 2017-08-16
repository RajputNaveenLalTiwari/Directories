package com.example.workingondirectories;

import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";
    private String  dataDirectoy,cacheDirectory,systemDirectory;
    private String  externalDirectory,alarmPublicDirectory,dcimPublicDirectory,
                    downloadsPublicDirectory,moviesPublicDirectory,musicPublicDirectory,
                    notificationsPublicDirectory,picturesPublicDirectory,podcastsPublicDirectory,
                    ringtonesPublicDirectory;
    private String  cacheDir,filesDir,filesParent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*  System Directories  */
        dataDirectoy = Environment.getDataDirectory().getAbsolutePath();
        cacheDirectory = Environment.getDownloadCacheDirectory().getAbsolutePath();
        systemDirectory = Environment.getRootDirectory().getAbsolutePath();

//        Log.i(TAG,"Data Directory = "   +dataDirectoy);
//        Log.i(TAG,"Cache Directory = "  +cacheDirectory);
//        Log.i(TAG,"System Directory = " +systemDirectory);

        /*  Internal Storage Directories    */
        externalDirectory = Environment.getExternalStorageDirectory().getAbsolutePath();
        alarmPublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS).getAbsolutePath();
        dcimPublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
        downloadsPublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        moviesPublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath();
        musicPublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath();
        notificationsPublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS).getAbsolutePath();
        picturesPublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
        podcastsPublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS).getAbsolutePath();
        ringtonesPublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getAbsolutePath();

//        Log.i(TAG,"External Directory = " +externalDirectory);
//        Log.i(TAG,"ALARM Directory = " +alarmPublicDirectory);
//        Log.i(TAG,"DCIM Directory = " +dcimPublicDirectory);
//        Log.i(TAG,"DOWNLOADS Directory = " +downloadsPublicDirectory);
//        Log.i(TAG,"MOVIES Directory = " +moviesPublicDirectory);
//        Log.i(TAG,"MUSIC Directory = " +musicPublicDirectory);
//        Log.i(TAG,"NOTIFICATIONS Directory = " +notificationsPublicDirectory);
//        Log.i(TAG,"PICTURES Directory = " +picturesPublicDirectory);
//        Log.i(TAG,"PODCASTS Directory = " +podcastsPublicDirectory);
//        Log.i(TAG,"RINGTONES Directory = " +ringtonesPublicDirectory);

        /*  Application Directories     */
        cacheDir = getCacheDir().getAbsolutePath();
        filesDir = getFilesDir().getAbsolutePath();
        filesParent = getFilesDir().getParent();

//        Log.i(TAG,"Cache Directory = " +cacheDir);
//        Log.i(TAG,"Files Directory = " +filesDir);
//        Log.i(TAG,"FilesParent Directory = " +filesParent);

        /*  Application Internal storage directories    */
//        Log.i(TAG,"getExternalCacheDir() = " +getExternalCacheDir().getAbsolutePath());
//        Log.i(TAG,"getExternalFilesDir(null) = " +getExternalFilesDir(null).getAbsolutePath());
//        Log.i(TAG,"getExternalFilesDir(Environment.DIRECTORY_ALARMS) = " +getExternalFilesDir(Environment.DIRECTORY_ALARMS).getAbsolutePath());
//        Log.i(TAG,"getExternalFilesDir(Environment.DIRECTORY_DCIM) = " +getExternalFilesDir(Environment.DIRECTORY_DCIM).getAbsolutePath());
//        Log.i(TAG,"getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) = " +getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
//        Log.i(TAG,"getExternalFilesDir(Environment.DIRECTORY_MOVIES) = " +getExternalFilesDir(Environment.DIRECTORY_MOVIES).getAbsolutePath());
//        Log.i(TAG,"getExternalFilesDir(Environment.DIRECTORY_MUSIC) = " +getExternalFilesDir(Environment.DIRECTORY_MUSIC).getAbsolutePath());
//        Log.i(TAG,"getExternalFilesDir(Environment.DIRECTORY_NOTIFICATIONS) = " +getExternalFilesDir(Environment.DIRECTORY_NOTIFICATIONS).getAbsolutePath());
//        Log.i(TAG,"getExternalFilesDir(Environment.DIRECTORY_PICTURES) = " +getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath());
//        Log.i(TAG,"getExternalFilesDir(Environment.DIRECTORY_PODCASTS) = " +getExternalFilesDir(Environment.DIRECTORY_PODCASTS).getAbsolutePath());
//        Log.i(TAG,"getExternalFilesDir(Environment.DIRECTORY_RINGTONES) = " +getExternalFilesDir(Environment.DIRECTORY_RINGTONES).getAbsolutePath());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            File[] files = getExternalFilesDirs(null);
            for (File file:files)
            {
                if(file!=null)
                Log.i("Files",""+file.getAbsolutePath());
            }
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT)
        {
            File[] files = getExternalCacheDirs();
            for (File file:files)
            {
                if(file!=null)
                Log.i("Caches",""+file.getAbsolutePath());
            }
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
        {
            File[] files = getExternalMediaDirs();
            for (File file:files)
            {
                if(file!=null)
                Log.i("MediaDirs",""+file.getAbsolutePath());
            }
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT)
        {
            File[] files = getObbDirs();
            for (File file:files)
            {
                if(file!=null)
                Log.i("ObbDirs",""+file.getAbsolutePath());
            }
        }
    }
}

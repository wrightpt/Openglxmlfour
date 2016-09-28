package com.example.c.openglxmlfour;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.view.Surface;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.

    public  GLSurfaceView mGLView;

   // LocalService mService;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //createStreamingMediaPlayer(getResources()


        if (Build.VERSION.SDK_INT >= 23) {
            if (!Settings.canDrawOverlays(MainActivity.this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, 1234);
            }
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             //   Intent intent = new Intent(MainActivity.this, surfaceglservice.class);
            //    bindService(intent, mConnection, Context.BIND_AUTO_CREATE);

                startService(new Intent(MainActivity.this, surfaceglservice.class));
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Example of a call to a native method
        // TextView tv = (TextView) findViewById(R.id.sample_text);
        // tv.setText(stringFromJNI());


        FloatingActionButton fabb = (FloatingActionButton) findViewById(R.id.fab1);
        fabb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                getWindowManager().removeView(mGLView);

                //   startService(new Intent(MainActivity.this, surfaceglservice.class));
                //   Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //           .setAction("Action", null).show();
            }
        });



    //private ServiceConnection mConnection = new ServiceConnection() {

     //   @Override
      //  public void onServiceConnected(ComponentName className,
      //                                 IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
     //       LocalBinder binder = (LocalBinder) service;
      //      mService = binder.getService();
      //      mBound = true;
      //  }

       // @Override
       // public void onServiceDisconnected(ComponentName arg0) {
       //     mBound = false;
       // }
    };

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

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
   // public native String stringFromJNI();

   /// static {
     //   System.loadLibrary("native-codec-jni");
   // }
  // public native String getMsgFromJni();

    public static native void rewindStreamingMediaPlayer();
    public static native boolean createStreamingMediaPlayer(AssetManager assetMgr, String filename);
    public static native void setPlayingStreamingMediaPlayer(boolean isPlaying);
    public static native void shutdown();
    public static native void setSurface(Surface surface);
    //public  native boolean createStreamingMediaPlayer() ;
  //      return createStreamingMediaPlayer(,);
  //  }

  //  public static native boolean createStreamingMediaPlayer(AssetManager assetMgr, String filename);
    // new code done
} // class MainActivity
   // public native String stringFromJNI1();


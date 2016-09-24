package com.example.c.openglxmlfour;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.VideoView;

public class surfaceglservice extends Service {
    public surfaceglservice() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        //chatHead = new ImageView(this);

        // chatHead.setImageResource(R.drawable.floating);

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                // WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                PixelFormat.TRANSLUCENT);

        //  params.gravity = Gravity.TOP | Gravity.LEFT;
        //   params.x = 0;
        //   params.y = 100;

        LayoutInflater li = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View mTopView =  li.inflate(R.layout.videoviewlayout, null);

        GLSurfaceView mGLView;
        mGLView = new MyGLSurfaceView(this);
      //  VideoView videoView =
      //          (VideoView) mTopView.findViewById(R.id.videoview);
      //  String vidAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
      //  Uri vidUri = Uri.parse(vidAddress);
      //  videoView.setVideoURI(vidUri);


        windowManager.addView(mTopView, params);
       // videoView.start();
        // MediaController vidControl = new MediaController(this);

    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

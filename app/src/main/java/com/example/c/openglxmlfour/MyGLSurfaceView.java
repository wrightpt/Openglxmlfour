package com.example.c.openglxmlfour;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import static android.view.MotionEvent.INVALID_POINTER_ID;

/**
 * Created by c on 9/23/16.
 */

public class MyGLSurfaceView extends GLSurfaceView {

    private  MyGLRenderer mRenderer;

    public MyGLSurfaceView(Context context) {
        super(context);


       // setEGLContextClientVersion(2);

        // Set the Renderer for drawing on the GLSurfaceView
       // mRenderer = new MyGLRenderer();
      //  setRenderer(mRenderer);

        // Render the view only when there is a change in the drawing data
       // setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    public MyGLSurfaceView(Context context, AttributeSet attrs) {
       super(context, attrs);



    }

    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mLastTouchX;
    private float mLastTouchY;



    private int mActivePointerId = INVALID_POINTER_ID;


  @Override
   public boolean onTouchEvent(MotionEvent e) {

      ScaleGestureDetector mScaleDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.OnScaleGestureListener() {
          @Override
          public boolean onScale(ScaleGestureDetector detector) {
              return false;
          }

          @Override
          public boolean onScaleBegin(ScaleGestureDetector detector) {
              return false;
          }

          @Override
          public void onScaleEnd(ScaleGestureDetector detector) {

          }
      });
      mScaleDetector.onTouchEvent(e);

      final int action = MotionEventCompat.getActionMasked(e);

      switch (action) {
          case MotionEvent.ACTION_DOWN: {
              final int pointerIndex = MotionEventCompat.getActionIndex(e);
              final float x = MotionEventCompat.getX(e, pointerIndex);
              final float y = MotionEventCompat.getY(e, pointerIndex);

              // Remember where we started (for dragging)
              mLastTouchX = x;
              mLastTouchY = y;
              // Save the ID of this pointer (for dragging)
              mActivePointerId = MotionEventCompat.getPointerId(e, 0);
              break;
          }

          case MotionEvent.ACTION_MOVE: {
              // Find the index of the active pointer and fetch its position
              final int pointerIndex =
                      MotionEventCompat.findPointerIndex(e, mActivePointerId);

              final float x = MotionEventCompat.getX(e, pointerIndex);
              final float y = MotionEventCompat.getY(e, pointerIndex);

              // Calculate the distance moved
              final float dx = x - mLastTouchX;
              final float dy = y - mLastTouchY;

            float   mPosX = 0;
               float   mPosY = 0;
              mPosX+= dx;
              mPosY += dy;

              invalidate();

              // Remember this touch position for the next move event
              mLastTouchX = x;
              mLastTouchY = y;

              break;
          }

          case MotionEvent.ACTION_UP: {
              mActivePointerId = INVALID_POINTER_ID;
              break;
          }

          case MotionEvent.ACTION_CANCEL: {
              mActivePointerId = INVALID_POINTER_ID;
              break;
          }

          case MotionEvent.ACTION_POINTER_UP: {

              final int pointerIndex = MotionEventCompat.getActionIndex(e);
              final int pointerId = MotionEventCompat.getPointerId(e, pointerIndex);

              if (pointerId == mActivePointerId) {
                  // This was our active pointer going up. Choose a new
                  // active pointer and adjust accordingly.
                  final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                  mLastTouchX = MotionEventCompat.getX(e, newPointerIndex);
                  mLastTouchY = MotionEventCompat.getY(e, newPointerIndex);
                  mActivePointerId = MotionEventCompat.getPointerId(e, newPointerIndex);
              }
              break;
          }
      }
      return true;
  }























    // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

     //float x = e.getX();
    //  float y = e.getY();

      // switch (e.getAction()) {
         //  case MotionEvent.ACTION_MOVE:

           //     float dx = x - mPreviousX;
            //   float dy = y - mPreviousY;

                // reverse direction of rotation above the mid-line
            //   if (y > getHeight() / 2) {
            //       dx = dx * -1 ;
             //   }

                // reverse direction of rotation to left of the mid-line
             //   if (x < getWidth() / 2) {
             //      dy = dy * -1 ;
             //  }

            //    mRenderer.setAngle(
//                        mRenderer.getAngle() +
                             //   ((dx + dy) * TOUCH_SCALE_FACTOR));  // = 180.0f / 320
              //  requestRender();
      //  }

       // mPreviousX = x;
       // mPreviousY = y;
       // return true;
    }





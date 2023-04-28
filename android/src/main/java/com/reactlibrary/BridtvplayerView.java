package com.reactlibrary;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.react.ReactActivity;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;

import tv.brid.sdk.api.BridPlayer;
import tv.brid.sdk.api.BridPlayerBuilder;

public class BridtvplayerView extends FrameLayout implements LifecycleEventListener {

    private static final String TAG = "BridtvplayerView";

    private final ReactApplicationContext mAppContext;
    private ThemedReactContext mThemedReactContext;
    static ReactActivity mActivity;
    Window mWindow;
    private ViewGroup mRootView;

    private BridPlayer bridPlayer;
    ViewGroup mPlayerViewContainer;




    public BridtvplayerView(ThemedReactContext reactContext, ReactApplicationContext appContext) {
        super(getNonBuggyContext(reactContext, appContext));
        Log.d("LOGGG", "Kreirao View");
        mAppContext = appContext;
        mThemedReactContext = reactContext;
        mActivity = (ReactActivity) getActivity();
        if (mActivity != null) {
            mWindow = mActivity.getWindow();
        }
        mRootView = mActivity.findViewById(android.R.id.content);

        getReactContext().addLifecycleEventListener(this);

        mPlayerViewContainer = (ViewGroup) mRootView.getParent();

        // Remove the JWPlayerView from the list item.
        if (mPlayerViewContainer != null) {
            mPlayerViewContainer.removeView(mRootView);
        }

        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mRootView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        mPlayerViewContainer.addView(mRootView);

        bridPlayer = new BridPlayerBuilder(appContext,(FrameLayout) mRootView).build();


    }


    private static Context getNonBuggyContext(ThemedReactContext reactContext,
                                              ReactApplicationContext appContext) {
        Context superContext = reactContext;
        if (!contextHasBug(appContext.getCurrentActivity())) {
            superContext = appContext.getCurrentActivity();
        } else if (contextHasBug(superContext)) {
            // we have the bug! let's try to find a better context to use
            if (!contextHasBug(reactContext.getCurrentActivity())) {
                superContext = reactContext.getCurrentActivity();
            } else if (!contextHasBug(reactContext.getApplicationContext())) {
                superContext = reactContext.getApplicationContext();
            } else {
                // ¯\_(ツ)_/¯
            }
        }
        return superContext;
    }

    public void loadVideo(int playerid, int videoid, boolean autoplay){

        bridPlayer.loadVideo(playerid, videoid);
        bridPlayer.play();
        bridPlayer.setAutoPlay(autoplay);
    }

    public Activity getActivity() {
        if (!contextHasBug(mAppContext.getCurrentActivity())) {
            return mAppContext.getCurrentActivity();
        } else if (contextHasBug(mThemedReactContext)) {
            if (!contextHasBug(mThemedReactContext.getCurrentActivity())) {
                return mThemedReactContext.getCurrentActivity();
            } else if (!contextHasBug(mThemedReactContext.getApplicationContext())) {
                return (Activity) mThemedReactContext.getApplicationContext();
            }
        }

        return mThemedReactContext.getReactApplicationContext().getCurrentActivity();
    }


    private static boolean contextHasBug(Context context) {
        return context == null ||
                context.getResources() == null ||
                context.getResources().getConfiguration() == null;
    }
    public ReactApplicationContext getAppContext() {
        return mAppContext;
    }

    public ThemedReactContext getReactContext() {
        return mThemedReactContext;
    }

    @Override
    public void onHostResume() {

    }

    @Override
    public void onHostPause() {

    }

    @Override
    public void onHostDestroy() {

    }

    public void toastMessage(String message) {

        Toast.makeText(getNonBuggyContext(getReactContext(),getAppContext()),message,Toast.LENGTH_LONG);
    }
}

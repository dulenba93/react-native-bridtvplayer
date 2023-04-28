package com.reactlibrary;

import static com.facebook.react.bridge.UiThreadUtil.runOnUiThread;

import android.content.Context;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;


public class BridtvplayerModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext mReactContext;
    private static final String TAG = "BridtvplayerModule";



    BridtvplayerModule(ReactApplicationContext context) {
        super(context);
        mReactContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void createBridSdkEvent(String name, String location) {
        Log.d("RunTest1", "Usao u metodu");


        Context context = getReactApplicationContext();

        FrameLayout frameLayout = new FrameLayout(context);

        runOnUiThread(new Runnable(){

            @Override
            public void run() {
//                Log.d("RunTest", "Usao u metodu");
//                BridPlayer bridPlayer = new BridPlayerBuilder(context,frameLayout).build();
//                bridPlayer.loadVideo(38794, 511771);
//                bridPlayer.play();
            }
        });

        Toast.makeText(context, "test", Toast.LENGTH_LONG).show();

    }

    @ReactMethod
    public void createBridPlayer() {
//        Context context = getCurrentActivity().getApplicationContext();
//        FrameLayout frameLayout = getCurrentActivity().findViewById(R.id.frame_layout_player);
//        BridPlayerBuilder builder = new BridPlayerBuilder(context, frameLayout);
//        bridPlayer = builder.build();
//        bridPlayer.loadVideo(38794, 511771);
//        bridPlayer.play();
    }

    @ReactMethod
    public void play() {
//        bridPlayer.play();
    }

    @ReactMethod
    public void loadVideo(final int reactTag, final int playerID, final int videoID){
        try{
            Toast.makeText(mReactContext, "LoadVideo", Toast.LENGTH_LONG).show();

            UIManagerModule uiManager = mReactContext.getNativeModule(UIManagerModule.class);
            uiManager.addUIBlock(new UIBlock() {
                @Override
                public void execute(NativeViewHierarchyManager nvm) {
//                    RnBridPlayerView playerView = (RnBridPlayerView) nvm.resolveView(reactTag);
//
//                    //if null provera
//
//                    BridPlayer bridPlayer = new BridPlayerBuilder(mReactContext, playerView).build();
//                    bridPlayer.loadVideo(playerID, videoID);
//                    bridPlayer.play();
                }
            });

        }catch (IllegalViewOperationException e){
            throw  e;
        }
    }
}
// BridtvplayerManager.java

package com.reactlibrary;


import android.util.Log;
import android.view.ViewManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BridtvplayerManager extends ViewGroupManager<BridtvplayerView> {

    public static final String REACT_CLASS = "RnBridPlayerView";
    private static final String TAG = "RnBridPlayerViewManager";
    private final ReactApplicationContext mAppContext;

    public final int COMMAND_CREATE = 1;



    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }
    public BridtvplayerManager(ReactApplicationContext context) {
        mAppContext = context;
    }


    @NonNull
    @Override
    protected BridtvplayerView createViewInstance(@NonNull ThemedReactContext themedReactContext) {
        return new BridtvplayerView(themedReactContext, mAppContext);
    }

    /**
     * Map the "create" command to an integer
     */
    @Nullable
    @Override
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("create", COMMAND_CREATE);
    }


    /**
     * Handle "create" command (called from JS) and call createFragment method
     */

    @Override
    public void receiveCommand(@NonNull BridtvplayerView root, String commandId, @Nullable ReadableArray args) {
        super.receiveCommand(root, commandId, args);
        int reactNativeViewId = args.getInt(0);
        int commandIdInt = Integer.parseInt(commandId);
        switch (commandIdInt) {
            case COMMAND_CREATE:
//                createFragment(root, reactNativeViewId);
                break;
            default: {}
        }
    }

    @ReactProp(name = "videoconfig")
    public void setLoadVideo(BridtvplayerView view, ReadableMap prop) {
        int playerId = 0,videoId = 0;
        boolean autoplay = false;
        try {
            playerId = Integer.parseInt(prop.getString("playerid"));
            videoId = Integer.parseInt(prop.getString("videoid"));
            autoplay = prop.getBoolean("autoplay");


            view.loadVideo(playerId, videoId, autoplay);

        } catch (NumberFormatException e){
            view.toastMessage(e.getMessage());
        }
        Log.d("testLoad", prop.toString());
        Toast.makeText(mAppContext,prop.toString(),Toast.LENGTH_LONG);

//        view.loadVideo(playerId, videoId, autoplay);
    }

}

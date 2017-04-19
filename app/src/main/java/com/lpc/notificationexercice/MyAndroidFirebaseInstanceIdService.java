package com.lpc.notificationexercice;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by lpc on 19/04/17.
 */

public class MyAndroidFirebaseInstanceIdService extends FirebaseInstanceIdService {
    public static final String TAG="MyAndroidFMCMIIDService";
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken= FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Refreshed token:"+refreshedToken);

    }
}

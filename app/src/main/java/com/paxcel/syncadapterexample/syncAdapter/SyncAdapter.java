package com.paxcel.syncadapterexample.syncAdapter;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

/**
 * The real magic happens here.
 * This is adapter that will be called when system decide it is time to sync data.
 *
 */
public class SyncAdapter extends AbstractThreadedSyncAdapter {

    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        System.out.println("******* onPerformSync new *******");
        System.out.println("*****************************");
        Log.e("SyncAdapter","onPerformSync demo example");
    }

}
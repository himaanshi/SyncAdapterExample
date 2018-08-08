package com.paxcel.syncadapterexample.syncAdapter;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;


public class SyncAdapterManager {
    public static final String AUTHORITY    = "com.example.paxcel.syncadapterexample.provider";
    public static final String ACCOUNT_TYPE = "com.example.paxcel.syncadapterexample";
    public static final String ACCOUNT      = "dummyaccount";
    private static Account newAccount;

    public static void init(Context context) {
        newAccount = new Account(ACCOUNT, ACCOUNT_TYPE);
        AccountManager accountManager = (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);
        if (accountManager.addAccountExplicitly(newAccount, null, null)) {
            Log.e("SyncAdapterManager","in if");
        } else {
            Log.e("SyncAdapterManager","in else");

        }

        ContentResolver.setSyncAutomatically(newAccount, AUTHORITY, true);
    }

    public static void forceRefresh() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);

        ContentResolver.requestSync(newAccount, AUTHORITY, bundle);
    }
}

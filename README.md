# SyncAdapterExample

Synchronizing data between an Android device and web servers can make your application significantly more useful 
and compelling for your users. For example, transferring data to a web server makes a useful backup, and transferring 
data from a server makes it available to the user even when the device is offline. In some cases, users may find it
easier to enter and edit their data in a web interface and then have that data available on their device, 
or they may want to collect data over time and then upload it to a central storage area.

## Create a stub authenticator

public class StubAuthenticator extends AbstractAccountAuthenticator {

    public StubAuthenticator(Context context) {
        super(context);
    }

    @Override
    public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse,
                                 String s) {

        throw new UnsupportedOperationException();
    }

    @Override
    public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String s,
                             String s2, String[] strings, Bundle bundle) throws NetworkErrorException {

        return null;
    }

    @Override
    public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse,
                                     Account account, Bundle bundle) throws NetworkErrorException {

        return null;
    }

    @Override
    public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse,
                               Account account, String s, Bundle bundle) throws NetworkErrorException {

        throw new UnsupportedOperationException();
    }

    @Override
    public String getAuthTokenLabel(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse,
                                    Account account, String s, Bundle bundle) throws NetworkErrorException {

        throw new UnsupportedOperationException();
    }

    @Override
    public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse,
                              Account account, String[] strings) throws NetworkErrorException {

        throw new UnsupportedOperationException();
    }
}

* Bind the authenticator to the framework (By creating a bound Service for it)

public class StubAuthenticatorService extends Service {
    private StubAuthenticator authenticator;

    @Override
    public void onCreate() {
        authenticator = new StubAuthenticator(this);
    }

    /*
    * When the system binds to this Service to make the RPC call
    * return the authenticator’s IBinder.
    */
    @Override
    public IBinder onBind(Intent intent) {
        return authenticator.getIBinder();
    }
}

## Create a stub content provider

public class StubContentProvider extends ContentProvider {
    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] columns, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }

}

## Create a sync adapter

public class SyncAdapter extends AbstractThreadedSyncAdapter {

    SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        Log.e("SyncAdapter", " In onPerformSync demo example");
    }

}

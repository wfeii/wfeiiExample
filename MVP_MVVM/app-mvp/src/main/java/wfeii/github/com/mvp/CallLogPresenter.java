package wfeii.github.com.mvp;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.widget.Adapter;

import java.lang.ref.WeakReference;

/**
 * Created by wangfei on 16-9-14.
 */
public class CallLogPresenter {

    private WeakReference<ICallLogView> mCallLogViewReference;

    private CallLogPresenter(ICallLogView callLogView) {
        mCallLogViewReference = new WeakReference<>(callLogView);
    }

    public static CallLogPresenter getInstance(ICallLogView callLogView){
        return new CallLogPresenter(callLogView);
    }

    private static final int CALLS  = 1;
    public Loader createLoader(Context context){
        CallLogLoader.CallLogParameterBuilder builder = new CallLogLoader.CallLogParameterBuilder();
        builder.uri = CallLog.CONTENT_URI;
        return new CallLogLoader(context, builder);
    }
    public void initLoader(final Context context, LoaderManager loaderManager) {
        loaderManager.initLoader(CALLS, null, new LoaderManager.LoaderCallbacks<Cursor>() {
            @Override
            public Loader<Cursor> onCreateLoader(int id, Bundle args) {
                return createLoader(context.getApplicationContext());
            }

            @Override
            public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
                ICallLogView callLogView = mCallLogViewReference.get();
                if (callLogView != null) {
                    callLogView.changeCursor(data);
                }
            }

            @Override
            public void onLoaderReset(Loader<Cursor> loader) {

            }
        });
    }

    public Adapter createAdapter(){

    }

}

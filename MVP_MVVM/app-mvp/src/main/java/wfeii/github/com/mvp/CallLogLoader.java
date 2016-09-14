package wfeii.github.com.mvp;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.AsyncTaskLoader;

/**
 * Created by wangfei on 16-9-14.
 */
public class CallLogLoader extends AsyncTaskLoader<Cursor> {

    private CallLogParameterBuilder mBuilder;

    public CallLogLoader(Context context, @NonNull CallLogParameterBuilder builder) {
        super(context);
        mBuilder = builder;
    }

    @Override
    public Cursor loadInBackground() {
        return getContext().getContentResolver().query(mBuilder.uri,
                mBuilder.projection, mBuilder.selection, mBuilder.selectionArgs, mBuilder.sortOrder);
    }

    public static class CallLogParameterBuilder {
        Uri uri;
        String[] projection;
        String selection;
        String[] selectionArgs;
        String sortOrder;
    }
}

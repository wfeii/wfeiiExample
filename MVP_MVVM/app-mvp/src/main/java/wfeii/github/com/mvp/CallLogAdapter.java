package wfeii.github.com.mvp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by wangfei on 16-9-14.
 */
public class CallLogAdapter extends CursorAdapter {
    public CallLogAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.call_log_item, viewGroup);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textView = (TextView) view.findViewById(R.id.callLogNumber);
        String number = cursor.getString(0);
        textView.setText(number);
    }
}

package wfeii.github.com.mvp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements  ICallLogView{

    private CallLogPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = CallLogPresenter.getInstance(this);
        mPresenter.initLoader(this, getSupportLoaderManager());
    }

    @Override
    public void changeCursor(Cursor cursor) {

    }
}

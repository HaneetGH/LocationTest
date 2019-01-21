package technorapper.com.locationtest;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcelable;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationContract.View {
    TextView txtLat, txtLog;
    Button btnFetch;
    Bundle bundle = new Bundle();
    LocationPresenter mPresenter;

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.bind();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unbind();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        conenctUI();
        initEvents();
        MyApplication nMyApplication = (MyApplication) getApplication();
        nMyApplication.onActivityCreated(MainActivity.this, bundle);
        if (GlobalConfiguration.isSystemHasLocation) {
            mPresenter = new LocationPresenter(MainActivity.this, getApplicationContext());
        }
    }

    private void initEvents() {
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication nMyApplication = (MyApplication) getApplication();
                nMyApplication.onActivityCreated(MainActivity.this, bundle);
                if (GlobalConfiguration.isSystemHasLocation) {
                    mPresenter = new LocationPresenter(MainActivity.this, getApplicationContext());
                }
            }
        });
    }

    private void conenctUI() {
        txtLat = (TextView) findViewById(R.id.textViewlat);
        txtLog = (TextView) findViewById(R.id.textViewlog);
        btnFetch = (Button) findViewById(R.id.button);

    }

    @Override
    public void setMessage(Location message) {
        txtLat.setText(message.getLatitude() + "");
        txtLog.setText(message.getLongitude() + "");
    }
}

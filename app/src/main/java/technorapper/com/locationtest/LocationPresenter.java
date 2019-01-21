package technorapper.com.locationtest;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import static android.content.Context.LOCATION_SERVICE;

public class LocationPresenter implements LocationContract.Presenter {
    LocationModel mModel;
    LocationContract.View mView;
    private Context context;


    public LocationPresenter(LocationContract.View view, Context applicationContext) {
        this.mView = view;
        this.context = applicationContext;

    }

    @Override
    public void bind() {
        mModel = new LocationModel(mView, context);
        mView.setLocation(mModel.generateLocation());

    }

    @Override
    public void unbind() {
        mModel = null;
        mView = null;
    }


}

package technorapper.com.locationtest;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

public class Utils {

    public static Location getLastKnownLocation(Context context, Activity activity, LocationManager locationManager, LocationListener listener) {
        Location lastKnownLocation = null;
        String locationProvider = LocationManager.NETWORK_PROVIDER;
// Or, use GPS location data:
// String locationProvider = LocationManager.GPS_PROVIDER;
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            try {
                locationManager.requestLocationUpdates(locationProvider, 0, 0, (android.location.LocationListener) listener);
                locationProvider = LocationManager.NETWORK_PROVIDER;
            } catch (Exception e) {
                // Or use LocationManager.GPS_PROVIDER
            }
            lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
        }
        return lastKnownLocation;
    }
}

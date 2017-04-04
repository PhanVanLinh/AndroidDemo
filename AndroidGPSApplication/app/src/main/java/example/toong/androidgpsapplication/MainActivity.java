package example.toong.androidgpsapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_FINE_LOCATION = 111;
    private TextView longLatTv;

    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;

    private LocationManager mLocationManager;
    private FusedLocationListener mFusedLocationListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        longLatTv = (TextView) findViewById(R.id.textview_longlat);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, // Activity
                    new String[] { Manifest.permission.ACCESS_FINE_LOCATION },
                    MY_PERMISSIONS_REQUEST_FINE_LOCATION);
        }
        mFusedLocationListener = new FusedLocationListener();

        startFusedLocation();

        findViewById(R.id.force).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopFusedLocation();
                registerRequestUpdate();
            }
        });
    }

    @Override
    protected void onStop() {
        stopFusedLocation();
        super.onStop();
    }

    public void startFusedLocation() {
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this).addApi(LocationServices.API)
                    .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                        @Override
                        public void onConnected(Bundle bundle) {
                            registerRequestUpdate();
                        }

                        @Override
                        public void onConnectionSuspended(int i) {

                        }
                    })
                    .build();
            mGoogleApiClient.connect();
        } else {
            mGoogleApiClient.connect();
        }
    }

    public void stopFusedLocation() {
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient,
                mFusedLocationListener);

        if (mGoogleApiClient != null) {
            mGoogleApiClient.disconnect();
        }
    }

    public void registerRequestUpdate() {
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(500); // every second
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest,
                mFusedLocationListener);
    }

    private class FusedLocationListener
            implements com.google.android.gms.location.LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            LogLocation.printLocation(location, longLatTv, "Service: ");
        }
    }
}
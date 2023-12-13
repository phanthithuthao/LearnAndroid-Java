package vn.edu.stu.demogooglemap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AboutActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);


        // Add a marker in Sydney and move the camera
        LatLng stu = new LatLng(10.738176385767881, 106.67776772272026);
        mMap.addMarker(
                new MarkerOptions()
                        .position(stu)
                        .title("Marker in STU")
                        .snippet("Đây la trường đại học STU")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker1))

        );
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(stu,17));
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(stu )      // Sets the center of the map to Mountain View
                .zoom(17)                   // Sets the zoom
                .bearing(90)                // Sets the orientation of the camera to east
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
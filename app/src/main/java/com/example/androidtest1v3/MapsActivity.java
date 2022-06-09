package com.example.androidtest1v3;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.example.androidtest1v3.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    private Marker newyork,a,b,c,d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Newyork and move the camera
        LatLng newyork = new LatLng(40.71, -74.00);
        mMap.addMarker(new MarkerOptions().position(newyork).title("New York"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(newyork));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(newyork, 8f));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                setMarker(latLng);

            }
        });




    }

    public  void setMarker(LatLng latLng){

      //  MarkerOptions options = new MarkerOptions();


        MarkerOptions options = new MarkerOptions().position(latLng).title("A");
     Marker a =   mMap.addMarker(options);
     drawLine();




    }

    public  void drawLine(){
        PolylineOptions options = new PolylineOptions().
                color(Color.GREEN)
                .width(10)
                .clickable(true)
                .width(10)
                .add(a.getPosition(), newyork.getPosition());
        mMap.addPolyline(options);


    }

    public static String getMarkerTitle(int count){
        switch (count){
            case 1:
                return "A";
            case 2 :
                return "B";
            case 3 :
                return "c";

            case 4 :
                return "D";


            default:
                return "";
        }

    }






}
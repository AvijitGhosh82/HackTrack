package in.avijitghosh.hacktrack;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class OrderDetails extends AppCompatActivity implements LocationListener {


        private GoogleMap mMap; // Might be null if Google Play services APK is not available.
        String name,amt,addrs,lat,lng;

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_order_details, menu);
            return super.onCreateOptionsMenu(menu);
        }

/*RequestInterceptor requestInterceptor = new RequestInterceptor() {
        @Override
        public void intercept(RequestInterceptor.RequestFacade request) {
            SharedPreferences pref = getSharedPreferences("MyPref", MODE_PRIVATE);
            String token = pref.getString("token", null);
            request.addHeader("Authorization", "Token "+token);
        }
    };
    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(BASE_URL)
            .setRequestInterceptor(requestInterceptor)
            .build();
    MyApiEndpointInterface apiService =
            restAdapter.create(MyApiEndpointInterface.class);*/

        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub

        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_call:
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:7797710022"));
                    startActivity(callIntent);
                                      return true;

                default:
                    return super.onOptionsItemSelected(item);
            }

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub

        }


        @Override
        public void onLocationChanged(Location location) {

            mMap.clear();

            MarkerOptions mp = new MarkerOptions();

            mp.position(new LatLng(location.getLatitude(), location.getLongitude()));

            mp.title("my position");

            mMap.addMarker(mp);

            if(lat!=null & lng!=null)

            {mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.deliver))
                    .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                    .position(new LatLng(Double.parseDouble(lat), Double.parseDouble(lng))));

                /*Polyline line = mMap.addPolyline(new PolylineOptions()
                        .add(new LatLng(location.getLatitude(), location.getLongitude()), new LatLng(Double.parseDouble(lat), Double.parseDouble(lng)))
                        .width(3)
                        .color(Color.BLUE));*/


            }



            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(location.getLatitude(), location.getLongitude()), 15));



        }




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_order_details);

            LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);


            setUpMapIfNeeded();
            Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
            if (toolbar != null) {
                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }

            Bundle extras = getIntent().getExtras();
            if(extras!= null) {
                name= extras.getString("name");
                addrs= extras.getString("addr");
                amt= extras.getString("amt");
                lat= extras.getString("lat");
                lng= extras.getString("lng");

            }





            TextView addr=(TextView)findViewById(R.id.addr);
            addr.setText(addrs);


            TextView nam=(TextView)findViewById(R.id.name);
            nam.setText(name);

            TextView amnt=(TextView)findViewById(R.id.amt);
            amnt.setText("Rs. " + amt);




        }

        public void next(View v)
        {
            Intent ii=new Intent(OrderDetails.this, ConfirmActivity.class);


            startActivity(ii);
        }

        @Override
        protected void onResume() {
            super.onResume();
            setUpMapIfNeeded();
        }

        /**
         * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
         * installed) and the map has not already been instantiated.. This will ensure that we only ever
         * call {@link #setUpMap()} once when {@link #mMap} is not null.
         * <p/>
         * If it isn't installed {@link SupportMapFragment} (and
         * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
         * install/update the Google Play services APK on their device.
         * <p/>
         * A user can return to this FragmentActivity after following the prompt and correctly
         * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
         * have been completely destroyed during this process (it is likely that it would only be
         * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
         * method in {@link #onResume()} to guarantee that it will be called.
         */
        private void setUpMapIfNeeded() {
            // Do a null check to confirm that we have not already instantiated the map.
            if (mMap == null) {
                // Try to obtain the map from the SupportMapFragment.
                mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                        .getMap();
                // Check if we were successful in obtaining the map.
                if (mMap != null) {
                    setUpMap();
                }
            }
        }

        /**
         * This is where we can add markers or lines, add listeners or move the camera. In this case, we
         * just add a marker near Africa.
         * <p/>
         * This should only be called once and when we are sure that {@link #mMap} is not null.
         */
        private void setUpMap() {
        /*mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
               new LatLng(12.9294436, 77.5296793), 16));



        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.docmark))
                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                .position(new LatLng(12.9294436, 77.5296793)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.docmark))
                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                .position(new LatLng(12.9270024,77.5273032)));*/

            mMap.addMarker(new MarkerOptions()
                    // .icon(BitmapDescriptorFactory.fromResource(R.mipmap.docmark))
                    .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                    .position(new LatLng(22.3164453, 87.3002152)));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(22.3164453, 87.3002152),15));


        }



    }

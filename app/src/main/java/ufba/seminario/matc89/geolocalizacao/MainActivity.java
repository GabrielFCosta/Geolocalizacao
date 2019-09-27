package ufba.seminario.matc89.geolocalizacao;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;
import static android.location.Criteria.POWER_LOW;

/*
MainActivity precisa inmplementar interface LocationListener para métodos
requestSingleUpdate() e requestLocationUpdates() aceitarem "this" como
parâmetro.
 */
public class MainActivity extends Activity implements LocationListener{

    private TextView latText;
    private TextView lngText;
    private TextView altText;
    private LocationManager locationMan;
    private String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latText = (TextView) findViewById(R.id.latitude);
        lngText = (TextView) findViewById(R.id.longitude);
        altText = (TextView) findViewById(R.id.altitude);

        try {
            locationMan = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            criteria.setPowerRequirement(POWER_LOW);
            criteria.setAltitudeRequired(true);
            provider = locationMan.getBestProvider(criteria,true);

            locationMan.requestLocationUpdates(provider, 10000, 0, this);
            //locationMan.requestSingleUpdate(provider,this,null);

        } catch (SecurityException e) {
            Toast.makeText(this,"no suitable permission is present.", Toast.LENGTH_SHORT).show();
        } catch(IllegalArgumentException e){
            Toast.makeText(this,"provider or listener is null or doesn't exist.", Toast.LENGTH_SHORT).show();
        }
    }
    //Métodos da interface LocationListener.
    public void onLocationChanged(Location location) {}
    public void onStatusChanged(String provider, int status, Bundle extras) {}
    public void onProviderEnabled(String provider) {}
    public void onProviderDisabled(String provider) {}

    //Método do botão
    public void ShowLocation(View v){
        try {
            Location location = locationMan.getLastKnownLocation (provider);

            if(location != null) {
                double lng = location.getLongitude();
                double lat = location.getLatitude();
                double alt =location.getAltitude();
                latText.setText(String.format(Locale.getDefault(),"%f",lat));
                lngText.setText(String.format(Locale.getDefault(), "%f", lng));
                altText.setText(String.format(Locale.getDefault(), "%f", alt));
            }
            else
                Toast.makeText(this,"nenhuma localização disponível.", Toast.LENGTH_SHORT).show();

        } catch (SecurityException e) {
            Toast.makeText(this,"no suitable permission is present.", Toast.LENGTH_SHORT).show();
        } catch(IllegalArgumentException e){
            Toast.makeText(this,"provider or listener is null or doesn't exist.", Toast.LENGTH_SHORT).show();
        }
    }


}

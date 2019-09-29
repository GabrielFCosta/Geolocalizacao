package ufba.seminario.matc89.geolocalizacao;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;
import static android.location.Criteria.POWER_LOW;

public class MainActivity extends Activity implements LocationListener{

    private TextView latText;
    private TextView lngText;
    private TextView altText;
    private Button press;
    private LocationManager locationMan;
    private String provider;

    double lng;
    double lat;
    double alt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latText = findViewById(R.id.latitude);
        lngText = findViewById(R.id.longitude);
        altText = findViewById(R.id.altitude);
        press = findViewById(R.id.button);
        press.setText(R.string.wait);
        press.setEnabled(false);

        locationMan = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setPowerRequirement(POWER_LOW);
        criteria.setCostAllowed(false);
        criteria.setAltitudeRequired(true);
        provider = locationMan.getBestProvider(criteria,true);

        try {

            locationMan.requestLocationUpdates(provider, 5000, 0, this);
            //locationMan.requestSingleUpdate(provider,this,null);

        } catch (SecurityException e) {
            Toast.makeText(this,"SecurityException", Toast.LENGTH_LONG ).show();

        } catch(IllegalArgumentException e){
            Toast.makeText(this,"Habilite permissão para localização e renicie aplicativo.", Toast.LENGTH_LONG).show();
        }

    }

    //Métodos da interface LocationListener.
    /*
    Atualiza variáveis de latitude, longitude, altura e habilita botão
    a cada atualização da localização.
    */
    public void onLocationChanged(Location location) {
        lng = location.getLongitude();
        lat = location.getLatitude();
        alt =location.getAltitude();
        press.setText(R.string.press);
        press.setEnabled(true);

    }
    public void onStatusChanged(String provider, int status, Bundle extras) {}
    public void onProviderEnabled(String provider) {}
    public void onProviderDisabled(String provider) {}

    //Método do botão
    /*
    Apresenta localização e desabilita botão (até a próxima atualização
    da localização).
     */
    public void ShowLocation(View v){
        latText.setText(String.format(Locale.getDefault(),"%f",lat));
        lngText.setText(String.format(Locale.getDefault(), "%f", lng));
        altText.setText(String.format(Locale.getDefault(), "%f", alt));
        press.setText(R.string.wait);
        press.setEnabled(false);
    }

}

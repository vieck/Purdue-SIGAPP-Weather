package weather.vieck.purdue.edu.weather;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    protected Fragment weatherForecastFragment = new WeatherForecastFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        //Inflate Weather Fragment
        getFragmentManager().beginTransaction().add(R.id.container, weatherForecastFragment).commit();

        Refresh.JSONWeatherTask task = new Refresh.JSONWeatherTask();
        task.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main__weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Switch to preference fragment
        if (item.getItemId() == R.id.settings_menu) {
            //getFragmentManager().beginTransaction().replace(R.id.container, new SettingsActivity()).commit();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}

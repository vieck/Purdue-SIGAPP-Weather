package weather.vieck.purdue.edu.weather;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import static weather.vieck.purdue.edu.weather.ServerInput.downloadJSON;


public class MainActivity extends FragmentActivity {

    private final String currentWeather = "http://api.openweathermap.org/data/2.5/weather?q=West%20Lafayette&units=imperial";

    private static String forecastDaysNum = "3";
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        JSONWeatherTask task = new JSONWeatherTask();
        task.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main__weather, menu);
        return true;
    }

    private class JSONWeatherTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            downloadJSON(currentWeather);
            return null;
        }

    }
}

package weather.vieck.purdue.edu.weather;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

import static weather.vieck.purdue.edu.weather.ServerInput.downloadJSON;

/**
 * Created by Michael on 1/31/2015.
 */
public class Refresh {

    private static final String currentWeather = "http://api.openweathermap.org/data/2.5/weather?q=West%20Lafayette&units=imperial";
    private static String IMG_URL = "http://openweathermap.org/img/w/";
    private static byte[] byteArray;

    static class JSONWeatherTask extends AsyncTask<String, WeatherForecastFragment, Void> {

        @Override
        protected Void doInBackground(String... params) {
            downloadJSON(currentWeather);
            updateData();
            return null;
        }

        @Override
        protected void onPostExecute(Void parameter) {
            updateUI();
        }
    }

    protected static void updateData() {
        JSONParser parserClass = new JSONParser();
        GetImage imageDownloader = new GetImage();
        String RESULT_ICON_STRING = parserClass.getResult_icon();
        Drawable weatherConditionIcon = imageDownloader.downloadImage(IMG_URL + RESULT_ICON_STRING + ".png");
        parserClass.setIconData(weatherConditionIcon);
        Log.d("Debug", "Image Bitmap URL: " + IMG_URL + RESULT_ICON_STRING + ".png");
    }

    protected static void updateUI() {
        WeatherForecastFragment weatherFragment = new WeatherForecastFragment();
        JSONParser parserClass = new JSONParser();
        Drawable weatherConditionIcon = parserClass.getIconData();
        if (weatherConditionIcon != null) {
            weatherFragment.imgView.setBackground(weatherConditionIcon);
        }
        weatherFragment.temp.setText("" + parserClass.getResult_temp());
        weatherFragment.hum.setText("" + parserClass.getResult_humidity());
        weatherFragment.press.setText("" + parserClass.getResult_pressure());
        weatherFragment.windSpeed.setText("" + parserClass.getResult_speed());
        weatherFragment.windDeg.setText("" + parserClass.getResult_degree());
    }
}

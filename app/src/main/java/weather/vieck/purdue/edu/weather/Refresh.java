package weather.vieck.purdue.edu.weather;

import android.graphics.Bitmap;
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

    static class JSONWeatherTask extends AsyncTask<String, WeatherForecastFragment, JSONParser> {

        @Override
        protected JSONParser doInBackground(String... params) {
            downloadJSON(currentWeather);
            JSONParser parser = updateData();
            return parser;
        }

        @Override
        protected void onPostExecute(JSONParser parser) {
            updateUI(parser);
        }
    }

    protected static JSONParser updateData() {
        JSONParser parserClass = new JSONParser();
        GetImage imageDownloader = new GetImage();
        String RESULT_ICON_STRING = parserClass.getResult_icon();
        Bitmap weatherConditionIcon = imageDownloader.downloadImage(IMG_URL + RESULT_ICON_STRING + ".png");
        parserClass.setIconData(weatherConditionIcon);
        Log.d("Debug", "Image Bitmap URL: " + IMG_URL + RESULT_ICON_STRING + ".png");
        return parserClass;
    }

    protected static void updateUI(JSONParser parserClass) {
        WeatherForecastFragment weatherFragment = new WeatherForecastFragment();
        Bitmap weatherConditionIcon = parserClass.getIconData();
        Log.d("Debug", "Bitmap Null? :" + weatherConditionIcon);
        if (weatherConditionIcon != null) {
            Log.d("Debug", "Weather Icon Set");
            weatherFragment.imgView.setImageBitmap(weatherConditionIcon);
        }
        weatherFragment.temp.setText("" + parserClass.getResult_temp());
        weatherFragment.hum.setText("" + parserClass.getResult_humidity());
        weatherFragment.press.setText("" + parserClass.getResult_pressure());
        weatherFragment.windSpeed.setText("" + parserClass.getResult_speed());
        weatherFragment.windDeg.setText("" + parserClass.getResult_degree());
    }
}

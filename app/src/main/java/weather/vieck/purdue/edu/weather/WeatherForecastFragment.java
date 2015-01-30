package weather.vieck.purdue.edu.weather;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Michael on 1/29/2015.
 */
public class WeatherForecastFragment extends Fragment {
    public TextView cityText;
    public TextView condDescr;
    public TextView temp;
    public TextView press;
    public TextView windSpeed;
    public TextView windDeg;
    public TextView unitTemp;
    public TextView hum;
    public ImageView imgView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dayforecast_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        cityText = (TextView) view.findViewById(R.id.cityText);
        condDescr = (TextView) view.findViewById(R.id.condDescr);
        temp = (TextView) view.findViewById(R.id.temp);
        hum = (TextView) view.findViewById(R.id.hum);
        press = (TextView) view.findViewById(R.id.press);
        windSpeed = (TextView) view.findViewById(R.id.windSpeed);
        windDeg = (TextView) view.findViewById(R.id.windDeg);
        imgView = (ImageView) view.findViewById(R.id.condIcon);
    }
}

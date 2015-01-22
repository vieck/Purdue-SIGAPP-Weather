package weather.vieck.purdue.edu.weather;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.os.Handler;

/**
 * Created by Michael on 1/21/2015.
 */
public class Weather_Fragment extends Fragment {
    Typeface weatherFont;

    TextView cityField;
    TextView updatedField;
    TextView detailsField;
    TextView currentTemperatureField;
    TextView weatherIcon;

    Handler handler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main__weather, container, false);
        cityField = (TextView) rootView.findViewById(R.id.title_text);
        updatedField = (TextView) rootView.findViewById(R.id.updated_text);
        detailsField = (TextView) rootView.findViewById(R.id.detail_field);
        currentTemperatureField = (TextView) rootView.findViewById(R.id.current_temp);
        weatherIcon = (TextView) rootView.findViewById(R.id.weather_icon);

        weatherIcon.setTypeface(weatherFont);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weather.ttf");
        updateWeatherData(new City(getActivity()).getCity());
    }

    private void updateWeatherData(final String city) {
        new Thread() {
            
        }
    }

    public Weather_Fragment() {
        handler = new Handler();
    }
}

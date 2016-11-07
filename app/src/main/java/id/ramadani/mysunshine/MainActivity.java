package id.ramadani.mysunshine;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                .add(R.id.container, new PlaceholderFragment())
                .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        public PlaceholderFragment() {
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ArrayList<String> weekForecast = new ArrayList<String>();
            weekForecast.add("Today - Sunny - 88/63");
            weekForecast.add("Tomorrow - Foggy - 70/46");
            weekForecast.add("Weds - Cloudy - 72/63");
            weekForecast.add("Thurs - Asteroids - 75/65");
            weekForecast.add("Fri - Heavy Rain - 65/56");
            weekForecast.add("Sat - HELP TRAPPED IN WEATHERSTATION - 60/51");
            weekForecast.add("Sun - Sunny - 80/68");

            ArrayAdapter<String> forecastAdapter = new ArrayAdapter<String>(
                // the current context
                getActivity(),
                // layout
                R.layout.list_item_forecast,
                // view
                R.id.list_item_forecast_textview,
                // list of data
                weekForecast
            );

            ListView listViewForecast = (ListView) rootView.findViewById(R.id.listview_forecast);
            listViewForecast.setAdapter(forecastAdapter);

            return rootView;
        }
    }
}

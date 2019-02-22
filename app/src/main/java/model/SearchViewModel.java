package model;

import android.arch.lifecycle.ViewModel;
import io.reactivex.Observable;
import network.WeatherApi;


public class SearchViewModel extends ViewModel {

    private static final String TAG = "RxVM";

    public  Observable<WeatherForecast> getWeather(String apiKey, String  latitude, String longitude) {

        final Observable<WeatherForecast> searchResults = WeatherApi.getWeatherApiservice().getWeatherDarkSky(apiKey, latitude, longitude);

        return searchResults;
    }
}

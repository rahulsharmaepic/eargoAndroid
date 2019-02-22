package network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApi {

    public static WeatherApiInterface weatherApiInterface;

    public static WeatherApiInterface getWeatherApiservice() {

        if (weatherApiInterface == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.darksky.net/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            weatherApiInterface = retrofit.create(WeatherApiInterface.class);

        }

        return weatherApiInterface;
    }

}
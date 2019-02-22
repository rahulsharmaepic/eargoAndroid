package network;

import io.reactivex.Observable;
import model.WeatherForecast;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherApiInterface {


    @GET("/forecast/{apikey}/{latitude},{longitude}?")
     Observable<WeatherForecast> getWeatherDarkSky(@Path("apikey") String apikey, @Path("latitude") String latitude,
                                                         @Path("longitude") String longitude);

}

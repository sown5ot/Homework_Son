package sonhoang.vn.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Son Hoang on 11/16/2017.
 */

public interface GetWeatherInterface {
    String APPID_KEY = "03bef65d95fc17708280c7cff950eeca";
    @GET("weather")
    Call<GetWeatherResponseJSON> getWeather(
        @Query("q") String location,
        @Query("APPID") String APPID
    );
}

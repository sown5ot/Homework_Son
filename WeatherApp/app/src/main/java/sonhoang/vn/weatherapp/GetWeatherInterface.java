package sonhoang.vn.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Son Hoang on 11/16/2017.
 */

public interface GetWeatherInterface {

    @GET("weather")
    Call<GetWeatherResponseJSON> getWeatherToday(
            @Query(GetWeatherStringQuery.location) String location,
            @Query(GetWeatherStringQuery.APPID) String appID
    );

    @GET("forecast")
    Call<GetWeatherResponseJSON> getWeatherForecast(
            @Query(GetWeatherStringQuery.location) String location,
            @Query(GetWeatherStringQuery.APPID) String appID
    );
}

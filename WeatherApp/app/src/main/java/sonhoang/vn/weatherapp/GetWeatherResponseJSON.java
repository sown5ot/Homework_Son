package sonhoang.vn.weatherapp;

import java.util.List;

/**
 * Created by Son Hoang on 11/16/2017.
 */

class GetWeatherResponseJSON {
    List<WeatherObj> weather;
    List<WeatherForecastObj> list;

    class WeatherObj{
        String id;
        String main;
        String description;
        String icon;
    }

    class WeatherForecastObj{
        String dt;
        List<WeatherObj> weather;
    }
}

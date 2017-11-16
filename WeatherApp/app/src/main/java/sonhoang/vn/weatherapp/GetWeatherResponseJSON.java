package sonhoang.vn.weatherapp;

import java.util.List;

/**
 * Created by Son Hoang on 11/16/2017.
 */

class GetWeatherResponseJSON {
    List<WeatherObj> weather;

    class WeatherObj{
        String id;
        String main;
        String description;
    }
}

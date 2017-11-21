package sonhoang.vn.weatherapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Son Hoang on 11/20/2017.
 */

class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastAdapter.WeatherForecastViewHolder> {
    List<GetWeatherResponseJSON.WeatherForecastObj> weathers;

    public WeatherForecastAdapter(List<GetWeatherResponseJSON.WeatherForecastObj> weathers) {
        this.weathers = weathers;
    }

    @Override
    public WeatherForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new WeatherForecastViewHolder(layoutInflater.inflate(R.layout.item_list_weather_forecast, parent, false));
    }

    @Override
    public void onBindViewHolder(WeatherForecastViewHolder holder, int position) {
        List<GetWeatherResponseJSON.WeatherObj> weatherForecastList = weathers.get(position).weather;
        for (GetWeatherResponseJSON.WeatherObj weatherObj : weatherForecastList)
            holder.setWeatherForecastData(weatherObj);

    }

    @Override
    public int getItemCount() {
        return weathers.size();
    }


    public class WeatherForecastViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_forecast)
        ImageView ivForecast;
        @BindView(R.id.tv_main_weather)
        TextView tvMainWeather;
        @BindView(R.id.tv_description)
        TextView tvDescription;

        public WeatherForecastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setWeatherForecastData(GetWeatherResponseJSON.WeatherObj weatherObj) {
            tvMainWeather.setText(weatherObj.main);
            tvDescription.setText(weatherObj.description);
            switch (weatherObj.main){
                case "Clear": ivForecast.setImageResource(R.drawable.weather_clear);
                break;
                case "Clouds": ivForecast.setImageResource(R.drawable.weather_clouds);
                break;
                case "Rain": ivForecast.setImageResource(R.drawable.weather_rain_day);
                break;
            }
        }
    }
}

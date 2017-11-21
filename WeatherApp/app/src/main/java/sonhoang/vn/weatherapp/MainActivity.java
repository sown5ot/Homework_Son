package sonhoang.vn.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.et_city) EditText etCity;
    @BindView(R.id.bt_search) Button btSearch;
    @BindView(R.id.tv_info) TextView tvInfo;
    @BindView(R.id.rv_weather_forecast)
    RecyclerView rvForecast;

    private WeatherForecastAdapter weatherForecastAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadCurrentWeather();
                loadForecastWeather();
            }
        });

    }

    private void loadForecastWeather() {
        GetWeatherInterface getWeatherInterface =
                RetrofitInstance.getInstance().create(GetWeatherInterface.class);
        getWeatherInterface.getWeatherForecast(etCity.getText().toString(), GetWeatherStringQuery.APPID_KEY).enqueue(new Callback<GetWeatherResponseJSON>() {
            @Override
            public void onResponse(Call<GetWeatherResponseJSON> call, Response<GetWeatherResponseJSON> response) {
                if (response.isSuccessful()) {
                    List<GetWeatherResponseJSON.WeatherForecastObj> weatherObjList = response.body().list;
                    weatherForecastAdapter = new WeatherForecastAdapter(weatherObjList);
                    rvForecast.setAdapter(weatherForecastAdapter);
                    rvForecast.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                } else {
                    Toast.makeText(MainActivity.this, "Not found location", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetWeatherResponseJSON> call, Throwable t) {

            }
        });
    }

    private void loadCurrentWeather() {
        GetWeatherInterface getWeatherInterface =
                RetrofitInstance.getInstance().create(GetWeatherInterface.class);
        getWeatherInterface.getWeatherToday(etCity.getText().toString(), GetWeatherStringQuery.APPID_KEY).enqueue(new Callback<GetWeatherResponseJSON>() {
            @Override
            public void onResponse(Call<GetWeatherResponseJSON> call, Response<GetWeatherResponseJSON> response) {
                if (response.isSuccessful()) {
                    List<GetWeatherResponseJSON.WeatherObj> weatherObjList = response.body().weather;
                    for (GetWeatherResponseJSON.WeatherObj weatherObj : weatherObjList) {
                        tvInfo.setText(weatherObj.description);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Not found location", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetWeatherResponseJSON> call, Throwable t) {

            }
        });
    }
}

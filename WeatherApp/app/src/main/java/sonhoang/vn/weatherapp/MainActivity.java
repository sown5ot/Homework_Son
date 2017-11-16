package sonhoang.vn.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText etCity;
    private Button btSearch;
    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCity = findViewById(R.id.et_city);
        btSearch = findViewById(R.id.bt_search);
        tvInfo = findViewById(R.id.tv_info);


        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetWeatherInterface getWeatherInterface =
                        RetrofitInstance.getInstance().create(GetWeatherInterface.class);
                getWeatherInterface.getWeather(etCity.getText().toString(), GetWeatherInterface.APPID_KEY).enqueue(new Callback<GetWeatherResponseJSON>() {
                    @Override
                    public void onResponse(Call<GetWeatherResponseJSON> call, Response<GetWeatherResponseJSON> response) {
                        if (response.isSuccessful()) {
                        List<GetWeatherResponseJSON.WeatherObj> weatherObjList = response.body().weather;
                            for (GetWeatherResponseJSON.WeatherObj weatherObj : weatherObjList) {
                                tvInfo.setText(weatherObj.description);
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Not found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<GetWeatherResponseJSON> call, Throwable t) {

                    }
                });
            }
        });

    }
}

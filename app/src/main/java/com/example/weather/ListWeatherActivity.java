package com.example.weather;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.adapter.WeathersAdapter;
import com.example.weather.model.Weather;
import com.example.weather.network.APIManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListWeatherActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Weather> listData;
    WeathersAdapter adaper;
    TextView tvStatus, tvTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_weathers);

        getListData();

        tvStatus = findViewById(R.id.tvStatus);
        tvTemperature = findViewById(R.id.tvTemperature);
        listData = new ArrayList<>();
        adaper = new WeathersAdapter(ListWeatherActivity.this, listData);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        recyclerView = findViewById(R.id.rcWeather);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adaper);


    }

    private void getListData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);
        service.getWeatherData().enqueue(new Callback<List<Weather>>() {
            @Override
            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {
                if (response.body() !=null){
                    listData = response.body();
                    adaper.reloadData(listData);

                    tvStatus.setText(listData.get(0).getIconPhrase());
                    tvTemperature.setText(String.valueOf(listData.get(0).getTemperature().getValue()));
                }
            }

            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t) {
                Toast.makeText(ListWeatherActivity.this, "Fail", Toast.LENGTH_LONG).show();
            }
        });
    }

}

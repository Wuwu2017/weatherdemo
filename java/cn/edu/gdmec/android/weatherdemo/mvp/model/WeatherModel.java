package cn.edu.gdmec.android.weatherdemo.mvp.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.edu.gdmec.android.weatherdemo.R;
import cn.edu.gdmec.android.weatherdemo.mvp.WeatherBean;
import cn.edu.gdmec.android.weatherdemo.mvp.utils.OkHttpUtils;

public class WeatherModel implements IWeatherModel {
    @Override
    public void loadWeather(String url, final ILoadListener loadListener) {
        OkHttpUtils.ResultCallback resultCallback=new OkHttpUtils.ResultCallback() {
            @Override
            public void getWeather(WeatherBean weatherBean) {
                loadListener.onSuccess(weatherBean);
            }

            @Override
            public void onFailure(Exception e) {
                loadListener.onFailur(e);
            }
        };
        OkHttpUtils.getResultCallback(url,resultCallback);
    }
}

package cn.edu.gdmec.android.weatherdemo.mvp.presenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.edu.gdmec.android.weatherdemo.R;
import cn.edu.gdmec.android.weatherdemo.mvp.View.IWeatherView;
import cn.edu.gdmec.android.weatherdemo.mvp.WeatherBean;
import cn.edu.gdmec.android.weatherdemo.mvp.model.ILoadListener;
import cn.edu.gdmec.android.weatherdemo.mvp.model.IWeatherModel;
import cn.edu.gdmec.android.weatherdemo.mvp.model.WeatherModel;

public class WeatherPresenter implements IWeatherPresenter,ILoadListener {

    private String url = "https://www.sojson.com/open/api/weather/json.shtml?city=";

    private IWeatherView iWeatherView;
    private IWeatherModel iWeatherModel;

    public WeatherPresenter(IWeatherView iWeatherView){
        this.iWeatherView = iWeatherView;
        this.iWeatherModel = new WeatherModel();
    }

    @Override
    public void loadWeather(String city) {
        iWeatherView.showProgress();
        iWeatherModel.loadWeather(url+city, this);
    }

    @Override
    public void onSuccess(WeatherBean bean) {
        iWeatherView.hideProgress();
        iWeatherView.showWeatherData(bean);
    }

    @Override
    public void onFailur(Exception e) {
        iWeatherView.hideProgress();
        iWeatherView.showLoadFailMsg(e);
    }
}

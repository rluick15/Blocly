package io.bloc.android.blocly;

import android.app.Application;

import io.bloc.android.blocly.api.DataSource;

public class BloclyApplication extends Application {

    private static BloclyApplication sharedInstance;
    private DataSource dataSource;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedInstance = this;
        dataSource = new DataSource();
    }

    public static BloclyApplication getSharedInstance() {
        return sharedInstance;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public static DataSource getSharedDataSource() {
        return BloclyApplication.getSharedInstance().getDataSource();
    }

}

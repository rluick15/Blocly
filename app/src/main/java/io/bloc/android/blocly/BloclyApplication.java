package io.bloc.android.blocly;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import io.bloc.android.blocly.api.DataSource;

public class BloclyApplication extends Application {

    private static BloclyApplication sharedInstance;
    private DataSource dataSource;
    private static String mPassword;
    private static String mUsername;
    private static SQLiteDatabase mDb;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedInstance = this;
        dataSource = new DataSource();
        mDb = getDatabase();
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

    public static void setPassword(String password) {
        mPassword = password;
    }

    public static void setUsername(String username) {
        mUsername = username;
    }

    public static String getPassword(String password) {
        return  mPassword;
    }

    public static String getUsername(String username) {
        return mUsername;
    }

    public static SQLiteDatabase getDatabase() {
        return mDb;
    }

}

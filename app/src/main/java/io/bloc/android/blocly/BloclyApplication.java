package io.bloc.android.blocly;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

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

        // #1
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .build();

// #2
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .defaultDisplayImageOptions(defaultOptions)
                .build();

        ImageLoader.getInstance().init(configuration);
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

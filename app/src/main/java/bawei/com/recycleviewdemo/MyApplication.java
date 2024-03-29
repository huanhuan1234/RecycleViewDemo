package bawei.com.recycleviewdemo;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * Created by Huangminghuan on 2017/5/23.
 */

public class MyApplication extends Application {


    public DbManager.DaoConfig config;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);

        x.Ext.setDebug(BuildConfig.DEBUG);
        initData();
        initImageLoad();
    }

    public void initData() {
        config = new DbManager.DaoConfig();
        config.setDbName("news.db");
        config.setDbVersion(1);
        config.setDbUpgradeListener(new DbManager.DbUpgradeListener() {
            @Override
            public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

            }
        });
    }
    private void initImageLoad(){
        String path = Environment.getExternalStorageDirectory() + "/imageload" ;

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(480, 800)//缓存图片最大的长和宽
                .threadPoolSize(2)//线程池的数量
                .threadPriority(4)
                .memoryCacheSize(2*1024*1024)//设置内存缓存区大小
                .diskCacheSize(20*1024*1024)//设置sd卡缓存区大小
//                .diskCache(new UnlimitedDiskCache(new File(path)))//自定义缓存目录
                .writeDebugLogs()//打印日志内容
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .build();
        ImageLoader.getInstance().init(config);
    }


}

package ap.com.photoview.glide;

import android.content.Context;
import android.os.Environment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.GlideModule;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class SimpleGlideModule implements GlideModule {

    //首先，我们需要一个实现了GlideModule接口的类，重写其中的方法来改变Glide的配置，然后让Glide在构造实例的过程中，读取这个类中的配置信息。
    //第一步：实现GlideModule接口
    //第二步：在AndroidManifest.xml中的<application>标签下定义<meta-data>，这样Glide才能知道我们定义了这么一个类，
    //       其中android:name是我们自定义的GlideModule的完整路径，而android:value就固定写死GlideModule。

    //注：由于Glide是通过反射的方法来实例化GlideModule对象的，因此自定义的GlideModule只能有一个无参的构造方法。
    //   支持配置多个GlideModule的，但是GlideModule的读取顺序并不能保证，因此，不要在多个GlideModule对同一个属性进行不同的配置。

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //.setMemoryCache(MemoryCache memoryCache)//内存缓存
        //.setBitmapPool(BitmapPool bitmapPool)//bitmap池
        //.setDiskCache(DiskCache.Factory diskCacheFactory)//磁盘缓存
        //.setDiskCacheService(ExecutorService service)//磁盘缓存服务
        //.setResizeService(ExecutorService service)//大小调整服务
        //.setDecodeFormat(DecodeFormat decodeFormat)//解码方式

        //定义缓存大小为100M
        int diskCacheSize = 100 * 1024 * 1024;

        //自定义 缓存路径
        String diskCachePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/GlideCache";

        //提高图片质量
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);

        //自定义磁盘缓存:这种缓存只有自己的app才能访问到
        // builder.setDiskCache( new InternalCacheDiskCacheFactory( context , diskCacheSize )) ;
        // builder.setDiskCache( new InternalCacheDiskCacheFactory( context , diskCachePath , diskCacheSize  )) ;

        //设置缓存路径 和 缓存大小
        //自定义磁盘缓存：这种缓存存在SD卡上，所有的应用都可以访问到
        builder.setDiskCache(new DiskLruCacheFactory(diskCachePath, diskCacheSize));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        //glide.register(GlideUrl.class, InputStream.class, new OkHttpGlideUrlLoader.Factory());
    }
}

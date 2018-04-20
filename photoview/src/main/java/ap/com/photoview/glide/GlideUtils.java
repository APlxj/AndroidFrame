package ap.com.photoview.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import ap.com.photoview.R;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class GlideUtils {


    public static void load_uri(Context context, final ImageView imageView, String uri) {
        /*ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, imageView.getWidth() / 2, imageView.getHeight() / 2);
        scaleAnimation.setDuration(5000);
        SimpleTarget<Bitmap> target = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                imageView.setImageBitmap(resource);
            }
        };*/
        Glide.with(context)
                .load(uri)
                .override(300, 300)//只有在设置了图片大小后才不会重复缓存
                //.fitCenter()
                //.centerCrop()
                //.asGif()
                //.asBitmap()
                //.placeholder(R.mipmap.ic_launcher) //设置占位图，在加载之前显示
                .error(R.drawable.ic_live_share_direction_p_p) //在图像加载失败时显示
                .skipMemoryCache(true)//内存缓存
                // DiskCacheStrategy.NONE: 不使用硬盘缓存
                // DiskCacheStrategy.SOURCE: 将原始图像缓存在硬盘中
                // DiskCacheStrategy.RESULT: 将显示出来大小的图像缓存在硬盘(默认缓存策略)
                // DiskCacheStrategy.ALL: 显示的图像和原始图像都会缓存
                .diskCacheStrategy(DiskCacheStrategy.RESULT) //硬盘缓存
                // Priority.LOW
                // Priority.NORMAL
                // Priority.HIGH
                // Priority.IMMEDIATE
                //.crossFade(5000)//默认动画，淡入淡出
                //.animate(scaleAnimation) //设置显示动画
                //.priority(Priority.HIGH)//优先级
                //.thumbnail(0.1f)//缩略图
                .into(imageView);
    }

    public static void load_drawzble(Context context, ImageView imageView, int drawableId) {
        Glide.with(context)
                .load(drawableId)
                .asBitmap()
                .skipMemoryCache(true)//内存缓存
                .diskCacheStrategy(DiskCacheStrategy.RESULT) //硬盘缓存
                .into(imageView);
    }

    public static void load_file(Context context, ImageView imageView, String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            Log.e("load_file", "文件不存在");
            return;
        }
        Glide.with(context)
                .load(filePath)
                .asBitmap()
                .into(imageView);
    }

    //下载图片
    public static void dpwnPic(final Context context, final List<String> paths, final Handler handler) {
        if (null == paths || paths.size() == 0) return;
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, Bitmap> map = new HashMap<String, Bitmap>();
                for (int k = 0; k < paths.size(); k++) {
                    String url = paths.get(k);
                    Bitmap bitmap = null;
                    try {
                        bitmap = Glide.with(context)
                                .load(url)
                                .asBitmap()
                                .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                                .get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    if (null != bitmap) {
                        String filePath = saveBitmapFile(bitmap, k);
                        map.put(filePath, bitmap);
                    }
                }
                Message message = new Message();
                message.obj = map;
                handler.sendMessage(message);
            }
        }).start();
    }

    private static String saveBitmapFile(Bitmap bmp, int k) {

        String path = Environment.getExternalStorageDirectory() + "/KMCloud/doubleScreen/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = "doubleScreenPic" + k + ".jpg";
        file = new File(path, fileName);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path + fileName;
    }
}

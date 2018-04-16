package ap.com.picasso;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class PicassoUtils {


    public static void loadImage(Context mContext, ImageView imageView, String uri) {
        Picasso.with(mContext)
                .load(uri)
                .placeholder(R.drawable.yjz)//加载过程中的图片显示
                .error(R.drawable.error)//加载失败中的图片显示
                .resize(500, 500)//裁剪图片尺寸
                .centerCrop()//设置图片圆角
                .into(imageView);
    }

}

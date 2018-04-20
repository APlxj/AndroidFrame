package ap.com.photoview.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ap.com.photoview.glide.GlideUtils;
import ap.com.photoview.R;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class ImgAdapter extends SuperAdapter<String> {

    public ImgAdapter(Activity activity) {
        super(activity);
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (null == view) {
            holder = new ViewHolder();
            view = LayoutInflater.from(mConText).inflate(R.layout.view_img, null);
            holder.img = view.findViewById(R.id.img);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        GlideUtils.load_uri(mConText, holder.img, getItem(i));
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = new ImageView(mConText);
                //imageView.setBackgroundResource(R.drawable.ic_live_share_direction_p_p);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(500, 600));
                new AlertDialog.Builder(mConText).setView(imageView).create().show();
                GlideUtils.load_uri(mConText, imageView, getItem(i));

            }
        });
        return view;
    }

    private class ViewHolder {
        ImageView img;
    }
}

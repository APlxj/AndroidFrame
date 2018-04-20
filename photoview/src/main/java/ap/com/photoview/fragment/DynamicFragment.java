package ap.com.photoview.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ap.com.photoview.R;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间： 2017/4/28.
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class DynamicFragment extends BaseFragment {

    public View view;
    private PhotoView iv_photo1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        iv_photo1 = (PhotoView) view.findViewById(R.id.iv_photo1);
        return view;
    }

    @Override
    protected void loadData() {
        try {
            iv_photo1.setImageDrawable(getResources().getDrawable(R.drawable.p4));
            iv_photo1.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float v, float v1) {

                }

                @Override
                public void onOutsidePhotoTap() {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

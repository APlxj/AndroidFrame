package ap.com.photoview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间： 2017/4/28.
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mData;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> mData) {
        super(fm);
        this.mData = mData;
    }

    public void reData(List<Fragment> mData) {
        if (null != mData) {
            this.mData.clear();
            this.mData.addAll(mData);
        }
    }

    @Override
    public Fragment getItem(int position) {
        if (null != mData)
            return mData.get(position);
        else return null;
    }

    @Override
    public int getCount() {
        if (null != mData)
            return mData.size();
        else return 0;
    }
}

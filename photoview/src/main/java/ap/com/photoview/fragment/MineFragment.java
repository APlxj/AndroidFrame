package ap.com.photoview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ap.com.photoview.R;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间： 2017/4/28.
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class MineFragment extends BaseFragment {

    public View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_mine, container, false);
        return view;
    }

    @Override
    protected void loadData() {

    }
}

package ap.com.photoview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ap.com.photoview.model.ImagePath;
import ap.com.photoview.R;
import ap.com.photoview.adapter.MessageAdapter;
import ap.com.photoview.model.MsgModel;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间： 2017/4/28.
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class HomeFragment extends BaseFragment {

    private MessageAdapter adapter = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ListView listview = view.findViewById(R.id.listview);
        if (adapter == null) {
            adapter = new MessageAdapter(getActivity());
            listview.setAdapter(adapter);
        }
        return view;
    }

    @Override
    protected void loadData() {
        List<MsgModel> msgModels = getMsgModel();
        adapter.putNewData(msgModels);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public List<MsgModel> getMsgModel() {
        List<MsgModel> msgModels = new ArrayList<>();
        String[] contens = getResources().getStringArray(R.array.contents);
        String[] titles = getResources().getStringArray(R.array.titles);
        for (int k = 0; k < titles.length; k++) {
            MsgModel msgModel = new MsgModel();
            msgModel.setTitle(titles[k]);
            msgModel.setContent(contens[k]);
            msgModel.setImgPaths(ImagePath.getPath(k));
            msgModels.add(msgModel);
        }
        return msgModels;
    }
}

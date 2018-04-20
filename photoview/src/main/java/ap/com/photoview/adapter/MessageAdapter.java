package ap.com.photoview.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ap.com.photoview.view.GrapeGridView;
import ap.com.photoview.R;
import ap.com.photoview.model.MsgModel;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class MessageAdapter extends SuperAdapter<MsgModel> {

    public MessageAdapter(Activity activity) {
        super(activity);
    }

    @Override
    public void putNewData(List<MsgModel> data) {
        if (null != data) {
            this.data.clear();
            this.data.addAll(data);
        } else {
            this.data.clear();
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (null == view) {
            holder = new ViewHolder();
            view = LayoutInflater.from(mConText).inflate(R.layout.view_msg, null);
            holder.title = view.findViewById(R.id.title);
            holder.content = view.findViewById(R.id.content);
            holder.gridView = view.findViewById(R.id.grid);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        MsgModel model = getItem(i);
        holder.title.setText(model.getTitle());
        holder.content.setText(model.getContent());
        ImgAdapter adapter = new ImgAdapter(mConText);
        holder.gridView.setAdapter(adapter);
        adapter.putNewData(model.getImgPaths());
        return view;
    }

    private class ViewHolder {
        TextView title;
        TextView content;
        GrapeGridView gridView;
    }
}

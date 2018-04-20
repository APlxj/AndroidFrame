package ap.com.materialdialogs;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String dataChoose = "";

    public void showBase(View view) {
        new MaterialDialog.Builder(MainActivity.this)
                .title("swallow")
                .content("Android开发----MaterialDesign设计下material-dialogs用法")
                .contentColor(Color.GRAY)
                .iconRes(R.drawable.icon)
                .positiveText("同意")
                .positiveColor(Color.parseColor("#555555"))
                .negativeText("不同意")
                .negativeColor(Color.parseColor("#3298da"))
                .neutralText("更多信息")
                .neutralColor(Color.parseColor("#fd9832"))
                .widgetColor(Color.GRAY)//不再提醒的checkbox 颜色
                //CheckBox
                .checkBoxPrompt("不再提醒", true, new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            Toast.makeText(MainActivity.this, "不再提醒", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "会再次提醒", Toast.LENGTH_LONG).show();
                        }
                    }
                })
                //嵌套recycleview，这个的点击事件可以先获取此Recycleview对象然后自己处理
                /*.adapter(new RecycleviewAdapter(getData(), MainActivity.this), new LinearLayoutManager(MainActivity.this))
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                        //dataChoose = "下标：" + position + " and 数据：" + mData.get(position);
                    }
                })*/
                //点击事件添加 方式1
                .onAny(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        if (which == DialogAction.NEUTRAL) {
                            Toast.makeText(MainActivity.this, "更多信息", Toast.LENGTH_LONG).show();
                        } else if (which == DialogAction.POSITIVE) {
                            Toast.makeText(MainActivity.this, "同意" + dataChoose, Toast.LENGTH_LONG).show();
                        } else if (which == DialogAction.NEGATIVE) {
                            Toast.makeText(MainActivity.this, "不同意", Toast.LENGTH_LONG).show();
                        }

                    }
                })
                .show();
    }

    public void showList(View view) {
        final String[] strs = new String[]{"AAAA", "BBBBB", "CCCCC"};
        new MaterialDialog.Builder(this)
                .iconRes(R.drawable.icon)
                .title("swallow")
                .content("Android开发----MaterialDesign设计下material-dialogs用法")
                .items((CharSequence[]) strs)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                        Toast.makeText(MainActivity.this, strs[position], Toast.LENGTH_LONG).show();
                    }
                })
                /*.positiveText("确认")
                .negativeText("取消")
                .neutralText("查看详情")
                .checkBoxPrompt("不再提示", true, new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    }
                })
                .onAny(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                    }
                })*/
                .show();
    }

    public void showRadio(View view) {
        final String[] strs = new String[]{"AAAA", "BBBBB", "CCCCC"};
        new MaterialDialog.Builder(this)
                .iconRes(R.drawable.icon)
                .title("swallow")
                .content("Android开发----MaterialDesign设计下material-dialogs用法")
                //单选
                .items((CharSequence[]) strs)
                .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {//0 表示第一个选中 -1 不选
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                        dataChoose = "此时选中的下标" + which;
                        Toast.makeText(MainActivity.this, dataChoose, Toast.LENGTH_LONG).show();
                        return true;
                    }
                })
                .positiveText("确认")
                .negativeText("取消")
                .neutralText("查看详情")
                .checkBoxPrompt("不再提示", true, new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    }
                })
                .onAny(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                    }
                })
                .show();
    }

    public void showCheck(View view) {
        final String[] strs = new String[]{"AAAA", "BBBBB", "CCCCC"};
        new MaterialDialog.Builder(this)
                .iconRes(R.drawable.icon)
                .title("swallow")
                .content("Android开发----MaterialDesign设计下material-dialogs用法")
                //单选
                .items((CharSequence[]) strs)
                .itemsCallbackMultiChoice(new Integer[]{0}, new MaterialDialog.ListCallbackMultiChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {

                        return false;
                    }
                })
                .positiveText("确认")
                .negativeText("取消")
                /*.neutralText("查看详情")
                .checkBoxPrompt("不再提示", true, new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    }
                })*/
                .onAny(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                    }
                })
                .show();
    }

    public void showEdit(View view) {
        new MaterialDialog.Builder(this)
                .iconRes(R.drawable.icon)
                .title("swallow")
                //.content("Android开发----MaterialDesign设计下material-dialogs用法")
                .widgetColor(Color.parseColor("#888888"))
                .inputType(InputType.TYPE_CLASS_PHONE)//可以输入的类型-电话号码
                .inputRange(11, 11)
                //前2个一个是hint一个是预输入的文字
                .input("请输入电话号码", "", new MaterialDialog.InputCallback() {

                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        Log.i("yqy", "输入的是：" + input);
                    }
                })
                .positiveText("确认")
                .negativeText("取消")
                .positiveColor(Color.parseColor("#555555"))
                .negativeColor(Color.parseColor("#3298da"))
                /*.neutralText("查看详情")
                .checkBoxPrompt("不再提示", true, new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    }
                })*/
                .onAny(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                    }
                })
                .show();
    }
}

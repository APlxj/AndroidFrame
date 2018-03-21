package ap.com.androidframe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.leakcanary.RefWatcher;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class BaseActivity extends AppCompatActivity {

    public RefWatcher refWatcher;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null == refWatcher)
            refWatcher = App.getRefWatcher(this);
        refWatcher.watch(this);
    }
}

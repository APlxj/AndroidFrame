package ap.com.glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import ap.com.glide.glide.GlideUtils;

public class MainActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.img);
    }

    public void imageDown(View view) {
        GlideUtils.load_uri(this, img, "http://images.enrz.com/wp-content/uploads/2017/03/20161223%E7%94%B7%E4%BA%BA%E8%A3%85%E8%B5%B5%E8%AF%97%E9%9B%A8214851.jpg");
        //GlideUtils.load_drawzble(this, img, R.drawable.ic_live_share_direction_p_p);
        //GlideUtils.load_file(this, img, Environment.getExternalStorageDirectory().getAbsolutePath() + "/KMCloud/doubleScreen/IMG_20180411_155724.jpg");

        /*final List<String> strings = new ArrayList<>();
        strings.add("http://enrz.com/Ds/Modules/Admin/Tpl/Public/Ueditor/php/upload/88001428916038.jpg");
        strings.add("http://enrz.com/Ds/Modules/Admin/Tpl/Public/Ueditor/php/upload/75961428916040.jpg");
        strings.add("http://enrz.com/Ds/Modules/Admin/Tpl/Public/Ueditor/php/upload/18761428916041.jpg");
        strings.add("http://enrz.com/Ds/Modules/Admin/Tpl/Public/Ueditor/php/upload/79731428916042.jpg");
        strings.add("http://enrz.com/Ds/Modules/Admin/Tpl/Public/Ueditor/php/upload/43961428916044.jpg");
        strings.add("http://enrz.com/Ds/Modules/Admin/Tpl/Public/Ueditor/php/upload/14301428916046.jpg");
        strings.add("http://enrz.com/Ds/Modules/Admin/Tpl/Public/Ueditor/php/upload/11981428916050.jpg");
        strings.add("http://images.enrz.com/wp-content/uploads/2017/09/20170609%E7%94%B7%E4%BA%BA%E8%A3%85%E5%BC%A0%E8%AF%91_4249-%E6%8B%B7%E8%B4%9D.jpg");
        strings.add("http://images.enrz.com/wp-content/uploads/2017/09/20170609%E7%94%B7%E4%BA%BA%E8%A3%85%E5%BC%A0%E8%AF%91_4202-%E6%8B%B7%E8%B4%9D.jpg");
        strings.add("http://images.enrz.com/wp-content/uploads/2017/09/20170609%E7%94%B7%E4%BA%BA%E8%A3%85%E5%BC%A0%E8%AF%91_4409-%E6%8B%B7%E8%B4%9D.jpg");
        strings.add("http://images.enrz.com/wp-content/uploads/2017/03/20161223%E7%94%B7%E4%BA%BA%E8%A3%85%E8%B5%B5%E8%AF%97%E9%9B%A8214851.jpg");
        GlideUtils.dpwnPic(this, strings, new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                final Map<String, Bitmap> map = (Map<String, Bitmap>) msg.obj;
                final List<Bitmap> bitmaps = new ArrayList<Bitmap>();
                for (String s : map.keySet()) {
                    bitmaps.add(map.get(s));
                }
                final int[] k = {1};
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        k[0]++;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                img.setImageBitmap(bitmaps.get(k[0] % strings.size()));
                            }
                        });
                    }
                }, 0, 2000);
            }
        });*/


    }
}

package ap.com.picasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.img);
    }

    public void load(View view) {
        PicassoUtils.loadImage(this, img, "http://images.enrz.com/wp-content/uploads/2017/04/201702228858.jpg");
    }
}

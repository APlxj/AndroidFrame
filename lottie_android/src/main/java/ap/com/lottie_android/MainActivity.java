package ap.com.lottie_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    //AE软件上设计的动画直接用于移动端

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        animationView.setAnimation("he.json");
        animationView.loop(true);
        animationView.playAnimation();
    }
}

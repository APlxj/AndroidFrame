package ap.com.photoview.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ap.com.photoview.R;
import ap.com.photoview.adapter.ViewPagerAdapter;
import ap.com.photoview.fragment.DynamicFragment;
import ap.com.photoview.fragment.HomeFragment;
import ap.com.photoview.fragment.MineFragment;

public class MainActivity extends BaseActivity {

    private List<Fragment> mFragments;
    private TextView mMine;
    private TextView mHome;
    private TextView mDynamic;

    private View mVmine;
    private View mVhome;
    private View mVdynamic;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
    }

    private void initView() {
        mHome = (TextView) findViewById(R.id.tv_home);
        mMine = (TextView) findViewById(R.id.tv_mine);
        mDynamic = (TextView) findViewById(R.id.tv_dynamic);

        mVhome = findViewById(R.id.v_home);
        mVmine = findViewById(R.id.v_mine);
        mVdynamic = findViewById(R.id.v_dynamic);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    private void init() {

        setLayout(1);

        mHome.setOnClickListener(onClickListener);
        mDynamic.setOnClickListener(onClickListener);
        mMine.setOnClickListener(onClickListener);

        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new DynamicFragment());
        mFragments.add(new MineFragment());

        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), mFragments));
        mViewPager.setCurrentItem(0);
        //预加载
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setOnPageChangeListener(pageChangeListener);
    }


    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            setLayout(position + 1);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_home:
                    mViewPager.setCurrentItem(0);
                    break;
                case R.id.tv_dynamic:
                    mViewPager.setCurrentItem(1);
                    break;
                case R.id.tv_mine:
                    mViewPager.setCurrentItem(2);
                    break;
            }
        }
    };

    void setLayout(int i) {
        switch (i) {
            case 1:
                mHome.setTextColor(getResources().getColor(R.color.bg_blue));
                mDynamic.setTextColor(getResources().getColor(R.color.font_goods_name));
                mMine.setTextColor(getResources().getColor(R.color.font_goods_name));

                mVhome.setVisibility(View.VISIBLE);
                mVdynamic.setVisibility(View.INVISIBLE);
                mVmine.setVisibility(View.INVISIBLE);
                break;
            case 2:
                mHome.setTextColor(getResources().getColor(R.color.font_goods_name));
                mDynamic.setTextColor(getResources().getColor(R.color.bg_blue));
                mMine.setTextColor(getResources().getColor(R.color.font_goods_name));

                mVhome.setVisibility(View.INVISIBLE);
                mVdynamic.setVisibility(View.VISIBLE);
                mVmine.setVisibility(View.INVISIBLE);
                break;
            case 3:
                mHome.setTextColor(getResources().getColor(R.color.font_goods_name));
                mDynamic.setTextColor(getResources().getColor(R.color.font_goods_name));
                mMine.setTextColor(getResources().getColor(R.color.bg_blue));

                mVhome.setVisibility(View.INVISIBLE);
                mVdynamic.setVisibility(View.INVISIBLE);
                mVmine.setVisibility(View.VISIBLE);
                break;
        }
    }
}

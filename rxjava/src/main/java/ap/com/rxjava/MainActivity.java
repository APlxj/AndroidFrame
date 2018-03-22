package ap.com.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("126561");
            }
        });

        Observable<String> observable1 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("123456");
            }
        });

        Observable<String> observable2 = Observable.merge(observable, observable1);

        Observer observer = new Observer() {
            @Override
            public void onCompleted() {
                Toast.makeText(MainActivity.this, "onCompleted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
                Toast.makeText(MainActivity.this, "onError:", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(Object o) {
                Toast.makeText(MainActivity.this, (String) o, Toast.LENGTH_SHORT).show();
            }
        };

        observable2.subscribeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        //Toast.makeText(MainActivity.this, "doOnNext" + s, Toast.LENGTH_SHORT).show();
                    }
                })
                .map(new Func1<Object, String>() {
                    @Override
                    public String call(Object s) {
                        if ("123456".equals(s)) return "18383138318";
                        return "888888888";
                    }
                })
                .subscribe(observer);
    }
}

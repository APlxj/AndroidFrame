package ap.com.glide.glide;

import android.content.Context;

import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.stream.HttpUrlGlideUrlLoader;
import com.squareup.okhttp.OkHttpClient;

import java.io.InputStream;

import ap.com.httpclient.OkHttp;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class OkHttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {

    private OkHttpClient mOkHttpClient = null;

    public OkHttpGlideUrlLoader(OkHttpClient mOkHttpClient) {
        this.mOkHttpClient = mOkHttpClient;
    }

    @Override
    public DataFetcher<InputStream> getResourceFetcher(GlideUrl model, int width, int height) {
        return new OkHttpGlideUrlFetcher(mOkHttpClient, model);
    }

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {

        @Override
        public ModelLoader<GlideUrl, InputStream> build(Context context, GenericLoaderFactory factories) {
            return new OkHttpGlideUrlLoader(OkHttp.getmInstance().getmOkHttpClient());
        }

        @Override
        public void teardown() {
        }
    }
}

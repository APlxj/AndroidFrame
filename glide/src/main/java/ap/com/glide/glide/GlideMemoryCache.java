package ap.com.glide.glide;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;

/**
 * 类描述：内存缓存
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class GlideMemoryCache implements MemoryCache {

    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public int getMaxSize() {
        return 0;
    }

    @Override
    public void setSizeMultiplier(float multiplier) {

    }

    @Override
    public Resource<?> remove(Key key) {
        return null;
    }

    @Override
    public Resource<?> put(Key key, Resource<?> resource) {
        return null;
    }

    @Override
    public void setResourceRemovedListener(ResourceRemovedListener listener) {

    }

    @Override
    public void clearMemory() {

    }

    @Override
    public void trimMemory(int level) {

    }
}

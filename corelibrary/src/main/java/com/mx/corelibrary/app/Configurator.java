package com.mx.corelibrary.app;

import android.os.Handler;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 单例保存一下全局配置
 */
public class Configurator {

    private static final Handler HANDLER = new Handler();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();
//    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();

    private final static HashMap<Object, Object> CONFIGS = new HashMap();

    private Configurator() {
        CONFIGS.put(ConfigKeys.CONFIG_READY, false);
        CONFIGS.put(ConfigKeys.HANDLER, HANDLER);
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final HashMap<Object, Object> getLatteConfigs() {
        return CONFIGS;
    }

    public final void configure() {
        initIcons();
//        Logger.addLogAdapter(new AndroidLogAdapter());
        CONFIGS.put(ConfigKeys.CONFIG_READY, true);
//        Utils.init(Latte.getApplicationContext());
    }

    public final Configurator withApiHost(String host) {
        CONFIGS.put(ConfigKeys.API_HOST, host);
        return this;
    }

    public final Configurator withLoaderDelayed(long delayed) {
        CONFIGS.put(ConfigKeys.LOADER_DELAYED, delayed);
        return this;
    }

    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

//    public final Configurator withInterceptor(Interceptor interceptor) {
//        INTERCEPTORS.add(interceptor);
//        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
//        return this;
//    }

//    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors) {
//        INTERCEPTORS.addAll(interceptors);
//        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
//        return this;
//    }

//    public final Configurator withWeChatAppId(String appId) {
//        LATTE_CONFIGS.put(ConfigKeys.WE_CHAT_APP_ID, appId);
//        return this;
//    }

//    public final Configurator withWeChatAppSecret(String appSecret) {
//        LATTE_CONFIGS.put(ConfigKeys.WE_CHAT_APP_SECRET, appSecret);
//        return this;
//    }

//    public final Configurator withActivity(Activity activity) {
//        LATTE_CONFIGS.put(ConfigKeys.ACTIVITY, activity);
//        return this;
//    }

//    public Configurator withJavascriptInterface(@NonNull String name) {
//        LATTE_CONFIGS.put(ConfigKeys.JAVASCRIPT_INTERFACE, name);
//        return this;
//    }

//    public Configurator withWebEvent(@NonNull String name, @NonNull Event event) {
//        final EventManager manager = EventManager.getInstance();
//        manager.addEvent(name, event);
//        return this;
//    }

    //浏览器加载的HOST
    public Configurator withWebHost(String host) {
        CONFIGS.put(ConfigKeys.WEB_HOST, host);
        return this;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) CONFIGS.get(ConfigKeys.CONFIG_READY);
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) CONFIGS.get(key);
    }

}

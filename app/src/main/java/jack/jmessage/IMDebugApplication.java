package jack.jmessage;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import cn.jpush.im.android.api.JMessageClient;

/**
 * ================================================
 * description:
 * ================================================
 * package_name: jack.jmessage
 * author: PayneJay
 * date: 2018/7/16.
 */

public class IMDebugApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        super.onCreate();
        JMessageClient.setDebugMode(true);
        JMessageClient.init(this);
        Fresco.initialize(this);
    }
}

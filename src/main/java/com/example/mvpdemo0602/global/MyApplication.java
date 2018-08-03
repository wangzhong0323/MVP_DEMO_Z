package com.example.mvpdemo0602.global;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpdemo0602.R;
import java.io.File;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017-11-24.
 */

public class MyApplication extends Application {


    private static String lastToast = "";
    private static long lastToastTime;

    private static MyApplication myApp=new MyApplication();
    private static boolean sIsAtLeastGB;
    static Context _context;
    static Resources _resource;
    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            sIsAtLeastGB = true;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _context = getApplicationContext();
        _resource =_context.getResources();
        // 设置未捕获异常处理器
//        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }

    public static synchronized MyApplication context() {
        return (MyApplication) _context;
    }

    public static Resources resources() {
        return _resource;
    }

    class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        // 未捕获的异常都会走到此方法中
        // Throwable是Exception和Error的父类
        @Override
        public void uncaughtException(Thread thread, Throwable ex) {
            System.out.println("产生了一个未处理的异常, 但是被哥捕获了...");

            // 将异常日志输入到本地文件中, 找机会上传到服务器,供技术人员分析
            File file = new File(Environment.getExternalStorageDirectory(),
                    "error_"+ System.currentTimeMillis()+".log");
            try {
                PrintWriter writer = new PrintWriter(file);
                ex.printStackTrace(writer);
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 结束当前进程
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }


    public static MyApplication getInstence(){
        return myApp;
    }



    public static void showToast(int message) {
        showToast(message, Toast.LENGTH_LONG, 0);
    }

    public static void showToast(String message) {
        showToast(message, Toast.LENGTH_LONG, 0, Gravity.BOTTOM);
    }

    public static void showToast(int message, int icon) {
        showToast(message, Toast.LENGTH_LONG, icon);
    }

    public static void showToast(String message, int icon) {
        showToast(message, Toast.LENGTH_LONG, icon, Gravity.BOTTOM);
    }

    public static void showToastShort(int message) {
        showToast(message, Toast.LENGTH_SHORT, 0);
    }

    public static void showToastShort(String message) {
        showToast(message, Toast.LENGTH_SHORT, 0, Gravity.BOTTOM);
    }

    public static void showToastShort(int message, Object... args) {
        showToast(message, Toast.LENGTH_SHORT, 0, Gravity.BOTTOM, args);
    }

    public static void showToast(int message, int duration, int icon) {
        showToast(message, duration, icon, Gravity.BOTTOM);
    }

    public static void showToast(int message, int duration, int icon,
                                 int gravity) {
        showToast(context().getString(message), duration, icon, gravity);
    }

    public static void showToast(int message, int duration, int icon,
                                 int gravity, Object... args) {
        showToast(context().getString(message, args), duration, icon, gravity);
    }

    public static void showToast(String message, int duration, int icon,
                                 int gravity) {
        if (message != null && !message.equalsIgnoreCase("")) {
            long time = System.currentTimeMillis();
            if (!message.equalsIgnoreCase(lastToast)
                    || Math.abs(time - lastToastTime) > 2000) {
                View view = LayoutInflater.from(context()).inflate(
                        R.layout.view_toast, null);
                ((TextView) view.findViewById(R.id.title_tv)).setText(message);
                if (icon != 0) {
                    ((ImageView) view.findViewById(R.id.icon_iv))
                            .setImageResource(icon);
                    ((ImageView) view.findViewById(R.id.icon_iv))
                            .setVisibility(View.VISIBLE);
                }
                Toast toast = new Toast(context());
                toast.setView(view);
                if (gravity == Gravity.CENTER) {
                    toast.setGravity(gravity, 0, 0);
                } else {
                    toast.setGravity(gravity, 0, 35);
                }

                toast.setDuration(duration);
                toast.show();
                lastToast = message;
                lastToastTime = System.currentTimeMillis();
            }
        }
    }

}

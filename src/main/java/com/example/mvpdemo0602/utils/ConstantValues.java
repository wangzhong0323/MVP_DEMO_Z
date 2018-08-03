package com.example.mvpdemo0602.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by Administrator on 2018/2/23.
 */

public class ConstantValues {

    public static final String URL_TEST3="http://192.168.70.111:8084/tools/api/";
    public static final String URL_TEST2="http://192.168.70.111:8084/tools/";



    private static String path = Environment
            .getExternalStorageDirectory()
            + File.separator
            + "Newcapec"
            + File.separator ;

    public static final String DOC_DOWNLOAD_PATH=path+"dochtml";
//    http://192.168.70.111:8084/tools/api/app_version

    /**
     * 纬度
     */
    public static final String LOCATION_LATITUDE ="location_latitude";

    /**
     * 经度
     */
    public static final String LOCATION_LONGITUDE ="location_longitude";

    /**
     * 精确度
     */
    public static final String LOCATION_ACCURACY_RADIUS ="location_accuracy_radius";

    /**
     * 位置信息
     */
    public static final String LOCATION_ADDRESS ="location_address";

    /**
     * 定位类型  WiFi  GPS  Bluetooth 传感器
     */
    public static final String LOCATION_TYPE ="location_type";




    /**
     * 百度定位信息广播
     */
    public static final String BAIDU_LOCATION_INFO ="baidu_location_info";
    /**
     * 高德定位信息广播
     */
    public static final String GAODE_LOCATION_INFO ="gaode_location_info";
    /**
     * 输入数据历史 key
     *
     */
    public static final String HESTORY_INPUT_VALUE ="hestory_input_value";
    public static final String HESTORY_INPUT_VALUE1 ="hestory_input_value1";
}

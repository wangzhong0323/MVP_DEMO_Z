package com.example.mvpdemo0602.helper;


import com.example.mvpdemo0602.R;
import com.example.mvpdemo0602.fragments.AccountInfoFragment;

/**
 * Created by Administrator on 2017/11/30.
 */

public enum SimpleBackPage {

   ACCOUNT_INFO(0, R.string.page_account_info_title, AccountInfoFragment.class);
     /*DOCUMENT_INFO(1,R.string.page_document_info_title, DocumentInfoFragment.class),
    BLUETOOTH_INFO(2,R.string.page_bluetooth_info_title, BluetoothFragment.class),
    BLUETOOTH_DATA_SHOW_INFO(3,R.string.page_bluetooth_data_show_info_title, BluetoothDataFragment1.class),
    SETTINGS_INFO(4,R.string.page_settings_info_title, SettingsFragment.class),
    STANDARDDOCLIST(5,R.string.page_document_info_list , StandardDocListFragment.class),
    STANDARDDOC(6,R.string.page_document_info_title , StandardDOCFragment.class),
    HESOTRYDATALIST(7,R.string.hestory_data_list , HistoryFragment.class),
    APPVERSION_DESC(8,R.string.app_version_history_list , APPVersionDescFragment.class);
*/

    private int index;
    private int title;
    private Class<?> clazz;

    SimpleBackPage(int index, int title, Class<?> clazz) {
        this.index = index;
        this.title = title;
        this.clazz = clazz;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public static SimpleBackPage getPageByValue(int val) {
        for (SimpleBackPage p : values()) {
            if (p.getIndex() == val)
                return p;
        }
        return null;
    }
}

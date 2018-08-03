package com.example.mvpdemo0602.retiof2_rxjava.rxtrofit.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.mvpdemo0602.R;
import com.example.mvpdemo0602.retiof2_rxjava.rxtrofit.beantest.HestoryData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/7.
 */

public class HestoryItemAdapter extends BaseAdapter {

    private Context mContext;
    private List<HestoryData> dataList;

    public HestoryItemAdapter(Context mContext, List<HestoryData> dataList) {
        this.mContext = mContext;
        if (dataList == null)
            this.dataList = new ArrayList<>();
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList != null ? dataList.size() : 0;
    }

    @Override
    public HestoryData getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        HestoryViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.itme_hestory_data_1, null);
            holder = new HestoryViewHolder(convertView);
        } else holder = HestoryViewHolder.getHolder(convertView);

        HestoryData hestoryData = getItem(position);
        if (hestoryData.getFncode() ==1) {
            holder.tvNumber.setText(hestoryData.getMeternumber() + "");
            holder.tvData.setText(hestoryData.getMeterdata());
            holder.tvDate.setText(hestoryData.getGtime());
        }

        return convertView;
    }

    public void setData(List<HestoryData> mHestoryList) {

        if (mHestoryList !=null && mHestoryList .size()>0) {
            this.dataList = mHestoryList;
            notifyDataSetChanged();
        }

    }

    static class HestoryViewHolder {

        TextView tvNumber, tvData, tvDate;

        public HestoryViewHolder(View view) {
            tvNumber = (TextView) view.findViewById(R.id.tv_item_hestory_data_meter_num);
            tvData = (TextView) view.findViewById(R.id.tv_item_hestory_data_meter_data);
            tvDate = (TextView) view.findViewById(R.id.tv_item_hestory_data_meter_date);
            view.setTag(this);
        }

        public static HestoryViewHolder getHolder(View view) {
            HestoryViewHolder holder = null;
            if (view != null) {
                holder = (HestoryViewHolder) view.getTag();
            } else
                holder = new HestoryViewHolder(view);
            return holder;
        }

    }


}

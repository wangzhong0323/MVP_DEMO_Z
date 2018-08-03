package com.example.mvpdemo0602.retiof2_rxjava.rxtrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvpdemo0602.R;
import com.example.mvpdemo0602.retiof2_rxjava.rxtrofit.beantest.HestoryData;

import java.util.List;

/**
 * Created by Administrator on 2018/5/23.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<HestoryData> historyLiss;
    private LayoutInflater mInflater;

    public MyRecyclerViewAdapter(Context mContext, List<HestoryData> historyLiss) {
        this.mContext = mContext;
        this.historyLiss = historyLiss;
        this.mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate( R.layout.itme_hestory_data_1,parent , false);
        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myholer= (MyHolder) holder;

        myholer.tvMeterNumber.setText(historyLiss.get(position).getMeternumber()+"");
        myholer.tvMeterData.setText(historyLiss.get(position).getMeterdata()+"");
        myholer.tvReadTime.setText(historyLiss.get(position).getGtime()+"");

    }

    @Override
    public int getItemCount() {

        return historyLiss!=null ?historyLiss.size():0;
    }


    public void setData(List<HestoryData> mHestoryList) {

        if (mHestoryList !=null && mHestoryList .size()>0) {
            this.historyLiss = mHestoryList;
            notifyDataSetChanged();
        }

    }




    static class MyHolder extends RecyclerView.ViewHolder{

        TextView tvMeterNumber,tvMeterData,tvReadTime;

        public MyHolder(View itemView) {
            super(itemView);
            tvMeterNumber =(TextView) itemView.findViewById(R.id.tv_item_hestory_data_meter_num);
            tvMeterData =(TextView) itemView.findViewById(R.id.tv_item_hestory_data_meter_data);
            tvReadTime =(TextView) itemView.findViewById(R.id.tv_item_hestory_data_meter_date);
        }

    }

}

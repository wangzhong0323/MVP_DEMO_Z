package com.example.mvpdemo0602.retiof2_rxjava.rxtrofit.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.mvpdemo0602.R;
import com.example.mvpdemo0602.retiof2_rxjava.rxtrofit.beantest.StandardDOC;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/3.
 */

public class DOCItemAdapter extends BaseAdapter {

    private Context mContext;
    private List<StandardDOC> data;

    public DOCItemAdapter(Context mContext, List<StandardDOC> data) {
        this.mContext = mContext;
        if (data !=null)
            this.data =  data;
        else this.data =new ArrayList<>();
    }


    public void notifyData(List<StandardDOC> data){
        if (data !=null && data.size()>0){
            this.data =data;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return data.size()>0? data.size():0;
    }

    @Override
    public StandardDOC getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView ==null){
            convertView =View.inflate(mContext, R.layout.item_standard_doc_1,null);
            holder=new ViewHolder(convertView);
        }else holder = ViewHolder.getHolder(convertView);

        StandardDOC item = getItem(position);

        holder.tvDOCDesc.setText(item.getDescription());
//        downloadDOC(item);
        return convertView;
    }


    static class ViewHolder{

        TextView tvDOCDesc;

        public ViewHolder(View view) {

            tvDOCDesc=(TextView) view.findViewById(R.id.tv_item_standard_doc_name);
            view.setTag(this);
        }

        public static ViewHolder getHolder(View view) {
            ViewHolder holder = null;
            if (view != null) {
                holder = (ViewHolder) view.getTag();
            } else
                holder = new ViewHolder(view);
            return holder;
        }
    }

}

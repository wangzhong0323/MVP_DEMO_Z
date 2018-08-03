package com.example.mvpdemo0602.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvpdemo0602.bean.Persion;

import java.util.List;

/**
 * Created by Administrator on 2018/7/13.
 */

public class TestSqlAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<Persion> strList;

    public TestSqlAdapter(Context mContext, List<Persion> strList) {
        this.mContext = mContext;
        this.strList = strList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(mContext,android.R.layout.simple_list_item_1,null);
        TestHolder testHolder = new TestHolder(view);
        setListener(view,testHolder);
        return testHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TestHolder testHolder = (TestHolder) holder;
        testHolder.itemView.setTag(position);
        if (strList!=null) {
            Persion user = strList.get(position);
            testHolder.textView.setText(user.getId() + ",用户：" + user.getName() + ",年龄：" + user.getAge());
        }
    }

    private OnListClickListener onListClickListener;

    public void setOnListClickListener(OnListClickListener onListClickListener) {
        this.onListClickListener = onListClickListener;
    }

    public interface OnListClickListener{
        void onItemClick(View v,int position);
        boolean onItmeLongClick(View v,int position);
    }


    private void setListener(View v, final RecyclerView.ViewHolder holder){

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onListClickListener !=null){
                    int adapterPosition = holder.getAdapterPosition();
                    onListClickListener.onItemClick(v,adapterPosition);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onListClickListener!=null){
                    int adapterPosition = holder.getAdapterPosition();
                    return onListClickListener.onItmeLongClick(v,adapterPosition);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return strList==null?0:strList.size();
    }

    class TestHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public TestHolder(View itemView) {
            super(itemView);
            textView =(TextView) itemView.findViewById(android.R.id.text1);
        }
    }

}

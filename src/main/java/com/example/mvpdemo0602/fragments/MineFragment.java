package com.example.mvpdemo0602.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.mvpdemo0602.R;
import com.example.mvpdemo0602.base.BaseFragment;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/6/5.
 */

public class MineFragment extends BaseFragment {

    @Bind(R.id.chr_mine_timer_1)
    TextView mTimerTv;
    @Bind(R.id.bn_mine_timer_1)
    Button mBtn;
    @Bind(R.id.tv_mine_title)
    TextView tvTitle;
    private int nums;
    private Timer timer;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_minie_1;
    }


    //    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_minie_1, null);
//
//
//        return view;
//    }

    @Override
    protected void initView(View view) {
        tvTitle.setText("计时器："+formatMiss(nums));

        timer = new Timer();

        for (int i = 0; i < 5; i++) {
            mTimerTv.append("abcdeft=="+i+";");
            mTimerTv.append("\r\n");
        }



    }


    TimerTask task=new TimerTask() {
        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvTitle.setText("计时器："+formatMiss(nums));
                }
            });

            nums++;
        }
    };

    public  String formatMiss(int time){
        String hh=time/3600>9?time/3600+"":"0"+time/3600;
        String mm=(time% 3600)/60>9?(time% 3600)/60+"":"0"+(time% 3600)/60;
        String ss=(time% 3600) % 60>9?(time% 3600) % 60+"":"0"+(time% 3600) % 60;
        return hh+":"+mm+":"+ss;
    }

    private boolean isStart;

    @OnClick({R.id.bn_mine_timer_1})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bn_mine_timer_1:

                if (!isStart){
                    nums=0;
                    if (timer==null) timer=new Timer();

                    timer.schedule(task,1000,1000);
                }else {

                }
                isStart =!isStart;
                break;
        }

    }


    @Override
    protected void initData() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        timer.cancel();
        timer=null;
    }
}

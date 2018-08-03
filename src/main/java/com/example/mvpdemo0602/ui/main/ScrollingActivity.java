package com.example.mvpdemo0602.ui.main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.example.mvpdemo0602.R;
import com.example.mvpdemo0602.adapters.TestSqlAdapter;
import com.example.mvpdemo0602.bean.Persion;
import com.example.mvpdemo0602.db.DbManager;
import com.example.mvpdemo0602.global.MyApplication;
import com.example.mvpdemo0602.greendao.PersionDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScrollingActivity extends AppCompatActivity {


    @Bind(R.id.rv_test_show_list_data_user_1)
    RecyclerView mUserList;
    @Bind(R.id.srl_test_list_data_down_refresh)
    SwipeRefreshLayout mDownRefreshList;
    private TestSqlAdapter mTestSqlAdapter;
    private List<Persion> personList =new ArrayList<>();
    private int num;
    private PersionDao mPersionDao;

    private LifecycleListener lifecycleListener=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        ButterKnife.bind(this);

        init();
    }


    class LifeListerenceImpl implements LifecycleListener{

        @Override
        public void onStart() {

        }

        @Override
        public void onStop() {

        }

        @Override
        public void onDestroy() {

        }
    }


    private void init() {

        mPersionDao = DbManager.getDaoSession(this).getPersionDao();
        List<Persion> list = mPersionDao.queryBuilder().list();
        if (num < list.size()) num = list.size();
        initList();
    }

    private void initList() {
        add();

        LinearLayoutManager lm=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mUserList.setLayoutManager(lm);
        mUserList.setItemAnimator (new DefaultItemAnimator());
        initView();


        mTestSqlAdapter.setOnListClickListener(new TestSqlAdapter.OnListClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                MyApplication.showToast(personList.get(position).getId()+","+personList.get(position).getName());
            }

            @Override
            public boolean onItmeLongClick(View v, int position) {
                if (personList !=null) {
                    notifyData();
                }
                return false;
            }
        });

    }

    private void initView() {
        mTestSqlAdapter = new TestSqlAdapter(this, personList);
        mUserList.setAdapter(mTestSqlAdapter);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.bn_test_sql_add, R.id.bn_test_sql_delete, R.id.bn_test_sql_update, R.id.bn_test_sql_query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bn_test_sql_add:
                if (personList !=null && personList.size()>0) {
                    List<Persion> list = mPersionDao.queryBuilder().list();
                    if (num < list.size()) num = list.size();
                    add();
                    mPersionDao.saveInTx(personList);
                    ((Button) view).setText(String.format("增%d", num));
                }
                break;
            case R.id.bn_test_sql_delete:
                mPersionDao.deleteByKey((long)(num-1));
                num -=1;
                break;
            case R.id.bn_test_sql_update:
                Persion persion1 = new Persion((long) 69, "小黑子", 66, "wqerqwer132");
                mPersionDao.update(persion1);

                break;
            case R.id.bn_test_sql_query:
                List<Persion> list = mPersionDao.queryBuilder().build().list();
                for (int i = 0; i < list.size(); i++) {
                    Persion persion = list.get(i);
                    Log.i("abc_aa",persion.toString());
                }
                break;
        }

        personList = mPersionDao.queryBuilder().list();
        initView();
    }

    private void add() {
        if (personList ==null) personList =new ArrayList<>();
        Random random = new Random();// user.setUserPhone(""+(long)(random.nextDouble() * 99000000000L + 100000000));
        for (int i = 0; i < 10; i++) {
            Persion persion = new Persion( "小强" + num, 20 + num, (long) (random.nextDouble() * 99000000000L + 100000000) + "");
            Log.i("abc_","num======"+num);
            personList.add(persion);
            num++;
        }

    }

    private void notifyData(){

        mTestSqlAdapter.notifyDataSetChanged();

    }

}


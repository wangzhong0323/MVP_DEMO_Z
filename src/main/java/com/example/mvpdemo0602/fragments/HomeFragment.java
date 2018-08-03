package com.example.mvpdemo0602.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvpdemo0602.R;
import com.example.mvpdemo0602.base.BaseFragment;
import com.example.mvpdemo0602.bean.Persion;
import com.example.mvpdemo0602.db.DbManager;
import com.example.mvpdemo0602.fragments.home.Type0ViewHolder;
import com.example.mvpdemo0602.fragments.home.Type1ViewHolder;
import com.example.mvpdemo0602.fragments.home.Type2ViewHolder;
import com.example.mvpdemo0602.fragments.home.TypeViewHolder;
import com.example.mvpdemo0602.global.MyApplication;
import com.example.mvpdemo0602.greendao.PersionDao;
import com.example.mvpdemo0602.utils.PrintLog;
import com.example.mvpdemo0602.utils.TDevice;
import com.example.mvpdemo0602.widgets.recyclerview.AbsViewHolder;
import com.example.mvpdemo0602.widgets.recyclerview.MultiTypeAdapterImpl;
import com.example.mvpdemo0602.widgets.recyclerview.ViewHolderCreator;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/6/5.
 */

public class HomeFragment extends BaseFragment {

    @Bind(R.id.result)
    TextView tvHomeTitle;
    @Bind(R.id.rv_home_list_new_firmware_1)
    RecyclerView mNewFirmwareList;
    @Bind(R.id.divider)
    View divider;


    private ArrayList<String> strList = new ArrayList<>();
    private static final String[] VIEW_TYPE = new String[]{"VIEW0", "VIEW1", "VIEW2", "VIEW3"};
    private static final String[] TYPE = new String[]{"HEAD", "CONTENT", "FOOT"};

    private int page_size = 20;
    private int page_num = 1;

    private int mViewType = 0;
    private int mType = 0;
    private int mDataCount = 1;
    private MultiTypeAdapterImpl mAdapter;


//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_home_1, null);
//        ButterKnife.bind(this, view);
//
//
//        return view;
//    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_1;
    }

    @Override
    protected void initView(View view) {
        tvHomeTitle.setTextColor(Color.BLACK);
        tvHomeTitle.setText(TDevice.checkNetworkType(getActivity()) + "===");

        LinearLayoutManager lm = new LinearLayoutManager(getApplication(), LinearLayoutManager.VERTICAL, false);
        mNewFirmwareList.setLayoutManager(lm);
        mNewFirmwareList.setItemAnimator(new DefaultItemAnimator());
        mNewFirmwareList.addItemDecoration(new DividerItemDecoration(getApplication(), DividerItemDecoration.VERTICAL));

//        addListData();

        mAdapter = new MultiTypeAdapterImpl();
        mAdapter.register(Type0ViewHolder.Data.class, Type0ViewHolder.class);
        mAdapter.register(Type1ViewHolder.Data.class, new ViewHolderCreator<Type1ViewHolder.Data, Type1ViewHolder>() {
            @Override
            public Type1ViewHolder create(ViewGroup parent) {
                final Type1ViewHolder viewHolder = new Type1ViewHolder(parent);
                viewHolder.setOnItemClickListener(new AbsViewHolder.OnItemClickListener<Type1ViewHolder.Data>() {
                    @Override
                    public boolean onClick(Type1ViewHolder.Data data) {

                        MyApplication.showToast("Click Type1ViewHolder. data =" + viewHolder.getData());
                        return false;
                    }
                });

                return viewHolder;
            }

            @NonNull
            @Override
            public Class<Type1ViewHolder> getViewHolderClass() {
                return Type1ViewHolder.class;
            }
        });

        mAdapter.register(Type2ViewHolder.Data.class, Type2ViewHolder.class);

        mAdapter.register(TypeViewHolder.Data.class, new ViewHolderCreator<TypeViewHolder.Data, TypeViewHolder>() {
            @Override
            public TypeViewHolder create(ViewGroup parent) {

                final TypeViewHolder typeViewHolder = new TypeViewHolder(parent);
                typeViewHolder.setOnItemClickListener(new TypeViewHolder.OnRecyclerViewItemClickListener() {
                    @Override
                    public void onClick(View view, TypeViewHolder.ViewName viewName, int position) {
                        if (position ==1){
                            if (viewName == TypeViewHolder.ViewName.PRACTISE1){
                                MyApplication.showToast(">>>>>>>>>1");
                                PrintLog.i("abc==================>>>>>>>>>1");
                            }else if (viewName == TypeViewHolder.ViewName.PRACTISE2){
                                MyApplication.showToast(">>>>>>>>>2");
                                PrintLog.i("abc==================>>>>>>>>>2");
                            }else if (viewName == TypeViewHolder.ViewName.PRACTISE3){
                                MyApplication.showToast(">>>>>>>>>3");
                                PrintLog.i("abc==================>>>>>>>>>3");

                            }
                        }
                    }
                });


                return typeViewHolder;
            }

            @NonNull
            @Override
            public Class<TypeViewHolder> getViewHolderClass() {
                return TypeViewHolder.class;
            }
        });


        mNewFirmwareList.setAdapter(mAdapter);
        update();
    }

    private static final int CONTENT = 1;

    private void addContnetData(Object data) {
        mAdapter.addItemByType(CONTENT, "String");
    }

    public void setView0(View view) {
        mViewType = 0;
        update();
    }

    public void setView1(View view) {
        mViewType = 1;
        update();
    }

    public void setView2(View view) {
        mViewType = 2;
        update();
    }

    public void setView3(View view) {
        mViewType = 3;
        update();
    }

    public void setHead(View view) {
        mType = 0;
        update();
    }

    public void setContent(View view) {
        mType = 1;
        update();
    }

    public void setFoot(View view) {
        mType = 2;
        update();
    }

    public void addOne(View view) {
        mDataCount = 1;
        update();
    }

    public void addTwo(View view) {
        mDataCount = 2;
        update();
    }


    public void addThree(View view) {
        mDataCount = 3;
        update();
    }

    public void addFour(View view) {
        mDataCount = 4;
        update();
    }

    public void addFive(View view) {
        mDataCount = 5;
        update();
    }


    private void update() {
        tvHomeTitle.setText("添加" + mDataCount + "个-->>" + VIEW_TYPE[mViewType] + "-->>到" + TYPE[mType]);
    }

    private static int sIndex = 0;

    public void run(View view) {
        if (mType < 0 || mType > 3) {
            MyApplication.showToast("unknown type, Type = " + mType);
            return;
        }
        if (mViewType == 0) {
            if (mDataCount == 1) {
                sIndex++;
                final Object object = new Type0ViewHolder.Data(TYPE[mType] + ">>>Title--" + sIndex);
                mAdapter.addItemByType(mType, object);
            } else {
                final List<Object> list = new ArrayList<>();
                for (int i = 0; i < mDataCount; i++) {
                    sIndex++;
                    list.add(new Type0ViewHolder.Data(TYPE[mType] + ">>>Title--" + sIndex));
                }
                mAdapter.addAllItemByType(mType, list);
            }
        } else if (mViewType == 1) {
            sIndex++;
            final String content = "Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content ";
            if (mDataCount == 1) {
                sIndex++;
                final Object object = new Type1ViewHolder.Data(TYPE[mType] + ">>>Title--" + sIndex, "Content");
                mAdapter.addItemByType(mType, object);
            } else {
                final List<Object> list = new ArrayList<>();
                for (int i = 0; i < mDataCount; i++) {
                    sIndex++;
                    list.add(new Type1ViewHolder.Data(TYPE[mType] + ">>>Title--" + sIndex, content));
                }
                mAdapter.addAllItemByType(mType, list);
            }
        } else if (mViewType == 2) {
            sIndex++;
            final String content = "Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content ";
            if (mDataCount == 1) {
                sIndex++;
                final Object object = new Type2ViewHolder.DataImpl(TYPE[mType] + ">>>Title--" + sIndex, "Content");
                mAdapter.addItemByType(mType, object);
            } else {
                final List<Object> list = new ArrayList<>();
                for (int i = 0; i < mDataCount; i++) {
                    sIndex++;
                    list.add(new Type2ViewHolder.DataImpl(TYPE[mType] + ">>>Title--" + sIndex, content));
                }
                mAdapter.addAllItemByType(mType, list);
            }
        }else if (mViewType == 3) {
            if (mDataCount ==1&& mType == 0){
                sIndex ++;
                final Object obj= new TypeViewHolder.DataImpl("列表","数据","任务");
                mAdapter.addItemByType(mType,obj);
            }

        }else {
            MyApplication.showToast("unknown view type, ViewType = " + mViewType);
        }
    }

    public void removeByType(View view) {
        mAdapter.removeAllItemByType(mType);
    }

    public void checkDataType(View view) {
        int count = 0;
        try {
            mAdapter.addItem(0, "Exception");
        } catch (Exception e) {
            e.printStackTrace();
            count++;
        }
        try {
            mAdapter.addItem(0, 0, "Exception");
        } catch (Exception e) {
            e.printStackTrace();
            count++;
        }
        try {
            mAdapter.addItem("Exception");
        } catch (Exception e) {
            e.printStackTrace();
            count++;
        }
        try {
            mAdapter.addItemByType(0, "Exception");
        } catch (Exception e) {
            e.printStackTrace();
            count++;
        }
        try {
            List<String> list = new ArrayList<>();
            list.add("Exception");
            mAdapter.addAllItem(0, list);
        } catch (Exception e) {
            e.printStackTrace();
            count++;
        }
        try {
            List<String> list = new ArrayList<>();
            list.add("Exception");
            mAdapter.addAllItem(0, list);
        } catch (Exception e) {
            e.printStackTrace();
            count++;
        }
        try {
            List<String> list = new ArrayList<>();
            list.add("Exception");
            mAdapter.addAllItem(0, 0, list);
        } catch (Exception e) {
            e.printStackTrace();
            count++;
        }
        try {
            List<String> list = new ArrayList<>();
            list.add("Exception");
            mAdapter.addAllItem(list);
        } catch (Exception e) {
            e.printStackTrace();
            count++;
        }
        try {
            List<String> list = new ArrayList<>();
            list.add("Exception");
            mAdapter.addAllItemByType(0, list);
        } catch (Exception e) {
            e.printStackTrace();
            count++;
        }
        try {
            List<String> list = new ArrayList<>();
            list.add("Exception");
            mAdapter.addAllItem(list.toArray());
        } catch (Exception e) {
            e.printStackTrace();
            count++;
        }
        MyApplication.showToast("检查" + (count == 10 ? "Success" : "Fail") + "，测试10个，捕获到类型异常" + count + "个。");
    }


    private void addListData() {
        PersionDao persionDao = DbManager.getDaoSession(getApplication()).getPersionDao();
        List<Persion> list = persionDao.queryBuilder().build().list();
        long count = persionDao.queryBuilder().count();
        PrintLog.i("count===" + count + ",,size==" + list.size());

        for (int i = 0; i < list.size(); i++) {
            Persion persion = list.get(i);
            strList.add(persion.getName() + "的电话：" + persion.getNum());
        }


    }

    @Override
    protected void initData() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this);
        ButterKnife.unbind(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.set_view0, R.id.set_view1, R.id.set_view2, R.id.set_view3,
            R.id.set_head, R.id.set_content, R.id.set_foot,
            R.id.check, R.id.add_one, R.id.add_two, R.id.add_three,
            R.id.add_four, R.id.add_five, R.id.remove,
            R.id.run})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.set_view0:
                setView0(view);
                break;
            case R.id.set_view1:
                setView1(view);
                break;
            case R.id.set_view2:
                setView2(view);
                break;
            case R.id.set_view3:
                setView3(view);
                break;
            case R.id.set_head:
                setHead(view);
                break;
            case R.id.set_content:
                setContent(view);
                break;
            case R.id.set_foot:
                setFoot(view);
                break;
            case R.id.check:
                checkDataType(view);
                break;
            case R.id.add_one:
                addOne(view);
                break;
            case R.id.add_two:
                addTwo(view);
                break;
            case R.id.add_three:
                addThree(
                        view
                );
                break;
            case R.id.add_four:
                addFour(view);
                break;
            case R.id.add_five:
                addFive(view);
                break;
            case R.id.remove:
                removeByType(view);
                break;
            case R.id.run:
                run(view);
                break;
        }
    }
}

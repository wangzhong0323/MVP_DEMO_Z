package com.example.mvpdemo0602.fragments.home;

import android.support.annotation.DrawableRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mvpdemo0602.R;
import com.example.mvpdemo0602.widgets.recyclerview.AbsViewHolder;

/**
 * Created by Administrator on 2018/7/17.
 */

public class TypeViewHolder extends AbsViewHolder<TypeViewHolder.Data> implements View.OnClickListener{

    private RelativeLayout rlFunc1,rlFunc2,rlFunc3;
    private ImageView ivIcon1,ivIcon2, ivIcon3;
    private TextView tvFunc1, tvFunc2,tvFunc3;


    public TypeViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.head_function_view_1);
    }

    @Override
    protected void initView(View itemView) {
        super.initView(itemView);
         rlFunc1 = (RelativeLayout) findViewById(R.id.rl_head_func_1);
         rlFunc2 = (RelativeLayout) findViewById(R.id.rl_head_func_2);
         rlFunc3 = (RelativeLayout) findViewById(R.id.rl_head_func_3);
        ivIcon1 = (ImageView) findViewById(R.id.iv_head_func_icon_1);
        ivIcon2 = (ImageView) findViewById(R.id.iv_head_func_icon_2);
        ivIcon3 = (ImageView) findViewById(R.id.iv_head_func_icon_3);
        tvFunc1 = (TextView) findViewById(R.id.tv_head_func_dexc_1);
        tvFunc2 = (TextView) findViewById(R.id.tv_head_func_dexc_2);
        tvFunc3 = (TextView) findViewById(R.id.tv_head_func_dexc_3);

        itemView.setOnClickListener(this);
        rlFunc1.setOnClickListener(this);
        rlFunc2.setOnClickListener(this);
        rlFunc3.setOnClickListener(this);

    }

    @Override
    protected void bindData(Data data) {

        tvFunc1.setText(data.getTitleText1());
        tvFunc2.setText(data.getTitleText2());
        tvFunc3.setText(data.getTitleText3());

/*        if (!TextUtils.isEmpty(data.getImgUrl1()) ){
            Glide.with(getActivity()).load(data.getImgUrl1()).into(ivIcon1);
        }*/
        ivIcon1.setImageResource(data.getImgRes1());
        ivIcon2.setImageResource(data.getImgRes2());
/*        if (!TextUtils.isEmpty(data.getImgUrl3()) ){
            Glide.with(getActivity()).load(data.getImgUrl3()).into(ivIcon3);
        }*/
        ivIcon3.setImageResource(data.getImgRes3());
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    public static enum ViewName{
        ITEM,
        PRACTISE1,
        PRACTISE2,
        PRACTISE3

    }
    public interface OnRecyclerViewItemClickListener {
        void onClick(View view, ViewName viewName, int position);
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener !=null) {
            switch (v.getId()) {
                case R.id.rl_head_func_1:
                    mOnItemClickListener.onClick(v,ViewName.PRACTISE1,1);
                    break;
                case R.id.rl_head_func_2:
                    mOnItemClickListener.onClick(v,ViewName.PRACTISE2,1);
                    break;
                case R.id.rl_head_func_3:
                    mOnItemClickListener.onClick(v,ViewName.PRACTISE3,1);
                    break;
                default:
                    mOnItemClickListener.onClick(v,ViewName.ITEM,1);
                    break;


            }
        }
    }

    public interface Data{
        @DrawableRes
        int getImgRes1();

        String getImgUrl1();
        String getTitleText1();
        @DrawableRes
        int getImgRes2();

        String getImgUrl2();
        String getTitleText2();
        @DrawableRes
        int getImgRes3();

        String getImgUrl3();
        String getTitleText3();
    }

    public static class DataImpl implements Data{
        @DrawableRes
        private int imgRes1;
        private String imgUrl1;
        private String titleText1;
        @DrawableRes
        private int imgRes2;
        private String imgUrl2;
        private String titleText2;
        @DrawableRes
        private int imgRes3;
        private String imgUrl3;
        private String titleText3;

        public DataImpl(String titleText1, String imgUrl1) {
            this.titleText1 = titleText1;
            this.imgUrl1 = imgUrl1;
            this.imgRes1 = R.drawable.icon_letter_f;
        }

        public DataImpl(String titleText1, String titleText2, String titleText3) {
            this.titleText1 = titleText1;
            this.titleText2 = titleText2;
            this.titleText3 = titleText3;
            this.imgRes1 = R.drawable.icon_letter_f;
            this.imgRes2 =R.drawable.icon_letter_c;
            this.imgRes3 =R.drawable.icon_letter_e;
        }

        public DataImpl(String imgUrl1, String titleText1, String imgUrl2, String titleText2, String imgUrl3, String titleText3) {
            this.imgUrl1 = imgUrl1;
            this.titleText1 = titleText1;
            this.imgRes1 = R.drawable.icon_letter_f;
            this.imgUrl2 = imgUrl2;
            this.titleText2 = titleText2;
            this.imgRes2 =R.drawable.icon_letter_c;
            this.imgUrl3 = imgUrl3;
            this.titleText3 = titleText3;
            this.imgRes3 =R.drawable.icon_letter_e;
        }

        @Override
        public int getImgRes1() {
            return imgRes1;
        }

        @Override
        public String getImgUrl1() {
            return imgUrl1;
        }

        @Override
        public String getTitleText1() {
            return titleText1;
        }

        @Override
        public int getImgRes2() {
            return imgRes2;
        }

        @Override
        public String getImgUrl2() {
            return imgUrl2;
        }

        @Override
        public String getTitleText2() {
            return titleText2;
        }

        @Override
        public int getImgRes3() {
            return imgRes3;
        }

        @Override
        public String getImgUrl3() {
            return imgUrl3;
        }

        @Override
        public String getTitleText3() {
            return titleText3;
        }
    }

}

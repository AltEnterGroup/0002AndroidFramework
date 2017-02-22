/**
 * Project Name:pg2
 * Create User:yusr
 * Update User:yusr
 * Package Name:cn.cloudwalk.pg2.base
 * Date:2016/9/2711:26
 * Copyright @ 2010-2016 Cloudwalk Information Technology Co.Ltd All Rights Reserved.
 */
package cn.cloudwalk.base;/**
 * Create User:yusr
 * Date:2016/9/2711:26
 * Copyright @ 2010-2016 Cloudwalk Information Technology Co.Ltd All Rights Reserved.
 */

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.cloudwalk.libproject.util.NullUtils;
import me.yokeyword.fragmentation.SupportFragment;


/**
 * ClassName: BaseFragment <br/>
 * Description: TODO Description. <br/>
 * date: 2016/9/27 11:26<br/>
 *
 * @author 284891377
 * @version v1.0.0
 * @since JDK 1.7
 */
public abstract class BaseFragment extends SupportFragment {
    //step5 toolbar使用
    public Toolbar toolbar;
    int backIconRes;
    public ImageView mRightBtn;
    public TextView mRightText;
    private boolean isShowBackIcon;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
 //TODO  修改初始化
//        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//        mRightBtn = (ImageView) view.findViewById(R.id.ivRightToolBar);
//        mRightText = (TextView) view.findViewById(R.id.tvRightToolBar);

        super.onViewCreated(view, savedInstanceState);
    }

    public void showToolbar(int titleResid, int backIconRes) {

        this.backIconRes = backIconRes;
        if (toolbar != null) {

            toolbar.setTitle(titleResid);

            // toolbar.setTitleTextColor(getResources().getColor(titleColorRes));

            mRightBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRightClick(v);
                }
            });
            mRightText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRightClick(v);
                }
            });
            toolbar.showOverflowMenu();
            //setSupportActionBar(toolbar);


        }
    }

    public void showBackIcon(boolean isShowBackIcon) {
        this.isShowBackIcon = isShowBackIcon;
        if (isShowBackIcon) {
            //toolbar.setNavigationIcon(R.mipmap.toolbar_back);
            toolbar.setNavigationIcon(backIconRes);

//            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onBackPressed();
//                }
//            });
        }
    }

    public void setRightBtnIcon(Drawable icon) {
        if (toolbar != null && mRightBtn != null) {
            if (mRightText != null) mRightText.setVisibility(View.GONE);
            mRightBtn.setVisibility(View.VISIBLE);
            mRightBtn.setImageDrawable(icon);
        }
    }

    public void setRightText(int resId) {
        setRightText(getResources().getString(resId));
    }

    public void setRightText(String text) {
        if (toolbar != null && mRightText != null) {
            if (NullUtils.isNotEmpty(text)) {
                mRightText.setVisibility(View.VISIBLE);
                mRightText.setText(text);
                if (mRightBtn != null) mRightBtn.setVisibility(View.GONE);
            } else {
                mRightText.setVisibility(View.GONE);

                if (mRightBtn != null) mRightBtn.setVisibility(View.GONE);
            }

        }
    }

    public void setRightBackground(int resId) {
        if (toolbar != null && mRightText != null) {
            mRightText.setVisibility(View.VISIBLE);
            mRightText.setBackgroundResource(resId);
            if (mRightBtn != null) mRightBtn.setVisibility(View.GONE);
        }
    }

    public void setRightBtnIcon(int iconResID) {
        setRightBtnIcon(getResources().getDrawable(iconResID));
    }


    public void onRightClick(View v) {

    }
}
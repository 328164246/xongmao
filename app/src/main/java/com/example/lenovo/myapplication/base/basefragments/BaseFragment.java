package com.example.lenovo.myapplication.base.basefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.example.lenovo.myapplication.R;

/**
 * Created by Lenovo on 2017/11/1.
 */

public abstract class BaseFragment extends AbstractFragment {
    //头布局显示
    protected boolean isShowHeader = false;
    private RelativeLayout headerview;
    private RelativeLayout NoGroundlayout;
    private RelativeLayout Groundlayout;
    private ScrollView scrollview;
    private RelativeLayout resfreshlayout;
    private SwipeRefreshLayout swipeview;
    private RelativeLayout Errorlayout;
    private RelativeLayout bodyview;
    private View header1;
    private View body1;
    private View footer1;
    private RelativeLayout footerview;
    private View inflate;

    //设置显示头布局
    public void setShowHeader(boolean showHeader) {
        isShowHeader = showHeader;
    }

    //尾布局显示
    protected boolean isShowFooter = false;

    public void setShowFooter(boolean showFooter) {
        isShowFooter = showFooter;
    }


    //加载失败布局显示
    protected boolean isShowErrorbody = false;
    //不可滚动布局显示
    protected boolean isShowNoGroundbody = false;
    //可滚动布局显示
    protected boolean isShowGroundbody = false;
    //下拉刷新布局显示
    protected boolean isShowRefreshbody = false;

    //主布局都不显示
    private void setNoBody() {
        isShowErrorbody = false;
        isShowGroundbody = false;
        isShowNoGroundbody = false;
        isShowRefreshbody = false;
    }

    //设置错误布局显示
    protected void setShowErrorbody(boolean showErrorbody) {
        setNoBody();
        isShowErrorbody = showErrorbody;
    }

    //设置滚动布局显示
    protected void setShowGroundbody(boolean showGroundbody) {
        setNoBody();
        isShowGroundbody = showGroundbody;
    }


    //设置不可滚动布局显示
    protected void setShowNoGroundbody(boolean showNoGroundbody) {
        setNoBody();
        isShowNoGroundbody = showNoGroundbody;
    }
    //设置下拉刷新布局显示

    protected void setShowRefreshbody(boolean showRefreshbody) {
        setNoBody();
        isShowRefreshbody = showRefreshbody;
    }

    //----------------------------------------------------------------------------------------------------------------
    //检查头布局
    public void checkHeader() {
        if (header1 != null) {
            header1.setMinimumWidth(1080);
            headerview.removeAllViews();
        }
        header1 = getHeader();
        if (isShowHeader && header1 != null) {

            headerview.setVisibility(View.VISIBLE);
            headerview.addView(header1);

        } else {
            headerview.setVisibility(View.GONE);
        }
    }

    //隐藏所有的主布局
    private void hideBody() {
        Errorlayout.setVisibility(View.GONE);
        Groundlayout.setVisibility(View.GONE);
        NoGroundlayout.setVisibility(View.GONE);
        resfreshlayout.setVisibility(View.GONE);
    }

    //检查主布局
    public void checkBody() {
        hideBody();
        body1 = getBody();
        if (body1 != null) {
            body1.setMinimumWidth(1080);
            body1.setMinimumHeight(1920);
            if (body1 != null) {
                if (isShowGroundbody) {
                    Groundlayout.setVisibility(View.VISIBLE);
                    Groundlayout.addView(body1);
                }
                if (isShowNoGroundbody) {
                    NoGroundlayout.setVisibility(View.VISIBLE);
                    NoGroundlayout.addView(body1);
                }
                if (isShowRefreshbody) {
                    resfreshlayout.setVisibility(View.VISIBLE);
                    resfreshlayout.addView(body1);
                }
                if (isShowErrorbody) {
                    Errorlayout.setVisibility(View.VISIBLE);
                    Errorlayout.addView(body1);
                }
            }
        }
    }


    //检查尾布局
    public void checkFooter() {
        if (footer1 != null) {
            footerview.removeAllViews();
        }
        footer1 = getFooter();
        if (isShowFooter && footer1 != null) {
            footer1.setMinimumWidth(1080);
            footerview.setVisibility(View.VISIBLE);
            footerview.addView(footer1);

        } else {
            footerview.setVisibility(View.GONE);
        }

    }


    //钩子函数


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.base_activity, container, false);
        initView(inflate);
        //设置哪个需要显示
        initLayout();
        checkHeader();
        checkBody();
        checkFooter();
        initviews();
        run();


        return inflate;
    }


    private void initView(View inflate) {

        headerview = inflate.findViewById(R.id.headerview);
        Groundlayout = inflate.findViewById(R.id.Groundlayout);
        scrollview = inflate.findViewById(R.id.scrollview);
        resfreshlayout = inflate.findViewById(R.id.resfreshlayout);
        Errorlayout = inflate.findViewById(R.id.Errorlayout);
        bodyview = inflate.findViewById(R.id.bodyview);
        footerview = inflate.findViewById(R.id.footerview);
         NoGroundlayout = inflate.findViewById(R.id.NoGroundlayout);

    }
}

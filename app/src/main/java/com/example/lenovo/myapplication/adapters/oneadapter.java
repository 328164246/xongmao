package com.example.lenovo.myapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.beans.Bean;
import com.example.lenovo.myapplication.beans.Cctv;
import com.example.lenovo.myapplication.beans.Guancha_In;
import com.example.lenovo.myapplication.beans.eightBean;
import com.example.lenovo.myapplication.utils.VolleyUtils;
import com.google.gson.Gson;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/11/7.
 */

public class oneadapter extends RecyclerView.Adapter {

    private Bean.DataBean data;
    private Context context;
    private ArrayList<String> strings;
    private List<Bean.DataBean.BigImgBean> bigImg;
    public List<Bean.DataBean.AreaBean.ListscrollBean> listscroll;
    private List<Bean.DataBean.PandaeyeBean.ItemsBean> items;
    private List<Bean.DataBean.PandaliveBean.ListBean> list;
    private List<Bean.DataBean.WallliveBean.ListBeanX> listwall;
    private List<Bean.DataBean.ChinaliveBean.ListBeanXX> listchina;
    private List<Bean.DataBean.InteractiveBean.InteractiveoneBean> interactiveone;
    private List<Cctv.ListBean> listcctv;
    private Guancha_In guancha_in;
    private List<Guancha_In.ListBean> listbean;
    private String listurl;
    private String pandaeyelist;
    private String listUrl;
    private Bean.DataBean.ListBeanXXX listBeanXXX;
    public oneadapter(Bean.DataBean data, Context context) {

        this.data = data;
        this.context = context;

    }

    public interface Onitemclick{
         void setonclickitem(String url);
    }
    public static Onitemclick onclickitem;
    public void set(Onitemclick onclickitem){
        this.onclickitem=onclickitem;
    }
/*
* 轮播图
* "http://115.182.9.189/api/getVideoInfoForCBox.do?pid=" + pid
* 其它点击事件:
* "http://vdn.apps.cntv.cn/api/getVideoInfoForCBox.do?pid="+pid
*
* */














    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //精彩推荐标题和图片
        Bean.DataBean.AreaBean area = data.getArea();


        //轮播图
        bigImg = data.getBigImg();
        strings = new ArrayList<>();
        for (int i = 0; i < bigImg.size(); i++) {
            strings.add(bigImg.get(i).getImage());
        }
        //精彩推荐
        listscroll = data.getArea().getListscroll();
        //2 熊猫观察

        items = data.getPandaeye().getItems();
        pandaeyelist = data.getPandaeye().getPandaeyelist();
        Log.e("TAG", pandaeyelist.toString());

        //3.熊猫直播
        String title = data.getPandalive().getTitle(); //标题
        list = data.getPandalive().getList();
        //4 长城直播
        listwall = data.getWalllive().getList();
        String title1 = data.getWalllive().getTitle();//长城直播标题
        //5 直播中国
        listchina = data.getChinalive().getList();
        //6 特别策划
        interactiveone = data.getInteractive().getInteractiveone();
        String title2 = data.getInteractive().getTitle();//特别策划标题
        //7 cctv

        listurl = data.getCctv().getListurl();
        VolleyUtils.getInstance(context).get(listurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String s = response.toString();
                Cctv cctv = new Gson().fromJson(s, Cctv.class);
                listcctv = cctv.getList();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.toString());
            }
        });
        //8 光影中国
        listBeanXXX = data.getList().get(0);
        listUrl = listBeanXXX.getListUrl();


        //---------------------------------------------------------------------------
        LayoutInflater from = LayoutInflater.from(context);
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case 0:
                View view = from.inflate(R.layout.flybanneritem, parent, false);
                holder = new ViewHolder0(view);
                return holder;
            case 1:
                View inflate = from.inflate(R.layout.zeroitem, parent, false);
                holder = new ViewHolder1(inflate);
                return holder;
            case 2:
                View inflate1 = from.inflate(R.layout.twoitem, parent, false);
                holder = new ViewHolder2(inflate1);
                return holder;

            case 3:
                View inflate3 = from.inflate(R.layout.threeitem, parent, false);
                holder = new ViewHolder3(inflate3);
                return holder;
            case 4:
                View inflate4 = from.inflate(R.layout.fouritem, parent, false);
                holder = new ViewHolder4(inflate4);

                return holder;
            case 5:
                View inflate5 = from.inflate(R.layout.fiveitem, parent, false);
                holder = new ViewHolder5(inflate5);
                return holder;
            case 6:
                View inflate2 = from.inflate(R.layout.sixitem, parent, false);
                holder = new ViewHolder6(inflate2);
                return holder;
            case 7:
                View inflate6 = from.inflate(R.layout.sevenitem, parent, false);
                holder = new ViewHolder7(inflate6);
                return holder;
            case 8:
                View inflate7 = from.inflate(R.layout.eightitem, parent, false);
                holder = new ViewHolder8(inflate7);
                return holder;

        }
        return holder;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder0) {
            ((ViewHolder0) holder).flybanner.setImagesUrl(strings);
        } else if (holder instanceof ViewHolder1) {
            ((ViewHolder1) holder).one_tv.setText(data.getArea().getTitle());
            Glide.with(context.getApplicationContext()).load(data.getArea().getImage()).into(((ViewHolder1) holder).one_img);
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
            ((ViewHolder1) holder).one_rcv.setLayoutManager(staggeredGridLayoutManager);
            RecyclerinAdapter recyclerinAdapter = new RecyclerinAdapter(listscroll, context);
            ((ViewHolder1) holder).one_rcv.setAdapter(recyclerinAdapter);


        } else if (holder instanceof ViewHolder2) {
            ((ViewHolder2) holder).two_title.setText(data.getPandaeye().getTitle());
            ((ViewHolder2) holder).two_title11.setText(items.get(0).getBrief());
            ((ViewHolder2) holder).two_title12.setText(items.get(0).getTitle());
            ((ViewHolder2) holder).two_title13.setText(items.get(1).getBrief());
            ((ViewHolder2) holder).two_title14.setText(items.get(1).getTitle());
            Glide.with(context).load(data.getPandaeye().getPandaeyelogo()).into(((ViewHolder2) holder).two_img1);
            VolleyUtils.getInstance(context).get(pandaeyelist, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    String s = response.toString();
                    guancha_in = new Gson().fromJson(s, Guancha_In.class);
                    listbean = guancha_in.getList();
                    ((ViewHolder2) holder).two_title21.setText(listbean.get(0).getTitle());
                    ((ViewHolder2) holder).two_title22.setText(listbean.get(0).getDaytime());
                    Glide.with(context).load(listbean.get(0).getImage()).into(((ViewHolder2) holder).two_img2);
                    ((ViewHolder2) holder).two_title31.setText(listbean.get(1).getTitle());
                    ((ViewHolder2) holder).two_title32.setText(listbean.get(1).getDaytime());
                    Glide.with(context).load(listbean.get(1).getImage()).into(((ViewHolder2) holder).two_img3);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("TAG", error.toString());
                }
            });


        } else if (holder instanceof ViewHolder3) {
            ((ViewHolder3) holder).tv_three_title.setText(data.getPandalive().getTitle());
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            ((ViewHolder3) holder).rcv_3.setLayoutManager(staggeredGridLayoutManager);
            RecyclerAdapter_three recyclerAdapter_three = new RecyclerAdapter_three(list, context);
            ((ViewHolder3) holder).rcv_3.setAdapter(recyclerAdapter_three);
        } else if (holder instanceof ViewHolder4) {
            ((ViewHolder4) holder).tv_three_title.setText(data.getWalllive().getTitle());
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            ((ViewHolder4) holder).rcv_3.setLayoutManager(staggeredGridLayoutManager);
            RecyclerAdapter_four recyclerAdapter_four = new RecyclerAdapter_four(listwall, context);
            ((ViewHolder4) holder).rcv_3.setAdapter(recyclerAdapter_four);

        } else if (holder instanceof ViewHolder5) {
            ((ViewHolder5) holder).tv_three_title.setText(data.getWalllive().getTitle());
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            ((ViewHolder5) holder).rcv_3.setLayoutManager(staggeredGridLayoutManager);
            RecyclerAdapter_five recyclerAdapter_five = new RecyclerAdapter_five(listchina, context);
            ((ViewHolder5) holder).rcv_3.setAdapter(recyclerAdapter_five);
        } else if (holder instanceof ViewHolder6) {
            ((ViewHolder6) holder).six_title.setText(data.getInteractive().getTitle());
            ((ViewHolder6) holder).six_tv.setText(interactiveone.get(0).getTitle());
            Glide.with(context).load(interactiveone.get(0).getImage()).into(((ViewHolder6) holder).six_img);

        } else if (holder instanceof ViewHolder7) {
            ((ViewHolder7) holder).seven_title.setText(data.getInteractive().getTitle());
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            ((ViewHolder7) holder).rcv_7.setLayoutManager(staggeredGridLayoutManager);
            RecyclerAdapter_seven recyclerAdapter_seven = new RecyclerAdapter_seven(listcctv, context);
            ((ViewHolder7) holder).rcv_7.setAdapter(recyclerAdapter_seven);

        }else if(holder instanceof ViewHolder8){
            ((ViewHolder8) holder).eight_title.setText(listBeanXXX.getTitle());
            VolleyUtils.getInstance(context).get(listUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    String s = response.toString();
                    eightBean eightBean = new Gson().fromJson(s, eightBean.class);
                    List<com.example.lenovo.myapplication.beans.eightBean.ListBean> list = eightBean.getList();
                    ListviewAdapter_eight listviewAdapter_eight = new ListviewAdapter_eight(list, context);
                    ((ViewHolder8) holder).eight_listview.setAdapter(listviewAdapter_eight);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("TAG",error.toString());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else if (position == 3) {
            return 3;
        } else if (position == 4) {
            return 4;
        } else if (position == 5) {
            return 5;
        } else if (position == 6) {
            return 6;
        } else if (position == 7) {
            return 7;
        } else if (position == 8) {
            return 8;
        }
        return 0;
    }


    public class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView one_img;
        public TextView one_tv;
        public RecyclerView one_rcv;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.one_img = (ImageView) rootView.findViewById(R.id.one_img);
            this.one_tv = (TextView) rootView.findViewById(R.id.one_tv);
            this.one_rcv = (RecyclerView) rootView.findViewById(R.id.one_rcv);


        }

    }

    public static class ViewHolder0 extends RecyclerView.ViewHolder {
        public View rootView;
        public FlyBanner flybanner;

        public ViewHolder0(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.flybanner = (FlyBanner) rootView.findViewById(R.id.flybanner);
        }

    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView two_title;
        public ImageView two_img1;
        public TextView two_title11;
        public TextView two_title12;
        public TextView two_title13;
        public TextView two_title14;
        public ImageView two_img2;
        public TextView two_title21;
        public TextView two_title22;
        public ImageView two_img3;
        public TextView two_title31;
        public TextView two_title32;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.two_title = (TextView) rootView.findViewById(R.id.two_title);
            this.two_img1 = (ImageView) rootView.findViewById(R.id.two_img1);
            this.two_title11 = (TextView) rootView.findViewById(R.id.two_title11);
            this.two_title12 = (TextView) rootView.findViewById(R.id.two_title12);
            this.two_title13 = (TextView) rootView.findViewById(R.id.two_title13);
            this.two_title14 = (TextView) rootView.findViewById(R.id.two_title14);
            this.two_img2 = (ImageView) rootView.findViewById(R.id.two_img2);
            this.two_title21 = (TextView) rootView.findViewById(R.id.two_title21);
            this.two_title22 = (TextView) rootView.findViewById(R.id.two_title22);
            this.two_img3 = (ImageView) rootView.findViewById(R.id.two_img3);
            this.two_title31 = (TextView) rootView.findViewById(R.id.two_title31);
            this.two_title32 = (TextView) rootView.findViewById(R.id.two_title32);
        }

    }

    public static class ViewHolder3 extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rcv_3;
        private TextView tv_three_title;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            tv_three_title = rootView.findViewById(R.id.tv_three_title);
            this.rcv_3 = (RecyclerView) rootView.findViewById(R.id.rcv_3);
        }

    }

    public static class ViewHolder4 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_three_title;
        public RecyclerView rcv_3;

        public ViewHolder4(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_three_title = (TextView) rootView.findViewById(R.id.tv_three_title);
            this.rcv_3 = (RecyclerView) rootView.findViewById(R.id.rcv_3);
        }

    }

    public static class ViewHolder5 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_three_title;
        public RecyclerView rcv_3;

        public ViewHolder5(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_three_title = (TextView) rootView.findViewById(R.id.tv_three_title);
            this.rcv_3 = (RecyclerView) rootView.findViewById(R.id.rcv_3);
        }

    }


    public static class ViewHolder6 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView six_title;
        public ImageView six_img;
        public TextView six_tv;

        public ViewHolder6(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.six_title = (TextView) rootView.findViewById(R.id.six_title);
            this.six_img = (ImageView) rootView.findViewById(R.id.six_img);
            this.six_tv = (TextView) rootView.findViewById(R.id.six_tv);
        }

    }


    public static class ViewHolder7 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView seven_title;
        public RecyclerView rcv_7;

        public ViewHolder7(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.seven_title = (TextView) rootView.findViewById(R.id.seven_title);
            this.rcv_7 = (RecyclerView) rootView.findViewById(R.id.rcv_7);
        }

    }

    public static class ViewHolder8 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView eight_title;
        public ListView eight_listview;

        public ViewHolder8(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.eight_title = (TextView) rootView.findViewById(R.id.eight_title);
            this.eight_listview = (ListView) rootView.findViewById(R.id.eight_listview);
        }

    }
}

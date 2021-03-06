package com.example.lenovo.myapplication.beans;

import java.util.List;

/**
 * Created by Lenovo on 2017/11/10.
 */

public class Fenghuang {
    private List<LiveBean> live;

    public List<LiveBean> getLive() {
        return live;
    }

    public void setLive(List<LiveBean> live) {
        this.live = live;
    }

    public static class LiveBean {
        /**
         * title : 凤凰古城南华山
         * brief : 凤凰古城是位于湖南湘西的历史文化名城，被誉为中国最美丽的小城，也是文学巨匠沈从文的故乡。城内，古代城楼、明清古院风采依然，古老朴实的沱江静静流淌，城外有南华山国家森林公园，城下艺术宫殿奇梁洞，建于唐代的黄丝桥古城，举世瞩目的南方长城。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/9/9/1473408958399_153.jpg
         * id : fhgcdnhs
         * order : 1
         */

        private String title;
        private String brief;
        private String image;
        private String id;
        private String order;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}

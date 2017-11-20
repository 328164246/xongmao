package com.example.lenovo.myapplication.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lenovo on 2017/11/20.
 */

public class zhibojincai {

    /**
     * video : [{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/11/17/719823eee4e14be1b3243d17d31848ff-9.jpg?p=2&h=120","len":"00:00:17","order":"5468","ptime":"2017-11-17 15:14:46","t":"《精彩一刻》 20171117 我是谁？手里怎么有笋？","url":"http://tv.cntv.cn/video/VSET100167216881/719823eee4e14be1b3243d17d31848ff","vid":"719823eee4e14be1b3243d17d31848ff","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2017/11/17/01cd4db6d9f043fa9c305b181bf73242-9.jpg?p=2&h=120","len":"00:00:19","order":"5465","ptime":"2017-11-17 15:13:52","t":"《精彩一刻》 20171117 被偏爱的都有恃无恐！","url":"http://tv.cntv.cn/video/VSET100167216881/01cd4db6d9f043fa9c305b181bf73242","vid":"01cd4db6d9f043fa9c305b181bf73242","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/11/17/67907b5214d74979896b241cb3646bd5-33.jpg?p=2&h=120","len":"00:00:46","order":"5466","ptime":"2017-11-17 15:13:04","t":"《精彩一刻》 20171117 今日运动量顺利达标~","url":"http://tv.cntv.cn/video/VSET100167216881/67907b5214d74979896b241cb3646bd5","vid":"67907b5214d74979896b241cb3646bd5","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/11/17/2b393e8c107c44948dd94402f24de8df-35.jpg?p=2&h=120","len":"00:00:51","order":"5467","ptime":"2017-11-17 15:12:09","t":"《精彩一刻》 20171117 在熊界，打架全靠滚！","url":"http://tv.cntv.cn/video/VSET100167216881/2b393e8c107c44948dd94402f24de8df","vid":"2b393e8c107c44948dd94402f24de8df","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/11/17/5343b8fbb466466186753351a0282c61-20.jpg?p=2&h=120","len":"00:00:31","order":"5463","ptime":"2017-11-17 10:21:14","t":"《精彩一刻》 20171117 这段看了都想笑","url":"http://tv.cntv.cn/video/VSET100167216881/5343b8fbb466466186753351a0282c61","vid":"5343b8fbb466466186753351a0282c61","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/11/17/369444f8ee1d4aa4acfc69145c68a713-21.jpg?p=2&h=120","len":"00:00:35","order":"5462","ptime":"2017-11-17 10:20:29","t":"《精彩一刻》 20171117 谁在用皮毛弹奏一曲东风破","url":"http://tv.cntv.cn/video/VSET100167216881/369444f8ee1d4aa4acfc69145c68a713","vid":"369444f8ee1d4aa4acfc69145c68a713","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/11/17/29868c383f324fc8b7741b834e28b7af-20.jpg?p=2&h=120","len":"00:00:30","order":"5464","ptime":"2017-11-17 10:19:41","t":"《精彩一刻》 20171117 \u201c迎迎\u201d打牌输了","url":"http://tv.cntv.cn/video/VSET100167216881/29868c383f324fc8b7741b834e28b7af","vid":"29868c383f324fc8b7741b834e28b7af","vsid":"VSET100167216881"}]
     * videoset : {"0":{"bj":"","cd":"","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","dy":"","enname":"其他","fcl":"","fl":"","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","js":"","name":"熊猫频道-精彩一刻","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"2013-05-01","url":"http://tv.cntv.cn/videoset/VSET100167216881","vsid":"VSET100167216881","yz":"","zcr":"","zy":""},"count":"5454"}
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"bj":"","cd":"","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","dy":"","enname":"其他","fcl":"","fl":"","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","js":"","name":"熊猫频道-精彩一刻","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"2013-05-01","url":"http://tv.cntv.cn/videoset/VSET100167216881","vsid":"VSET100167216881","yz":"","zcr":"","zy":""}
         * count : 5454
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * bj :
             * cd :
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
             * dy :
             * enname : 其他
             * fcl :
             * fl :
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * js :
             * name : 熊猫频道-精彩一刻
             * nf :
             * playdesc :
             * relvsid :
             * sbpd : 其他
             * sbsj : 2013-05-01
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * vsid : VSET100167216881
             * yz :
             * zcr :
             * zy :
             */

            private String bj;
            private String cd;
            private String desc;
            private String dy;
            private String enname;
            private String fcl;
            private String fl;
            private String img;
            private String js;
            private String name;
            private String nf;
            private String playdesc;
            private String relvsid;
            private String sbpd;
            private String sbsj;
            private String url;
            private String vsid;
            private String yz;
            private String zcr;
            private String zy;

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }
        }
    }

    public static class VideoBean {
        /**
         * em : CM01
         * img : http://p5.img.cctvpic.com/fmspic/2017/11/17/719823eee4e14be1b3243d17d31848ff-9.jpg?p=2&h=120
         * len : 00:00:17
         * order : 5468
         * ptime : 2017-11-17 15:14:46
         * t : 《精彩一刻》 20171117 我是谁？手里怎么有笋？
         * url : http://tv.cntv.cn/video/VSET100167216881/719823eee4e14be1b3243d17d31848ff
         * vid : 719823eee4e14be1b3243d17d31848ff
         * vsid : VSET100167216881
         */

        private String em;
        private String img;
        private String len;
        private String order;
        private String ptime;
        private String t;
        private String url;
        private String vid;
        private String vsid;

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }
    }
}

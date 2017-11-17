package com.example.administrator.mvpdemo.service.entity;

import java.util.List;

/**
 * Created by jijia on 2017/11/16.
 */

public class Smart {


    /**
     * error : false
     * results : [{"_id":"5a0b9888421aa90fef203530","createdAt":"2017-11-15T09:29:44.280Z","desc":"Android与Python爱之初体验","publishedAt":"2017-11-16T12:01:05.619Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488220&idx=1&sn=834f2b928d2852ebdc4db1439ee0e08b","used":true,"who":"陈宇明"},{"_id":"5a0bcf5a421aa90fe725363c","createdAt":"2017-11-15T13:23:38.991Z","desc":"[开发利器]在线查看对比 Android 和 Java 任意版本源码 IDEA插件","images":["http://img.gank.io/a3fc2a25-adea-45de-b186-17884187280c"],"publishedAt":"2017-11-16T12:01:05.619Z","source":"web","type":"Android","url":"https://github.com/pengwei1024/AndroidSourceViewer","used":true,"who":"舞影凌风"},{"_id":"5a0ce9b4421aa90fe2f02c5d","createdAt":"2017-11-16T09:28:20.728Z","desc":"CacheWebView通过拦截静态资源实现内存(LRU)和磁盘(LRU)2级缓存。突破系统WebView缓存的空间限制，让缓存更简单、更快、更灵活。让网站离线也能正常访问。","images":["http://img.gank.io/c2797609-468f-45bd-b7dc-8296d10a1423"],"publishedAt":"2017-11-16T12:01:05.619Z","source":"web","type":"Android","url":"https://github.com/yale8848/CacheWebView","used":true,"who":"Yale"},{"_id":"5a0cfd99421aa90fe2f02c5e","createdAt":"2017-11-16T10:53:13.537Z","desc":"论热修复实战心得\u2014很值得学习的热修复详解|强烈推荐","publishedAt":"2017-11-16T12:01:05.619Z","source":"web","type":"Android","url":"http://mp.weixin.qq.com/s?__biz=MzI3OTU0MzI4MQ==&mid=100001255&idx=1&sn=6b1674c7578039b61b4c34825619c363&chksm=6b4769795c30e06fa1d02f89e7a3e230c2d9c5761b0256fd1ed33eee899803a95f574a144450#rd","used":true,"who":"codeGoogler"},{"_id":"5a0d00be421aa90fef203534","createdAt":"2017-11-16T11:06:38.136Z","desc":"可能是最好看的 Android 圆形 Menu 菜单效果。","publishedAt":"2017-11-16T12:01:05.619Z","source":"chrome","type":"Android","url":"https://github.com/Ramotion/circle-menu-android","used":true,"who":"代码家"},{"_id":"5a0d0282421aa90fe50c020d","createdAt":"2017-11-16T11:14:10.819Z","desc":"阿里开源的额高性能 RPC 框架。","publishedAt":"2017-11-16T12:01:05.619Z","source":"chrome","type":"Android","url":"https://github.com/alibaba/dubbo","used":true,"who":"代码家"},{"_id":"59f463ff421aa90fe72535cf","createdAt":"2017-10-28T19:03:27.978Z","desc":"是时候客观评价Retrofit了，这几点你必须明白！","publishedAt":"2017-11-14T10:43:36.180Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/1f10d5477566","used":true,"who":"Tamic (码小白)"},{"_id":"59f681c7421aa90fe72535d6","createdAt":"2017-10-30T09:35:03.780Z","desc":"30多个Android开发者超赞的工具","publishedAt":"2017-11-14T10:43:36.180Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247487835&idx=1&sn=3b8ddd7fd4c52e1a4d6e5c1e601d91d7","used":true,"who":"陈宇明"},{"_id":"5a095a9c421aa90fef203520","createdAt":"2017-11-13T16:41:00.788Z","desc":"2017上半年技术文章集合\u2014184篇文章分类汇总","publishedAt":"2017-11-14T10:43:36.180Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/grssAxDKeDLHhURp0qtVPg","used":true,"who":"codeGoogler"},{"_id":"5a097d3b421aa90fe7253630","createdAt":"2017-11-13T19:08:43.576Z","desc":"微信资深工程师张绍文答读者问：T 型工程师更受大公司欢迎","publishedAt":"2017-11-14T10:43:36.180Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzU4MjAzNTAwMA==&mid=2247483827&idx=1&sn=a92f525a37c80290da7d48047ceb241b&chksm=fdbf32e4cac8bbf290cb317edba0c320f83dd2c024e9157dc58ab8f1b5cbccf3345cafee574d#rd","used":true,"who":null}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5a0b9888421aa90fef203530
         * createdAt : 2017-11-15T09:29:44.280Z
         * desc : Android与Python爱之初体验
         * publishedAt : 2017-11-16T12:01:05.619Z
         * source : web
         * type : Android
         * url : https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488220&idx=1&sn=834f2b928d2852ebdc4db1439ee0e08b
         * used : true
         * who : 陈宇明
         * images : ["http://img.gank.io/a3fc2a25-adea-45de-b186-17884187280c"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}

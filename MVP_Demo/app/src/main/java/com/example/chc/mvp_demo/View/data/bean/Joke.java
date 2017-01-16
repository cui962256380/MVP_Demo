package com.example.chc.mvp_demo.View.data.bean;

/**
 * Created by Administrator on 2017/1/16.
 */
public class Joke  {
        public  String content;
        public String hashId;
        public Long unixtime;
        public String updatetime;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHashId() {
            return hashId;
        }

        public void setHashId(String hashId) {
            this.hashId = hashId;
        }

        public Long getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(Long unixtime) {
            this.unixtime = unixtime;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }
}

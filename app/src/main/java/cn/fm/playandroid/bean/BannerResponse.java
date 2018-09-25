package cn.fm.playandroid.bean;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by Administrator on 2018/9/21.
 */

public final class BannerResponse {
    private int errorCode;
    @Nullable
    private String errorMsg;
    @Nullable
    private List data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Nullable
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(@Nullable String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Nullable
    public List getData() {
        return data;
    }

    public void setData(@Nullable List data) {
        this.data = data;
    }

    public class Data {
        private int id;
        private String url;
        private String imagePath;
        private String title;
        private String desc;
        private int isVisible;
        private int order;
        private int type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getIsVisible() {
            return isVisible;
        }

        public void setIsVisible(int isVisible) {
            this.isVisible = isVisible;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}

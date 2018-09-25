package cn.fm.playandroid.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/9/21.
 */

public final class LoginResponse {
    private int errorCode;
    private String errorMsg;
    private LoginResponse.Data data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static final class Data {
        private int id;
        private String username;
        private String password;
        private String icon;
        private int type;
        private List collectIds;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List getCollectIds() {
            return collectIds;
        }

        public void setCollectIds(List collectIds) {
            this.collectIds = collectIds;
        }
    }
}

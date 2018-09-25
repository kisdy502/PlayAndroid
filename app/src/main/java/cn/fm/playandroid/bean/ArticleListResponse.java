package cn.fm.playandroid.bean;

/**
 * Created by Administrator on 2018/9/21.
 */

public class ArticleListResponse {

    int errorCode;
    String errorMsg;
    Data data;

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
}

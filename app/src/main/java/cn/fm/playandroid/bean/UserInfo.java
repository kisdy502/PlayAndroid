package cn.fm.playandroid.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/6/7.
 */

public class UserInfo  {

    public final static int NOT_VIP = 0;
    public final static int IS_VIP = 1;
    public final static int VIP_EXPIRED = 2;
    private int id;

    @SerializedName("uid")
    private String uid;

    @SerializedName("userName")
    private String userName;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("token")
    private String token;

    @SerializedName("loginType")
    private int loginType;

    @SerializedName("vipType")
    private int vipType;    //赠送，月卡，季卡，年卡

    @SerializedName("isvip")
    private int isVip;    //0 ,1,2  非vip，vip，vip过期

    @SerializedName("giveDate")
    private int giveDate;    //0 ,1,2  非vip，vip，vip过期

    @SerializedName("giveTime")
    private int giveTime;    //0 ,1,2  非vip，vip，vip过期

    @SerializedName("expireDate")
    private long expireDate;

    public UserInfo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getVipType() {
        return vipType;
    }

    public void setVipType(int vipType) {
        this.vipType = vipType;
    }

    public int getIsVip() {
        return isVip;
    }

    public void setIsVip(int isVip) {
        this.isVip = isVip;
    }

    public int getGiveDate() {
        return giveDate;
    }

    public void setGiveDate(int giveDate) {
        this.giveDate = giveDate;
    }

    public int getGiveTime() {
        return giveTime;
    }

    public void setGiveTime(int giveTime) {
        this.giveTime = giveTime;
    }

    public long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(long expireDate) {
        this.expireDate = expireDate;
    }


    public boolean notVip() {
        return isVip == NOT_VIP;
    }

    public boolean isVip() {
        return isVip == IS_VIP;
    }

    public boolean vipExpired() {
        return isVip == VIP_EXPIRED;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

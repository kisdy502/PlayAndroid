package cn.fm.playandroid.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import cn.fm.playandroid.bean.UserInfo;
import cn.fm.playandroid.db.LDbHelper;
import cn.fm.playandroid.util.IoUtils;


/**
 * Created by Administrator on 2018/6/12.
 */

public class UserInfoDao implements IDao<UserInfo> {

    public final static String TBNAME = "t_userinfo";
    private Context mContext;
    private LDbHelper mDbHelper;

    public final static String CREATE_SQL = String.format("CREATE TABLE [%s](\n" +
            "  [_id] integer PRIMARY KEY AUTOINCREMENT, \n" +
            "  [uid] int NOT NULL, \n" +
            "  [userName] text NOT NULL, \n" +
            "  [avatar] text NULL, \n" +
            "  [token] text NOT NULL, \n" +
            "  [loginType] int NOT NULL, \n" +
            "  [vipType] int NOT NULL, \n" +
            "  [isvip] int NOT NULL, \n" +
            "  [giveDate] int NOT NULL, \n" +
            "  [giveTime] int NOT NULL, \n" +
            "  [expireDate] long NOT NULL);\n", TBNAME);

    public UserInfoDao(Context context) {
        this.mContext = context;
        this.mDbHelper = new LDbHelper(context);
    }

    public UserInfo queryUserInfo() {
        Cursor cursor = null;
        UserInfo userInfo = null;
        SQLiteDatabase sqLiteDatabase = mDbHelper.getReadableDatabase();
        cursor = sqLiteDatabase.query(TBNAME, null, null,
                null, null, null, null, "1");
        if (cursor != null && cursor.moveToNext()) {
            userInfo = cursor2Bean(cursor);
        }
        IoUtils.close(cursor);
        IoUtils.close(sqLiteDatabase);
        return userInfo;
    }

    @Nullable
    @Override
    public UserInfo query(int uid) {
        Cursor cursor = null;
        UserInfo userInfo = null;
        SQLiteDatabase sqLiteDatabase = mDbHelper.getReadableDatabase();
        cursor = sqLiteDatabase.query(TBNAME, null, "uid=?",
                new String[]{String.valueOf(uid)},
                null, null, null);
        if (cursor != null && cursor.moveToNext()) {
            userInfo = cursor2Bean(cursor);
        }
        IoUtils.close(cursor);
        IoUtils.close(sqLiteDatabase);
        return userInfo;
    }

    @Nullable
    @Override
    public List<UserInfo> queryAll() {
        SQLiteDatabase sqLiteDatabase = mDbHelper.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = sqLiteDatabase.query(TBNAME, null, null,
                    null,
                    null, null, null);
            List<UserInfo> userInfoList = new ArrayList<>();
            UserInfo userInfo = null;
            while (cursor.moveToNext()) {
                userInfo = cursor2Bean(cursor);
                userInfoList.add(userInfo);
            }
            return userInfoList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(cursor);
            IoUtils.close(sqLiteDatabase);
        }
        return null;
    }


    @Override
    public long insert(@NonNull List<UserInfo> list) {
        return 0;
    }

    @Override
    public long insert(@NonNull UserInfo userInfo) {
        long rowid = 0;
        SQLiteDatabase sqLiteDatabase = mDbHelper.getReadableDatabase();
        sqLiteDatabase.beginTransaction();
        ContentValues values = null;
        values = bean2ContentValues(userInfo);
        rowid = sqLiteDatabase.insert(TBNAME, null, values);
        sqLiteDatabase.setTransactionSuccessful();
        sqLiteDatabase.endTransaction();
        IoUtils.close(sqLiteDatabase);
        return rowid;
    }

    @Override
    public int update(@NonNull UserInfo userInfo) {
        SQLiteDatabase sqLiteDatabase = mDbHelper.getReadableDatabase();
        sqLiteDatabase.beginTransaction();
        ContentValues values = null;
        values = bean2ContentValues(userInfo);
        int result = sqLiteDatabase.update(TBNAME, values, "uid=?", new String[]{userInfo.getUid()});
        sqLiteDatabase.setTransactionSuccessful();
        sqLiteDatabase.endTransaction();
        IoUtils.close(sqLiteDatabase);
        return result;
    }

    @Override
    public int delete(int uid) {
        SQLiteDatabase sqLiteDatabase = mDbHelper.getReadableDatabase();
        sqLiteDatabase.beginTransaction();
        int result = sqLiteDatabase.delete(TBNAME, "uid=?", new String[]{String.valueOf(uid)});
        sqLiteDatabase.setTransactionSuccessful();
        sqLiteDatabase.endTransaction();
        IoUtils.close(sqLiteDatabase);
        return result;
    }

    @Override
    public int deleteAll() {
        SQLiteDatabase sqLiteDatabase = mDbHelper.getReadableDatabase();
        int result = sqLiteDatabase.delete(TBNAME, null, null);
        IoUtils.close(sqLiteDatabase);
        return result;
    }

    private ContentValues bean2ContentValues(UserInfo userInfo) {
        ContentValues values = new ContentValues();
        values.put("uid", userInfo.getUid());
        values.put("userName", userInfo.getUserName());
        values.put("avatar", userInfo.getAvatar());
        values.put("token", userInfo.getToken());
        values.put("loginType", userInfo.getLoginType());
        values.put("vipType", userInfo.getVipType());
        values.put("isvip", userInfo.getIsVip());
        values.put("giveDate", userInfo.getGiveDate());
        values.put("giveTime", userInfo.getGiveTime());
        values.put("expireDate", userInfo.getExpireDate());
        return values;
    }

    private UserInfo cursor2Bean(Cursor cursor) {
        int idx_id = cursor.getColumnIndex("_id");
        int idxuid = cursor.getColumnIndex("uid");
        int idxuserName = cursor.getColumnIndex("userName");
        int idxavatar = cursor.getColumnIndex("avatar");
        int idxtoken = cursor.getColumnIndex("token");
        int idxloginType = cursor.getColumnIndex("loginType");
        int idxvipType = cursor.getColumnIndex("vipType");
        int idxisvip = cursor.getColumnIndex("isvip");
        int idxisgivedate = cursor.getColumnIndex("giveDate");
        int idxisgivetime = cursor.getColumnIndex("giveTime");
        int idxexpireDate = cursor.getColumnIndex("expireDate");

        int _id = cursor.getInt(idx_id);
        String uid = cursor.getString(idxuid);
        String userName = cursor.getString(idxuserName);
        String avatar = cursor.getString(idxavatar);
        String token = cursor.getString(idxtoken);
        int loginType = cursor.getInt(idxloginType);
        int vipType = cursor.getInt(idxvipType);
        int isvip = cursor.getInt(idxisvip);
        int giveDate = cursor.getInt(idxisgivedate);
        int giveTime = cursor.getInt(idxisgivetime);
        long expireDate = cursor.getLong(idxexpireDate);

        UserInfo userInfo = new UserInfo();
        userInfo.setId(_id);
        userInfo.setUid(uid);
        userInfo.setUserName(userName);
        userInfo.setAvatar(avatar);
        userInfo.setToken(token);
        userInfo.setLoginType(loginType);
        userInfo.setVipType(vipType);
        userInfo.setIsVip(isvip);
        userInfo.setGiveDate(giveDate);
        userInfo.setGiveTime(giveTime);
        userInfo.setExpireDate(expireDate);
        return userInfo;
    }
}

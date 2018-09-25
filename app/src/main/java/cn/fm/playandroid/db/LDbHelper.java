package cn.fm.playandroid.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.util.ArrayMap;

import cn.fm.playandroid.db.dao.UserInfoDao;
import cn.fm.playandroid.db.upgrade.Upgrade;
import cn.fm.playandroid.db.upgrade.VersionFactory;


/**
 * Created by Administrator on 2018/6/10.
 */

public class LDbHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "laoban.db";
    private Context mContext;

    public LDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserInfoDao.CREATE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        ArrayMap<Integer, Upgrade> upgradeList = VersionFactory.getUpgradeList(oldVersion, newVersion, mContext);
        //按照版本号从低到高执行升级操作
        int size = upgradeList.size();
        for (int i = 0; i < size; i++) {
            upgradeList.valueAt(i).update(db);
        }
    }
}

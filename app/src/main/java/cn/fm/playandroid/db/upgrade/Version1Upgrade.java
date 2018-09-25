package cn.fm.playandroid.db.upgrade;

import android.database.sqlite.SQLiteDatabase;

import cn.fm.playandroid.log.ELog;


/**
 * Created by SDT13411 on 2018/3/22.
 */
@DbVersionCode(1)
public class Version1Upgrade extends Upgrade {

    @Override
    public void update(SQLiteDatabase db) {
         ELog.d("db version 1 upgrade");
    }
}

package cn.fm.playandroid.db.dao;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by SDT13411 on 2018/3/21.
 */

public interface IDao<T> {

    @Nullable
    T query(int id);

    @Nullable
    List<T> queryAll();

    long insert(@NonNull List<T> list);

    long insert(@NonNull T t);

    int update(@NonNull T t);

    int delete(int id);

    int deleteAll();
}

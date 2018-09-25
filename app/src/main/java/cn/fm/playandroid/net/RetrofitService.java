package cn.fm.playandroid.net;

/**
 * Created by Administrator on 2018/9/21.
 */


import cn.fm.playandroid.bean.ArticleListResponse;
import cn.fm.playandroid.bean.BannerResponse;
import cn.fm.playandroid.bean.FriendListResponse;
import cn.fm.playandroid.bean.HomeListResponse;
import cn.fm.playandroid.bean.HotKeyResponse;
import cn.fm.playandroid.bean.LoginResponse;
import cn.fm.playandroid.bean.TreeListResponse;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit请求api
 */
public interface RetrofitService {

    /**
     * 首页数据
     * http://www.wanandroid.com/article/list/0/json
     *
     * @param page page
     */

    @GET("/article/list/{page}/json")
    Observable<HomeListResponse> getHomeList(
            @Path("page") int page
    );

    /**
     * 知识体系
     * http://www.wanandroid.com/tree/json
     */
    @GET("/tree/json")
    Observable<TreeListResponse> getTypeTreeList();

    /**
     * 知识体系下的文章
     * http://www.wanandroid.com/article/list/0/json?cid=168
     *
     * @param page page
     * @param cid  cid
     */
    @GET("/article/list/{page}/json")
    Observable<ArticleListResponse> getArticleList(
            @Path("page") int page,
            @Query("cid") int cid
    );

    /**
     * 常用网站
     * http://www.wanandroid.com/friend/json
     */
    @GET("/friend/json")
    Observable<FriendListResponse> getFriendList();

    /**
     * 大家都在搜
     * http://www.wanandroid.com/hotkey/json
     */
    @GET("/hotkey/json")
    Observable<HotKeyResponse> getHotKeyList();

    /**
     * 搜索
     * http://www.wanandroid.com/article/query/0/json
     *
     * @param page page
     * @param k    POST search key
     */
    @POST("/article/query/{page}/json")
    @FormUrlEncoded
    Observable<HomeListResponse> getSearchList(
            @Path("page") int page,
            @Field("k") String k
    );

    /**
     * 登录
     *
     * @param username username
     * @param password password
     * @return Deferred<LoginResponse>
     */
    @POST("/user/login")
    @FormUrlEncoded
    Observable<LoginResponse> loginWanAndroid(
            @Field("username") String username,
            @Field("password") String password
    );

    /**
     * 注册
     *
     * @param username   username
     * @param password   password
     * @param repassowrd repassword
     * @return Deferred<LoginResponse>
     */
    @POST("/user/register")
    @FormUrlEncoded
    Observable<LoginResponse> registerWanAndroid(
            @Field("username") String username,
            @Field("password") String password,
            @Field("repassword") String repassowrd
    );

    /**
     * 获取自己收藏的文章列表
     *
     * @param page page
     * @return Deferred<HomeListResponse>
     */
    @GET("/lg/collect/list/{page}/json")
    Observable<HomeListResponse> getLikeList(
            @Path("page") int page
    );

    /**
     * 收藏文章
     *
     * @param id id
     * @return Deferred<HomeListResponse>
     */
    @POST("/lg/collect/{id}/json")
    Observable<HomeListResponse> addCollectArticle(
            @Path("id") int id
    );

    /**
     * 收藏站外文章
     *
     * @param title  title
     * @param author author
     * @param link   link
     * @return Deferred<HomeListResponse>
     */
    @POST("/lg/collect/add/json")
    @FormUrlEncoded
    Observable<HomeListResponse> addCollectOutsideArticle(
            @Field("title") String title,
            @Field("author") String author,
            @Field("link") String link
    );

    /**
     * 删除收藏文章
     *
     * @param id       id
     * @param originId -1
     * @return Deferred<HomeListResponse>
     */
    @POST("/lg/uncollect/{id}/json")
    @FormUrlEncoded
    Observable<HomeListResponse> removeCollectArticle(
            @Path("id") int id,
            @Field("originId") int originId
    );

    /**
     * 首页Banner
     *
     * @return BannerResponse
     */
    @GET("/banner/json")
    Observable<BannerResponse> getBanner();

    /**
     * 我的常用网址
     *
     * @return FriendListResponse
     */
    @GET("/lg/collect/usertools/json")
    Observable<FriendListResponse> getBookmarkList();
}

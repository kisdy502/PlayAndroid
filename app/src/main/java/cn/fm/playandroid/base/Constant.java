package cn.fm.playandroid.base;

/**
 * Constant
 */
public interface Constant {

    /**
     * baseUrl
     */
    String REQUEST_BASE_URL = "http://wanandroid.com/";
//    String REQUEST_BASE_URL = "http://mifeng.skyworthbox.com:8081";  //test for exception url
    /**
     * Share preferences name
     */
    String SHARED_NAME = "_preferences";
    String LOGIN_KEY = "login";
    String USERNAME_KEY = "username";
    String PASSWORD_KEY = "password";
    /**
     * result null
     */
    String RESULT_NULL = "result null!";

    /**
     * Debug
     */
    boolean INTERCEPTOR_ENABLE = true;
    /**
     * url key
     */
    String CONTENT_URL_KEY = "url";
    /**
     * title key
     */
    String CONTENT_TITLE_KEY = "title";
    /**
     * id key
     */
    String CONTENT_ID_KEY = "id";
    /**
     * cid key
     */
    String CONTENT_CID_KEY = "cid";
    /**
     * childrenData key
     */
    String CONTENT_CHILDREN_DATA_KEY = "childrenData";
    /**
     * target key
     */
    String CONTENT_TARGET_KEY = "target";
    /**
     * share key
     */
    String CONTENT_SHARE_TYPE = "text/plain";
    String SEARCH_KEY = "search";
    String LIKE_KEY = "like";

    int MAIN_REQUEST_CODE = 100;
    int MAIN_LIKE_REQUEST_CODE = 101;
}
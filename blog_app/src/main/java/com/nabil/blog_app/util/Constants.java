package com.nabil.blog_app.util;

/**
 * @author nabil
 * @at 2/11/23 11:54 PM
 */
public class Constants {
    public final static String POST_RESOURCE_NAME = "Post";
    public final static String COMMENT_RESOURCE_NAME = "Comment";
    public final static String CATEGORY_RESOURCE_NAME = "Category";
    public final static String FIELD_NAME = "id";
    public final static String COMMENT_DELETE_INFO = "Comment deleted successfully.";
    public final static String POST_DELETE_INFO = "Post deleted successfully.";
    public final static String CATEGORY_DELETE_INFO = "Category deleted successfully.";
    //----------------------------------------------------------//
    public final static String DEFAULT_VALUE_PAGE_NO = "0";
    public final static String DEFAULT_VALUE_PAGE_SIZE = "10";
    public final static String DEFAULT_VALUE_SORT_BY = "title";
    public final static String DEFAULT_VALUE_SORT_ORDER = "DESC";
    //----------------------------------------------------------//
    public final static String PAGE_NO = "pageNo";
    public final static String PAGE_SIZE = "pageSize";
    public final static String SORT_BY = "sortBy";
    public final static String SORT_ORDER = "sortOrder";
    //----------------------------------------------------------//
    public final static String APP_ROOT = "blog-app/api";
    //----------------------------------------------------------//
    public final static String PATH_POST_ID = "/posts/{postId}";
    public final static  String PATH_VARIABLE_POST_ID = "postId";
    public final static String POST_ENDPOINT = "/posts";
    //----------------------------------------------------------//
    public final static String COMMENT_ENDPOINT = "/comments";
    public final static String PATH_COMMENT_ID = "/comments/{commentId}";
    public final static  String PATH_VARIABLE_COMMENT_ID = "commentId";
    //----------------------------------------------------------//
    public final static String CATEGORY_ENDPOINT = "/categories";
    public final static String PATH_CATEGORY_ID = "/categories/{categoryId}";
    public final static  String PATH_VARIABLE_CATEGORY_ID = "categoryId";
    //----------------------------------------------------------//
    public final static  String NOT_EMPTY_NAME = "Name should not be null or empty";
    public final static  String NOT_EMPTY_EMAIL = "Email should not be null or empty";
    public final static  String NOT_EMPTY_BODY = "Body should not be null or empty";
    public final static  String NOT_EMPTY_TITLE = "Title should not be null or empty";
    public final static  String NOT_EMPTY_DESCRIPTION = "Description should not be null or empty";
    public final static  String NOT_EMPTY_CONTENT = "Content should not be null or empty";
    public final static  String SIZE_BODY = "Comment body must be minimum 10 characters";
    public final static  String SIZE_DESCRIPTION = "Description should have at least 10 characters";
    public final static  String SIZE_TITLE = "Title should have at least 2 characters";
    //----------------------------------------------------------//
}

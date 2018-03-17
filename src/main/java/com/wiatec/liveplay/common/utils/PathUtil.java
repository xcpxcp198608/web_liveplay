package com.wiatec.liveplay.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author patrick
 */
public class PathUtil {

    public static void main (String [] args){
        System.out.println(getUserDir());
        System.out.println(getClassPath());
        System.out.println(getResourcePath());
    }


    public static String getUserDir(){
        return System.getProperty("user.dir");
    }

    public static String getClassPath(){
        return PathUtil.class.getClass().getResource("/").getPath();
    }

    public static String getWebClassPath(){
        return PathUtil.class.getClass().getClassLoader().getResource("/").getPath();
    }

    public static String getResourcePath(){
        String classPath = getClassPath();
        int length = classPath.length();
        String resourcesPath = classPath.substring(0, length - 8);
        return resourcesPath + "resources/";
    }

    public static String getRealPath(HttpServletRequest request){
        return request.getSession().getServletContext().getRealPath("");
    }
}

package com.qinzheng.airline.utils;

import com.qinzheng.airline.pojo.SubmitData;

public class GetURL {
    public static String getUrl(SubmitData submitData){
        String result = null;
        String url = ConstantUtil.GET_AIRLINES_URL;
        if(submitData!=null){
            result = url.replace("STARTCITY",submitData.getStartCity()).replace("LASTCITY",submitData.getLastCity()).replace("DATE",submitData.getTheDate()).replace("USERID",submitData.getUserID());
        }
        return result;
    }
}

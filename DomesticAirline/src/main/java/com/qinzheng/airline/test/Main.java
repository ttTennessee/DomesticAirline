package com.qinzheng.airline.test;

import com.qinzheng.airline.pojo.Airlines;
import com.qinzheng.airline.pojo.AirlinesTime;
import com.qinzheng.airline.pojo.SubmitData;
import com.qinzheng.airline.utils.GetURL;
import com.qinzheng.airline.utils.SendGetter;
import com.qinzheng.airline.utils.XmlUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*SubmitData submitData = new SubmitData();
        submitData.setStartCity("TSN");
        submitData.setLastCity("XMN");
        submitData.setTheDate("");
        submitData.setUserID("");
        Airlines airlines = SendGetter.getBeanFromHttp(submitData);
        for (AirlinesTime airlinesTime : airlines.getList()) {
            System.out.println(airlinesTime.toString());
        }*/

        /*CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(GetURL.getUrl(submitData));
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        Airlines airlines;
        if(entity!=null) {
            String result = EntityUtils.toString(entity,"UTF-8");
//            InputStream ins = entity.getContent();
            airlines = XmlUtil.xmlToBean(result);
//            System.out.println(IOUtils.toString(ins,"UTF-8"));
            for (AirlinesTime data : airlines.getList()) {
                System.out.println(data.toString());
            }
        }*/
    }
}

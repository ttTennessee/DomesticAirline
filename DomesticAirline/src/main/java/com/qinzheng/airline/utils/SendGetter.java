package com.qinzheng.airline.utils;

import com.qinzheng.airline.pojo.Airlines;
import com.qinzheng.airline.pojo.SubmitData;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SendGetter {

    public static Airlines getBeanFromHttp(SubmitData submitData) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            URI uri = new URI(GetURL.getUrl(submitData));
            HttpGet httpGet = new HttpGet(uri);
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            Airlines airlines;
            if(entity!=null) {
                String result = EntityUtils.toString(entity,"UTF-8");
                airlines = XmlUtil.xmlToBean(result);
                return airlines;
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}

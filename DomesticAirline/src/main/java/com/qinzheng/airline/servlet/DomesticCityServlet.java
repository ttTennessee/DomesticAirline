package com.qinzheng.airline.servlet;

import com.qinzheng.airline.pojo.Address;
import com.qinzheng.airline.pojo.AddressList;
import com.qinzheng.airline.pojo.AirlinesTime;
import com.qinzheng.airline.utils.ConstantUtil;
import com.qinzheng.airline.utils.XmlUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static com.qinzheng.airline.utils.BeanUtil.mapToBean;

@WebServlet("/address")
public class DomesticCityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(ConstantUtil.POST_DOMESTICCITY_URL);
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity entity = httpResponse.getEntity();
        AddressList addressList = new AddressList();
        if(entity!=null) {
            String result = EntityUtils.toString(entity,"UTF-8");
            try {
                List<Address> list = new ArrayList<Address>();
                Document document = DocumentHelper.parseText(result);
                Element dataSet = document.getRootElement();
                Element diffgram = dataSet.element("diffgram");
                Element airline1 = diffgram.element("Airline1");
                Iterator itAir = airline1.elementIterator();
                while (itAir.hasNext()){
                    Map<String,String> map =new HashMap();
                    Element address = (Element) itAir.next();
                    Iterator itAdd = address.elementIterator();
                    while (itAdd.hasNext()){
                        Element element = (Element) itAdd.next();
                        map.put(XmlUtil.toLowerCaseFirstOne(element.getName()),element.getStringValue());
                    }
                    //调用Map转Bean方法，将得到的对象放入a中
                    Address a = mapToBean(map,Address.class);
                    list.add(a);
                }
                addressList.setList(list);
                req.getSession().setAttribute("add",addressList);
                resp.sendRedirect("/DomesticAirline/addlist.jsp");
            } catch (DocumentException e) {
                e.printStackTrace();
            }
//            req.getSession().setAttribute("add",addressList);
//            resp.sendRedirect("/addlist.jsp");
        }
    }
}

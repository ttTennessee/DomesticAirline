package com.qinzheng.airline.utils;

import com.qinzheng.airline.pojo.Airlines;
import com.qinzheng.airline.pojo.AirlinesTime;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.io.StringReader;
import java.util.*;

import static com.qinzheng.airline.utils.BeanUtil.mapToBean;

public class XmlUtil {
    /*public static Map<String, String> xmlToMap(HttpServletRequest req) throws IOException, DocumentException {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();

        InputStream ins = req.getInputStream();
        Document doc = reader.read(ins);

        Element root = doc.getRootElement();

        List<Element> list = root.elements();

        for(Element e : list) {
            map.put(e.getName(), e.getText());
        }
        ins.close();

        return map;
    }*/

    public static Airlines xmlToBean(String str){
//        SAXReader reader = new SAXReader();
        Airlines al = new Airlines();
        List<AirlinesTime> list = new ArrayList<AirlinesTime>();
        try {

            //通过字符串获取document
            Document document = DocumentHelper.parseText(str);
            //通过document对象获取根节点DataSet
            Element dataSet = document.getRootElement();
            Element diffgram = dataSet.element("diffgram");
            Element airlines = diffgram.element("Airlines");
            Iterator itAirlines = airlines.elementIterator();
            while (itAirlines.hasNext()){
                Element airlinesTime = (Element) itAirlines.next();
                //获取遍历AirlinesTime节点下的属性的迭代器
                Iterator itAirlinesTime = airlinesTime.elementIterator();
                //创建Map容器
                Map<String,String> map =new HashMap();
                //遍历AirlinesTime的每一个属性
                while (itAirlinesTime.hasNext()){
                    Element element = (Element) itAirlinesTime.next();
                    //将属性存进map容器，xml中属性键名首字母为大写，调用静态方法将首字母改为小写，否则获取的Bean值为null
                    map.put(toLowerCaseFirstOne(element.getName()),element.getStringValue());
                }
                //调用Map转Bean方法，将得到的对象放入a中
                AirlinesTime a = mapToBean(map,AirlinesTime.class);
//                System.out.println(a.toString());
                //将a加入list容器中
                list.add(a);
            }
            al.setList(list);
            /*//通过element对象获取迭代器
            Iterator itDataSet = dataSet.elementIterator();
            //遍历迭代器，获取根节点DataSet中的信息
            while (itDataSet.hasNext()){
                Element airlines = (Element) itDataSet.next();
                //进入diffgr:diffgram节点
                if ("diffgram".equals(airlines.getName())){
                    //跳过Airlines节点,直接进入AirlinesTime节点，获取AirlinesTime节点下的
                    Iterator itAirlines = ((Element) airlines.elementIterator().next()).elementIterator();
                    //遍历Airlines节点下的AirlinesTime节点
                    while (itAirlines.hasNext()){
                        Element airlinesTime = (Element) itAirlines.next();
                        //获取遍历AirlinesTime节点下的属性的迭代器
                        Iterator itAirlinesTime = airlinesTime.elementIterator();
                        //创建Map容器
                        Map<String,String> map =new HashMap();
                        //遍历AirlinesTime的每一个属性
                        while (itAirlinesTime.hasNext()){
                            Element element = (Element) itAirlinesTime.next();
                            //将属性存进map容器，xml中属性键名首字母为大写，调用静态方法将首字母改为小写，否则获取的Bean值为null
                            map.put(toLowerCaseFirstOne(element.getName()),element.getStringValue());
                        }
                        //调用Map转Bean方法，将得到的对象放入a中
                        AirlinesTime a = mapToBean(map,AirlinesTime.class);
                        //将a加入list容器中
                        list.add(a);
                        al.setList(list);
                    }
                }
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return al;
    }

    //首字母转小写
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}


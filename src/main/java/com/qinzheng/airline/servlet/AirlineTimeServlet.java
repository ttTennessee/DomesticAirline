package com.qinzheng.airline.servlet;

import com.qinzheng.airline.pojo.Airlines;
import com.qinzheng.airline.pojo.AirlinesTime;
import com.qinzheng.airline.pojo.SubmitData;
import com.qinzheng.airline.utils.SendGetter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/airlineTimes")
public class AirlineTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        SubmitData submitData = new SubmitData();
        submitData.setStartCity("天津");
        submitData.setLastCity("厦门");
        submitData.setTheDate("");
        submitData.setUserID("");

        Airlines airlines = SendGetter.getBeanFromHttp(submitData);
        for (AirlinesTime airlinesTime : airlines.getList()) {
            resp.getWriter().println(airlinesTime.toString()+"<br/>");
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //从post请求中获取数据
        String startCity = req.getParameter("startCity");
        String lastCity = req.getParameter("lastCity");
        String strDate = req.getParameter("theDate");
        if(strDate != null && !"".equals(strDate)){
            //创建SimpleDateFormat把获取的dd/MM/yyyy格式转换为Date
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            //从sdf1获取date
            Date date = null;
            try {
                date = sdf1.parse(strDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //创建SimpleDateFormat把date转换成String格式为yyyy-MM-dd
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            strDate = sdf2.format(date);
        }
        //创建数据提交对象 submitData
        SubmitData submitData = new SubmitData();
        //为submitData设置属性
        submitData.setStartCity(startCity);
        submitData.setLastCity(lastCity);
        submitData.setTheDate(strDate);
        submitData.setUserID("");
        //根据submitData对象获取xml，解析获得airlines
        Airlines airlines = SendGetter.getBeanFromHttp(submitData);
        //遍历airlines对象中的list
        /*for (AirlinesTime airlinesTime : airlines.getList()) {
            resp.getWriter().println(airlinesTime.toString()+"<br/>");
        }*/
        //把airlines存入Session
        req.getSession().setAttribute("al",airlines);
        //重定向到list.jsp
        resp.sendRedirect("/DomesticAirline/airlist.jsp");
    }
}

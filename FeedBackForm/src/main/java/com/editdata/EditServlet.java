package com.editdata;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BeanClass;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		//List<BeanClass> list = new ArrayList<>();
		int gin = Integer.parseInt(request.getParameter("gin"));
		String sdate = request.getParameter("date");
		String name = request.getParameter("name");
		String workingstatus = request.getParameter("workingstatus");
		String stime = request.getParameter("time");
		//Date date = Date.valueOf(sdate);
		Time time = Time.valueOf(stime);
		System.out.println(gin + " " +  " " + name + " " + workingstatus + " " + time);
		// AccessData.getData();
		//request.setAttribute("list", list);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

}

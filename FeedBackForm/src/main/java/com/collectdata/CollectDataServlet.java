package com.collectdata;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.userdao.UserDAO;

@WebServlet("/collect")
public class CollectDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int gin = Integer.parseInt(request.getParameter("gin"));
		String name = request.getParameter("name");
		String sdate = request.getParameter("date");
		String workingstatus = request.getParameter("workingstatus");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ldate = LocalDate.parse(sdate, formatter);
		Date date = Date.valueOf(ldate);
		LocalTime ltime = LocalTime.now();
		Time time = Time.valueOf(ltime);
		try {
			if (UserDAO.checkData(gin, date) == true) {

				response.sendRedirect("oldreponse.jsp");

			} else if (UserDAO.collectData(gin, name, date, workingstatus, time) == true) {
//				request.setAttribute("gin", gin);
//				request.setAttribute("date", date);
				//response.sendRedirect("success.jsp");
				HttpSession session=request.getSession();
				session.setAttribute("gin", gin);
				session.setAttribute("date",date);
				session.setAttribute("name", name);
				session.setAttribute("workingstatus",workingstatus);
				session.setAttribute("time",time);
				request.getRequestDispatcher("success.jsp").forward(request, response);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

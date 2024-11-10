package com.update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.updateDAO.UpdateDAO;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/updateservlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int gin = Integer.parseInt(request.getParameter("gin"));
		String name = request.getParameter("name");
		String sdate = request.getParameter("date");
		String workingstatus = request.getParameter("workingstatus");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate ldate = LocalDate.parse(sdate, formatter);
		Date date = Date.valueOf(ldate);
		try {
			if (UpdateDAO.updateData(gin, name, date, workingstatus) == true) {
				response.sendRedirect("updated.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

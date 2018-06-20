package com.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RetrieveLoggerFiles")
public class RetrieveLoggerFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RetrieveLoggerFiles() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\yogi8\\Documents\\My Files\\LFApplication");
		String[] files = file.list();
		ArrayList<String> filesList = new ArrayList<>();
		for (String string : files) {
			filesList.add(string);
		}
		request.setAttribute("files", filesList);
		request.getRequestDispatcher("display.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

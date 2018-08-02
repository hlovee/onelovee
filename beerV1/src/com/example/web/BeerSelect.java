package com.example.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.BeerExpert;

/**
 * Servlet¿ØÖÆÆ÷
 */
public class BeerSelect extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String c=request.getParameter("color");					/*2*/
		BeerExpert be=new BeerExpert();							/*2*/
		List result=be.getBrands(c);							/*2*/
/*
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("Beer Selection Advice<br />");
		Iterator it=result.iterator();
		while(it.hasNext()) {
			out.println("<br /> try: "+it.next());
		}
*/
/*		String c=request.getParameter("color");
1		out.println("<br />Got beer color "+c);
*/
		request.setAttribute("styles",result);
		RequestDispatcher view=request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
	}

}

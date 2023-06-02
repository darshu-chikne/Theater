package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TheaterModel;
@WebServlet("/movielink")
public class TheaterController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String moviename=req.getParameter("movie");
		int ticket=Integer.parseInt(req.getParameter("noofticket"));
		
		
		TheaterModel tm= new TheaterModel();
		double total=tm.displayTheater(moviename, ticket);
		
		if(total==0.0) {
     	RequestDispatcher rd = req.getRequestDispatcher("theatre1.jsp");
     	rd.forward(req, resp);
		}else {
			req.setAttribute("TotalBill", total);
	     	
			RequestDispatcher rd= req.getRequestDispatcher("theatre.jsp");
			rd.forward(req, resp);
		}
	}

}

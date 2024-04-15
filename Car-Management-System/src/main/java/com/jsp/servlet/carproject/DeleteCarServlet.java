package com.jsp.servlet.carproject;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
@WebServlet("/deleteCar")
public class DeleteCarServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int carId =Integer.parseInt(req.getParameter("carId"));
		
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Car.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session= sf.openSession();
		Transaction trans=session.beginTransaction();
		
		// Find Car object
		Car car=session.get(Car.class, carId);
		
		// Delete Car object
		session.delete(car);
		
		//Fetch the updated list of car objects
		Query<Car> query=session.createQuery("FROM Car");
		List<Car> cars=query.list();
		
		trans.commit();
		session.close();
		
		req.setAttribute("carList", cars);
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("DisplayAllCars.jsp");
		requestDispatcher.forward(req, resp);
		
	}
}

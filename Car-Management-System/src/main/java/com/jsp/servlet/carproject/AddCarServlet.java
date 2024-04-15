package com.jsp.servlet.carproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// to add servlet configuration directly

@WebServlet("/addNewCar")
public class AddCarServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int carId = Integer.parseInt(req.getParameter("carId"));
		String carBrand =req.getParameter("carBrand");
		String carModel =req.getParameter("carModel");
		int carPrice = Integer.parseInt(req.getParameter("carPrice"));
		
		Car car = new Car();
		car.setCarId(carId);
		car.setCarModel(carModel);
		car.setCarBrand(carBrand);
		car.setCarPrice(carPrice);
		
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Car.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		session.save(car);
		trans.commit();
		session.close();
		
		resp.sendRedirect("index.jsp");
		
		
	}

}

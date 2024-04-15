<%@page import="com.jsp.servlet.carproject.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <% Car car = (Car)request.getAttribute("existingCar");%>
  <h1> UPDATE CAR DETAILS</h1>
    <form action="saveUpdatedCar" method="post">
    <input type="number" name="carId" value="<%=car.getCarId()%>" readonly="true"> <br>
    <input type="text" name="carModel" value="<%=car.getCarModel()%>"> <br>
    <input type="text" name="carBrand" value="<%=car.getCarBrand()%>"><br>
    <input type="number" name="carPrice" value="<%=car.getCarPrice()%>"><br>
    <input type="submit" value="UPDATE">
    
    
    </form>

</body>
</html>
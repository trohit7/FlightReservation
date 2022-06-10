<%--
  Created by IntelliJ IDEA.
  User: rohit
  Date: 18/05/22
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flights</title>
</head>
<body>
<h2>Flights:</h2>
<table>
    <tr><th>Airlines</th>
        <th>Departure City</th>
        <th>Arrival City</th>
        <th>Departure Time</th>

    </tr>

    <c:forEach items="${flights}" var="flight">
        <tr>
            <td>${flight.operatingAirlines}</td>
            <td>${flight.departureCity}</td>
            <td>${flight.arrivalCity}</td>
            <td>${flight.estimatedDepartureTime}</td>
            <td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
        </tr>

    </c:forEach>
</table>

</body>
</html>

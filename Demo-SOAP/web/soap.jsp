<%@page import="au.edu.uts.wsd.soap.client.*"%>
<%@page contentType="text/html" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>SOAP Page</title>
    </head>
    <body>        
        
        <h1>WSD: Consume SOAP in JSP</h1> 
        <%           
            Calculator_Service locator = new Calculator_Service();
            Calculator ms = locator.getCalculatorPort();
            int n = (new Random().nextInt(10));
            double sqrt = ms.squareroot(n);
            double log = ms.logarithm(n);
            double exp = ms.exponent(n);   
            double factorial = ms.factorial(n);
        %>        
        <% out.print("Random generated number n = " +n); %>
        <p> Square root of <% out.print(n); %> : <%= sqrt %></p>
        <p> Logarithm of <% out.print(n); %>: <%= log %></p>
        <p> Exponent of <% out.print(n); %>: <%= exp %></p>        
        <p> Factorial of <% out.print(n); %>: <%= factorial %></p>
        <button class="button" onclick="location.reload();" >Refresh</button> 
        &emsp; 
        <button class="button" type="button" onclick="location.href='index.jsp'" > Home Page </button>
    </body>
</html>

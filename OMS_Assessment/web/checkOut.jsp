<%-- 
    Document   : checkOut
    Created on : 4-Oct-2018, 04:30:51
    Author     : Zexin Zhong
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="uts.wsd.*" import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
        <title>Check Out Page</title>
    </head>
    <body>
        <% String filePath = application.getRealPath("WEB-INF/movies.xml");%>
        <jsp:useBean id="movieApp" class="uts.wsd.MoviesApplication" scope="application">
            <jsp:setProperty name="movieApp" property="filePath" value="<%= filePath%>"/>
        </jsp:useBean>
        <% String path = application.getRealPath("WEB-INF/history.xml");%>
        <jsp:useBean id="orderApp" class="uts.wsd.OrderApplication" scope="application">
            <jsp:setProperty name="orderApp" property="filePath" value="<%=path%>"/>
        </jsp:useBean>
        <jsp:useBean id="shoppingCartApp" class="uts.wsd.ShoppingCart" scope="session">
            <jsp:setProperty name="shoppingCartApp" property="shoppingCart"/>
            <jsp:getProperty name="shoppingCartApp" property="shoppingCart"/>
        </jsp:useBean>
        <%
            User user = (User) session.getAttribute("userLogin");
            if (user == null) {%>
        <header>
            <nav class="nav">
                <ul>
                    <li><a href = "index.jsp">Home</a></li>
                </ul>
                <div align="right" margin-left="200px">
                    <a href = "login.jsp">Login</a>
                    <a href = "register.jsp">Register</a>
                </div>
            </nav>
        </header>
        <%} else {%>
        <header>
            <nav class="nav">
                <ul>
                    <li><a href = "index.jsp">Home</a></li>
                    <li><a href = "main.jsp">My History</a></li>
                </ul>
                <div align="right" margin-left="200px">
                    <a href = "logout.jsp">Logout</a>
                </div>
            </nav>
        </header>
        <%}%>
        <%
            //get the movie title that user select at the index page
            String title = request.getParameter("movieSelect");
            Movie movie = movieApp.getMovieByTitle(title);
            Item item = null;
            if (movie != null) {
                item = new Item();
                item.setMovieTitle(movie.getMovie_title());
                item.setMovieGenre(movie.getMovie_genre());
                item.setMoviePrice(movie.getMovie_price());
                item.setReleaseDate(movie.getMovie_release_date());
            }
            //get the shopping cart from the session
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
            if (item != null && !shoppingCart.isContainsItem(item)) {
                //add item to the shopping cart
                shoppingCart.addShoppingCart(item);
            }
        %>
        <form action="checkoutAction.jsp" method="post">
            <!-- display all items that stored in the shopping cart-->
            <table align="center" border = "2"style="width:50%">      
                <tr>
                    <td width="8.5%" align="center">Movie Title</td>
                    <td width="8.5%" align="center">Movie Price</td>
                    <td width="10%" align="center">Available Copies</td>
                    <td width="23%" align="center">Quantity</td>
                </tr>
                <%
                    for (Item shoppingCartItem : shoppingCart.getShoppingCart()) {
                %>
                <tr>
                    <td><%=shoppingCartItem.getMovieTitle()%></td>
                    <td><%=shoppingCartItem.getMoviePrice()%></td>
                    <td><%=movieApp.getMovieByTitle(shoppingCartItem.getMovieTitle()).getAvailable_copies()%></td>
                    <td><input type="text" value="<%=shoppingCartItem.getCopiesPurchased()%>" name = "<%=shoppingCartItem.getMovieTitle()%>"/>
                        &nbsp; 
                        <%
                            //store the shopping cart into the session
                            session.setAttribute("shoppingCart", shoppingCart);
                        %>
                        <button type="button" onclick="location.href = 'removeItemAction.jsp?removeItem=<%=shoppingCartItem.getMovieTitle()%>'" > Remove Item </button>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <center>
                <br><button type="button" onclick="location.href = 'index.jsp'" > Add more </button>
                <button type="button" onclick="location.href = 'clearShoppingCart.jsp'" > Clear Shopping Cart</button><br><br/>
                Payment Method <select name="paymentMethod" required>
                    <option value="">choose a payment method</option>
                    <option value = "CreditCard">Credit Card</option>
                    <option value = "PayPal">PayPal</option>
                </select>
                <input type="submit" value="check out">
                
            </center>
        </form>
    </body>
</html>

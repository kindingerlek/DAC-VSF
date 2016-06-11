<%-- 
    Document   : putTokenTemp
    Created on : 10/06/2016, 18:12:55
    Author     : Bruno
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="AccountValidation?id=${sessionScope.id}" method="POST">
            TOKEN<br />
            <input type="text" name="token" /><br />

            PASSWORD<br />
            <input type="password" name="password" /><br />
            <input type="submit" value="send"/>
        </form>
    </body>
</html>

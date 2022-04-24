<%-- 
    Document   : sayhello
    Created on : 08/02/2021, 23:08:15
    Author     : viter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% String formtype = request.getParameter("formtype"); %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=formtype.equals("hello") ? "Say Hello!" : "Say Good Bye!"%> (sayhello.jsp)</title>
        <link rel="stylesheet" href="global.css">
 
    </head>
    <body>
        <jsp:useBean id="myBean" class="hello.MessageBean"/>
        <h1><%=formtype.equals("hello") ? "Say Hello!" : "Say Good Bye!"%> (sayhello.jsp)</h1>
        <% String lang = request.getParameter("lang"); %>
        <jsp:setProperty name="myBean" property="lang" value="<%=lang%>"/>
        <% String pronoum = request.getParameter("pronoum"); %>
        <jsp:setProperty name="myBean" property="pronoum" value="<%=pronoum%>"/>
        <% String name = request.getParameter("name"); %>
        <jsp:setProperty name="myBean" property="name" value="<%=name%>"/>
        
        <jsp:setProperty name="myBean" property="formtype" value="<%=formtype%>"/>
        
        <jsp:getProperty name="myBean" property="msg"/>
    </body>
</html>

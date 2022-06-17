<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>JSP - Hello World</title>
  </head>
  <body>
    <h1><%= "Hello World!" %></h1>
    <br/>
    <a href="hello-servlet">Hello Servlet</a>
    <form action="hello-servlet" method="post">
      <label for="artistName">Name:</label>
      <input id="artistName" type="text" name="artistName"><br/>
      <input type="submit" value="Show">
    </form>
  </body>
</html>
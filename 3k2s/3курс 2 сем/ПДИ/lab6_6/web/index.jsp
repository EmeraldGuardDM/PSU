<%@ page import="library.LibraryHandl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>библиотека</title>
  </head>
  <body>
<table border="1" cellspacing="2">
  <tr>
    <td>Название книги</td> <td>Заказ или срок возвращения</td>
  </tr>
  <%=LibraryHandl.getBooks()%>
</table>
  </body>
</html>

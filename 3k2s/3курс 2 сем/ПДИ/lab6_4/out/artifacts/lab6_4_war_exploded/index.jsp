<%@ page import="handl.handl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>lab6</title>
  </head>
  <body>
  <table border="1" cellspacing="1" width="300px">
    <tr>
      <td width="60%">Товар</td><td>Количество</td>
    </tr>
    <%=handl.getTovar()%>
  </table>
  <br><br>
  <form action="add" method="get">
    Название товара:<span style="padding-left: 10px"><input type="text" name="tovar"></span><br>
    Количество(шт):<span style="padding-left: 12px"><input type="number" name="col"></span><br>
    <input type="submit" value="Отправить">
  </form>
  </body>
</html>

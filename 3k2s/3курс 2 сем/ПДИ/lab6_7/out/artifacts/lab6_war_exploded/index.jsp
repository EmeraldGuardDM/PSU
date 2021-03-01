<%@ page import="voter.VoterHandling" %><%--
  Created by IntelliJ IDEA.
  User: Nikich
  Date: 22.04.2016
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Vote</title>
  </head>
  <body>

  <form action="answer" method="get">
      <div>
          <%=VoterHandling.setMaxVotes()%>
          <h1>Опрос №<%=VoterHandling.getVoteNumber()%></h1>
      </div>
  <div style="width: 100px; float: left;padding: 5px">
    <input type="radio" name="vote" value="0"><%=VoterHandling.getOptionString(0)%>
    <br>
    <input type="radio" name="vote" value="1"><%=VoterHandling.getOptionString(1)%>
    <br>
    <input type="radio" name="vote" value="2"><%=VoterHandling.getOptionString(2)%>
  </div>
      <div style="padding: 5px; float: left;">
          <progress max="<%=VoterHandling.getVotedUsers(4)%>" value="<%=VoterHandling.getVotedUsers(0)%>"></progress><span style="padding: 0px 10px"><%=VoterHandling.getVotedUsers(0)%> из <%=VoterHandling.getVotedUsers(4)%></span>
          <br>
          <progress max="<%=VoterHandling.getVotedUsers(4)%>" value="<%=VoterHandling.getVotedUsers(1)%>"></progress><span style="padding: 0px 10px"><%=VoterHandling.getVotedUsers(1)%> из <%=VoterHandling.getVotedUsers(4)%></span>
          <br>
          <progress max="<%=VoterHandling.getVotedUsers(4)%>" value="<%=VoterHandling.getVotedUsers(2)%>"></progress><span style="padding: 0px 10px"><%=VoterHandling.getVotedUsers(2)%> из <%=VoterHandling.getVotedUsers(4)%></span>
      </div>
    <div style="padding-left: 100px; clear: left;">
      <br><br>
        <input type="hidden" name="votenumber" value="<%=VoterHandling.getVoteNumber()%>">
      <input type="submit" value="Проголосовать">
        <br><br>
        <a href="/statistic">Статистика</a>
    </div>
  </form>
  </body>
</html>
<%@ page import="com.lafin.servlet.model.user.ActionResult" %>
<%@ page import="com.lafin.servlet.model.user.UserPokemon" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  ActionResult result = (ActionResult) request.getAttribute("actionResult");
  String status = result.getStatus().getCode();
  String statusText = result.getStatus().getText();
  String say = result.getSay().talk();

  UserPokemon userPokemon = (UserPokemon) request.getAttribute("userPokemon");
  int hungry = userPokemon.getHungry();
  int happy = userPokemon.getHapiness();
%>
<script>
  let status = '<%= status%>';
  let statusText = '<%= statusText%>';
  let hungry = '<%= hungry%>';
  let happy = '<%= happy%>';
  let say = '<%= say%>';

  parent.changeStatus(status, statusText, hungry, happy);
  parent.talk(say);
</script>

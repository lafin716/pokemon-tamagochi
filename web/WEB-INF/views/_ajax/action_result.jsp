<%@ page import="com.lafin.servlet.model.user.ActionResult" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  ActionResult result = (ActionResult) request.getAttribute("actionResult");
  String status = result.getStatus().getCode();
  String statusText = result.getStatus().getText();
  String say = result.getSay().talk();
%>
<script>
  let status = '<%= status%>';
  let statusText = '<%= statusText%>';
  let say = '<%= say%>';

  parent.changeStatus(status, statusText);
  parent.talk(say);
</script>

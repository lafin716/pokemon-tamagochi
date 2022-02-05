<%--
  Created by IntelliJ IDEA.
  User: 82108
  Date: 2022-02-04
  Time: 오후 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <h1>회원가입</h1>
    <form name="registForm" action="/user/regist" method="post">
        이름 : <input type="text" name="name" value=""><br>
        이메일 : <input type="email" name="email" value=""><br>
        비밀번호 : <input type="password" name="password" value=""><br>
        <a href="/user/login">이미 회원이신가요?</a>
        <button type="submit">회원가입</button>
    </form>

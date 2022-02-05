<%--
  Created by IntelliJ IDEA.
  User: 82108
  Date: 2022-02-04
  Time: 오후 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <h1>로그인</h1>
    <form name="loginForm" action="/user/login" method="post">
        이메일 : <input type="text" name="email" value=""><br>
        비밀번호 : <input type="password" name="password" value=""><br>
        <a href="/user/regist">아직 회원이 아니신가요?</a>
        <button type="submit">로그인</button>
    </form>

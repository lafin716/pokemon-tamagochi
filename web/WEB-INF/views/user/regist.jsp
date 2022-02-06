<%--
  Created by IntelliJ IDEA.
  User: 82108
  Date: 2022-02-04
  Time: 오후 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="login-box">
    <h1>회원가입</h1>
    <form name="loginForm" action="/user/regist" method="post">
        <div class="form-row">
            <span>이름</span>
            <input type="text" name="name" value="">
        </div>
        <div class="form-row">
            <span>이메일</span>
            <input type="text" name="email" value="">
        </div>
        <div class="form-row">
            <span>비밀번호</span>
            <input type="password" name="password" value="">
        </div>
        <div class="form-row">
            <a href="/user/login">이미 회원이신가요?</a>
        </div>
        <div class="form-row">
            <button type="submit" class="btn-login">회원가입</button>
        </div>
    </form>
</div>

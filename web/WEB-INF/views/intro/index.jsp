<%@ page import="com.lafin.servlet.util.StringUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName = StringUtil.of(request.getAttribute("userName"));
%>

<div class="main-frame">
    <img class="normal-oh" src="/resources/images/npc/md_oh.gif">
    <img class="angry-oh gone" src="/resources/images/npc/md_oh_mad.gif">
</div>

<div class="interact-row">
    <div class="interact-box">
        <a href="#" class="btn-yes">예</a><br>
        <a href="#" class="btn-no">아니요</a>
    </div>
</div>
<p class="talk-box">
    포켓몬 세계에 온걸 환영한다.<br>
    내 이름은 오박사!<br>
    모두에게는 포켓몬 박사라고 불리고 있지<br>
    오늘은 <span class="special"><%= userName%></span>에게 포켓몬을 선물하려고 한다.<br>
    소중히 키울 자신이 있겠니?<br>
</p>

<script>
    const normalOh = document.querySelector('.normal-oh');
    const angryOh = document.querySelector('.angry-oh');
    const talkBox = document.querySelector('.talk-box');
    const btnYes = document.querySelector('.btn-yes');
    const btnNo = document.querySelector('.btn-no');

    function init() {
        bindBtnYes();
        bindBtnNo();
    }

    function bindBtnYes() {
        btnYes.addEventListener('click', function () {
            location.href = '/intro/starter';
        })
    }

    function bindBtnNo() {
        btnNo.addEventListener('click', function () {
            normalOh.classList.add('gone');
            angryOh.classList.remove('gone');
            talkBox.innerHTML = '내가 잘못 들은건가...? 포켓몬을 마다하다니...<br>세상에 그런 사람은 없어! 말도 안되는 소리 그만하고 어서 받으렴';
            btnNo.remove();
        })
    }

    window.onload = init;
</script>

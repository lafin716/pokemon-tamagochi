<%@ page import="com.lafin.servlet.util.StringUtil" %>
<%@ page import="com.lafin.servlet.constant.SessionKey" %>
<%@ page import="com.lafin.servlet.model.user.UserPokemon" %>
<%@ page import="com.lafin.servlet.constant.PokemonStatus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName = StringUtil.of(session.getAttribute(SessionKey.USER_NAME));
    UserPokemon mainPokemon = (UserPokemon) request.getAttribute("mainPokemon");

    PokemonStatus status = mainPokemon.getStatus();
    String statusCode = status.getCode();
    String statusText = status.getText();
    String initSay = status.getSay();
%>

<div class="main-frame">
    <div class="level-box">LV. <span class="level-label"><%= mainPokemon.getLevel()%></span></div>
    <div class="status-box <% if (status == PokemonStatus.NORMAL) {%>hide<%}%>"><%= statusText%></div>
    <img class="pokemon" src="/resources/images/pokemon/<%= mainPokemon.getPokemonCode()%>.gif">
</div>

<div class="menu-row">
    <div class="info-box">
        <div>배고픔 : <span class="hungry-label">0</span></div>
        <div>행복 : <span class="happy-label">0</span></div>
        <div>경험치 : <span class="exp-label">0</span></div>
    </div>
    <div class="menu-box">
        <a href="#" class="btn-feed">밥 주기</a><br>
        <a href="#" class="btn-pat">쓰다듬기</a><br>
        <a href="#" class="btn-workout">운동하기</a><br>
        <a href="#" class="btn-abandon">다른 포켓몬 받기</a>
    </div>
</div>

<p class="talk-box"></p>

<form id="actionForm" name="actionForm" method="post" action="" target="actionFrame">
    <input type="hidden" name="userPokemonId" value="<%= mainPokemon.getId()%>">
</form>

<form id="directForm" name="directForm" method="post" action="">
    <input type="hidden" name="userPokemonId" value="<%= mainPokemon.getId()%>">
</form>

<script>
    var STATUS = '<%= statusCode%>';
    var STATUS_MESSAGE = '<%= statusText%>';
    var INIT_SAY = '<%= initSay%>';
    var LEVEL = '<%= mainPokemon.getLevel()%>';
    var EXP = '<%= mainPokemon.getExp()%>';
    var HUNGRY = '<%= mainPokemon.getHungry()%>';
    var HAPPY = '<%= mainPokemon.getHapiness()%>';
</script>
<script src="/resources/js/level.js" charset="UTF-8"></script>
<script src="/resources/js/talk.js" charset="UTF-8"></script>
<script src="/resources/js/action.js" charset="UTF-8"></script>
<script src="/resources/js/stat.js" charset="UTF-8"></script>
<script>
    window.onload = function() {
        initLevel();
        initSay();
        startChitChat();
        startScheduling();
        initAction();
        showStatus();
    };
</script>

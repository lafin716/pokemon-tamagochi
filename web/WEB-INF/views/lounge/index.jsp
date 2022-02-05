<%@ page import="com.lafin.servlet.util.StringUtil" %>
<%@ page import="com.lafin.servlet.constant.SessionKey" %>
<%@ page import="com.lafin.servlet.model.user.UserPokemon" %>
<%@ page import="com.lafin.servlet.constant.PokemonStatus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName = StringUtil.of(session.getAttribute(SessionKey.USER_NAME));
    UserPokemon mainPokemon = (UserPokemon) request.getAttribute("mainPokemon");
    PokemonStatus status = mainPokemon.getStatus();
    String statusText = status.getText();
%>

<div class="main-frame">
    <div class="status-box <% if (status == PokemonStatus.NORMAL) {%>hide<%}%>"><%= statusText%></div>
    <img class="pokemon" src="/resources/images/pokemon/<%= mainPokemon.getPokemonCode()%>.gif">
</div>

<div class="menu-row">
    <div class="menu-box">
        <a href="#" class="btn-feed">밥 주기</a><br>
        <a href="#" class="btn-pat">쓰다듬기</a><br>
        <a href="#" class="btn-abandon">다른 포켓몬 받기</a>
    </div>
</div>

<p class="talk-box">
    안녕 <span class="special"><%= userName%></span>!<br>
</p>

<form id="actionForm" name="actionForm" method="post" action="" target="actionFrame">
    <input type="hidden" id="status" value="<%= mainPokemon.getStatus().getCode()%>">
    <input type="hidden" id="statusMessage" value="<%= mainPokemon.getStatus().getText()%>">
    <input type="hidden" name="userPokemonId" value="<%= mainPokemon.getId()%>">
</form>

<script src="/resources/js/poketalk.js" charset="UTF-8"></script>
<script src="/resources/js/pokeaction.js" charset="UTF-8"></script>
<script src="/resources/js/pokestat.js" charset="UTF-8"></script>
<script>
    window.onload = function() {
        startChitChat();
        initAction();
        showStatus();
    };
</script>

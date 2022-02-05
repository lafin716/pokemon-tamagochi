<%@ page import="com.lafin.servlet.util.StringUtil" %>
<%@ page import="com.lafin.servlet.constant.SessionKey" %>
<%@ page import="com.lafin.servlet.model.pokemon.Pokemon" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName = StringUtil.of(session.getAttribute(SessionKey.USER_NAME));
    List<Pokemon> starters = (List<Pokemon>) request.getAttribute("starterPokemons");
%>

<div class="main-frame">
    <div class="starter-box">
        <% for (int i = 0; i < starters.size(); i++) { %>
        <img src="/resources/images/pokemon/<%= starters.get(i).getSerialNumber()%>.gif">
        <% } %>
    </div>
</div>

<div class="interact-row">
    <div class="interact-box">
        <a href="#" class="btn-a">이상해씨</a><br>
        <a href="#" class="btn-b">파이리</a><br>
        <a href="#" class="btn-c">꼬부기</a><br>
    </div>
</div>
<p class="talk-box">
    <span class="special"><%= userName%></span>에게 줄 수 있는 포켓몬은 한마리!<br>
    마음에 드는 녀석을 골라서 데리고 가렴<br>
</p>

<form id="starterForm" name="starterForm" method="post" action="/intro/starter">
    <input type="hidden" id="pokemonId" name="pokemonId" value="">
</form>

<script>
    const form = document.querySelector("#starterForm");
    const pokemonId = document.querySelector("#pokemonId");
    const btnA = document.querySelector('.btn-a');
    const btnB = document.querySelector('.btn-b');
    const btnC = document.querySelector('.btn-c');

    function init() {
        bindBtnA();
        bindBtnB();
        bindBtnC();
    }

    function bindBtnA() {
        btnA.addEventListener('click', function () {
            pokemonId.value = 1;
            form.submit();
        })
    }

    function bindBtnB() {
        btnB.addEventListener('click', function () {
            pokemonId.value = 4;
            form.submit();
        })
    }

    function bindBtnC() {
        btnC.addEventListener('click', function () {
            pokemonId.value = 7;
            form.submit();
        })
    }

    window.onload = init;
</script>

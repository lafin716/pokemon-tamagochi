package com.lafin.servlet.constant;

public enum PokemonSay {
    GREETING("안녕!"),
    HUNGRY("배고프다... 밥 먹고싶어"),
    EAT("너무 맛있어! 정말 고마워~ \\^0 \\^"),
    FULL("아 너무 배부르다"),
    TOO_FULL("그...그만... 더는.."),
    WORKOUT("헉..헉.. 살 좀 빠진거 같아?"),
    DIGEST("소화가 되고있는거 같아~"),
    SICK("나 아픈거 같아.."),
    LONELY("외로워..."),
    GOOD("기분이 좋아진다 >0 <"),
    HAPPY("아 행복해! >0 <"),
    TOO_HAPPY("헤어스타일이 망가지면 어떡하지.."),
    LEAVE("넌 나에게 너무 관심이 없어 안녕."),
    DIE("R...I...P..."),
    REVOLUTION("어라...? 내가 진화했어! 앞으로도 잘 부탁해");

    private String message;

    PokemonSay(String message) {
        this.message = message;
    }

    public String talk() {
        return message;
    }
}

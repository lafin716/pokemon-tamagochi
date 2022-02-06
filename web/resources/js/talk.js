let chitChatScheduler;

const CHITCHAT_CYCLE = 15000;

const talkBox = document.querySelector('.talk-box');
const CHITCHATS = [
  '오늘 하루는 어땠어?',
  '난 항상 심심해',
  '무슨 취미를 좋아하니?',
  '제일 좋아하는 음식이 뭐야?',
  '여길 빠져 나가고 싶어',
  '나도 인간이 되고싶어',
];

function initSay() {
    talk(INIT_SAY);
}

function talk(message) {
    talkPrint(message);
}

function startChitChat() {
    if (!isAlive()) {
        return false;
    }
    stopChitChat();
    console.log('talk start');
    chitChatScheduler = setInterval(chitChatSomething, CHITCHAT_CYCLE);
}

function stopChitChat() {
    console.log('talk stop');
    clearInterval(chitChatScheduler);
}

function chitChatSomething() {
    let randomKey = randomNum(0, CHITCHATS.length - 1);
    talkPrint(CHITCHATS[randomKey]);
}

function randomNum(min, max){
    var randNum = Math.floor(Math.random()*(max-min+1)) + min;
    return randNum;
}

function talkPrint(text) {
    talkBox.innerHTML = text;
}
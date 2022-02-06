const statusBox = document.querySelector('.status-box');
const pokemonImg = document.querySelector('.pokemon');
const hungryLabel = document.querySelector('.hungry-label');
const happyLabel = document.querySelector('.happy-label');

function changeStatus(stat, statMsg, hungry, happy) {
    console.log('status change : ' + stat + ', ' + statMsg);
    STATUS = stat;
    STATUS_MESSAGE = statMsg;
    HUNGRY = hungry;
    HAPPY = happy;

    showStatus();
}

function isAlive() {
    if (STATUS === 'RUN') {
        return false;
    }

    if (STATUS === 'RELEASED') {
        return false;
    }

    if (STATUS === 'DEAD') {
        return false;
    }

    return true;
}

function showStatus() {
    console.log('status : ' + STATUS);

    // 배고픔, 행복지수 업데이트
    hungryLabel.innerHTML = HUNGRY;
    happyLabel.innerHTML = HAPPY;

    // 상태이상
    switch (STATUS) {
        case 'NORMAL':
            statusBox.classList.add('hide');
            statusBox.innerHTML = STATUS_MESSAGE;
            break;
        case 'DEAD':
            pokemonImg.setAttribute('src', '/resources/images/icon/dead.png');
            statusBox.classList.remove('hide');
            statusBox.innerHTML = STATUS_MESSAGE;
            stopChitChat();
            stopScheduling();
            break;
        case 'RUN':
        case 'RELEASE':
            pokemonImg.classList.add('hide');
            statusBox.classList.remove('hide');
            statusBox.innerHTML = STATUS_MESSAGE;
            stopChitChat();
            stopScheduling();
            break;
        default:
            statusBox.classList.remove('hide');
            statusBox.innerHTML = STATUS_MESSAGE;
            break;
    }
}
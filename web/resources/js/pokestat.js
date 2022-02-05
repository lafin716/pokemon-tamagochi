const statusBox = document.querySelector('.status-box');
const status = document.getElementById('status');
const statusMessage = document.getElementById('statusMessage');
const pokemonImg = document.querySelector('.pokemon');

function changeStatus(stat, statMsg) {
    status.value = stat;
    statusMessage.value = statMsg;
    showStatus();
}

function showStatus() {
    switch (status.value) {
        case 'NORMAL':
            statusBox.classList.add('hide');
            statusBox.innerHTML = statusMessage.value;
            break;
        case 'DEAD':
            pokemonImg.setAttribute('src', '/resources/images/etc/rip.gif');
            statusBox.classList.remove('hide');
            statusBox.innerHTML = statusMessage.value;
            stopChitChat();
            stopScheduling();
            break;
        case 'RUN':
        case 'RELEASE':
            pokemonImg.classList.add('hide');
            statusBox.classList.remove('hide');
            statusBox.innerHTML = statusMessage.value;
            stopChitChat();
            stopScheduling();
            break;
        default:
            statusBox.classList.remove('hide');
            statusBox.innerHTML = statusMessage.value;
            break;
    }
}
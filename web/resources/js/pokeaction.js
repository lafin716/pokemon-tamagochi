var actionScheduler;
const actionForm = document.getElementById('actionForm');
const btnFeed = document.querySelector('.btn-feed');
const btnPat = document.querySelector('.btn-pat');
const btnAbandon = document.querySelector('.btn-abandon');

function bindFeed() {
    btnFeed.addEventListener('click', feed);
}

function bindPat() {
    btnPat.addEventListener('click', pat);
}

function bindAbandon() {
    btnAbandon.addEventListener('click', abandon);
}

function startScheduling() {
    actionScheduler = setInterval(digest, 30000);
}

function stopScheduling() {
    clearInterval(actionScheduler);
}

function digest() {
    changeAction('/action/digest');
    action();
}

function feed() {
    changeAction('/action/feed');
    action();
}

function pat() {
    changeAction('/action/pat');
    action();
}

function abandon() {
    changeAction('/action/abandon');
    action();
}

function changeAction(action) {
    actionForm.setAttribute('action', action);
}

function action() {
    actionForm.submit();
}

function initAction() {
    startScheduling();
    bindFeed();
    bindPat();
    bindAbandon();
}
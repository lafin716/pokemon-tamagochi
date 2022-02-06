let digestScheduler;
let boringScheduler;

const DIGEST_CYCLE = 21000;
const BORING_CYCLE = 31000;

const actionForm = document.getElementById('actionForm');
const directForm = document.getElementById('directForm');
const btnFeed = document.querySelector('.btn-feed');
const btnPat = document.querySelector('.btn-pat');
const btnAbandon = document.querySelector('.btn-abandon');
const btnWorkout = document.querySelector('.btn-workout');

function bindFeed() {
    btnFeed.addEventListener('click', feed);
}

function bindPat() {
    btnPat.addEventListener('click', pat);
}

function bindAbandon() {
    btnAbandon.addEventListener('click', abandon);
}

function bindWorkout() {
    btnWorkout.addEventListener('click', workout);
}

function startScheduling() {
    if (!isAlive()) {
        return false;
    }
    stopScheduling();
    console.log('action start');
    digestScheduler = setInterval(digest, DIGEST_CYCLE);
    boringScheduler = setInterval(boring, BORING_CYCLE);
}

function stopScheduling() {
    console.log('action stop');
    clearInterval(digestScheduler);
    clearInterval(boringScheduler);
}

function digest() {
    changeAction('/action/digest');
    action();
}

function boring() {
    changeAction('/action/boring');
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
    directForm.setAttribute('action', '/action/abandon');
    directForm.submit();
}

function workout() {
    changeAction('/action/workout');
    action();
}

function changeAction(action) {
    actionForm.setAttribute('action', action);
}

function action() {
    actionForm.submit();
}

function initAction() {
    bindFeed();
    bindPat();
    bindAbandon();
    bindWorkout();
}

const levelLabel = document.querySelector('.level-label');
const pokemonImage = document.querySelector('.pokemon');

const SECOND_LEVEL = 5;
const THIRD_LEVEL = 10;

function initLevel() {
   resizePokemon(LEVEL);
}

function updateLevel(level) {
   resizePokemon(level);
   levelLabel.innerHTML = level;
}

function resizePokemon(level) {
   if (level >= THIRD_LEVEL) {
      pokemonImage.classList.remove('second');
      pokemonImage.classList.add('third');
      return;
   }

   if (level >= SECOND_LEVEL) {
      pokemonImage.classList.remove('third');
      pokemonImage.classList.add('second');
      return;
   }

   pokemonImage.classList.remove('second');
   pokemonImage.classList.remove('third');
}

function updatePokemon(pokemonCode) {
   let pokeUrl = "/resources/images/pokemon/" + pokemonCode + ".gif";
   console.log(pokeUrl);
   pokemonImage.setAttribute('src', pokeUrl);
}
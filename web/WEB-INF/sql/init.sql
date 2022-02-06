CREATE SCHEMA pokemon_tamagochi;

CREATE USER 'pokemon'@'%' IDENTIFIED BY 'poke12#$';

GRANT ALL PRIVILEGES ON pokemon_tamagochi.* TO 'pokemon'@'%';

FLUSH PRIVILEGES;
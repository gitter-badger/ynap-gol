# RULES

See:
- [https://kata-log.rocks/game-of-life-kata](https://kata-log.rocks/game-of-life-kata)
- [examples](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#Examples_of_patterns)

Or simply:
- A live cell with fewer than two live neighbours dies, by under population
- A live cell with more than three live neighbours dies, by overcrowding
- A live cell with two or three live neighbour’s lives on to the next generation
- A dead cell with exactly three live neighbours becomes a live cell


Iterativo incrementale

# TEST LIST aka Scenario List
Ma l'ordine delle celle conta? serve?

scenario IN -> OUT

scenario 1
ARRANGE/GIVEN
sono una cella viva che viene da seed

ACT/WHEN
il mondo si evolve

ASSERT/THEN
la cella seedata e' morta

---
scenario 2
sono una cella viva, con un vicino a sx vivo che viene da seed
il mondo si evolve
le celle rimangono vive
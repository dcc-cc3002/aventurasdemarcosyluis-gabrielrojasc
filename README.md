# AventurasdeMarcosyLuis

## Run instructions

To run the homework, due to the lack of a graphic interface, you will only need to run the tests,
which include all the methods and classes created.

## Assumptions made

As of now the characters' statistics must be given and are not calculated based on the level due to
a lack of knowledge on the formula to calculate them.

## Brief explanation of the functioning

They are two main characters, Marco and Luis, which are created with the abstract
class `abstractPlayer`, this class has all the implementations of the methods for the players and
this class implements the interface `IPlayers`, which has all the methods used by the players. The
enemies and items follow the same logic with the enemies having the abstract class `abstractEnemy`
and the interface `IEnemies`, and the items having the abstract class `abstractItem` and the
interface `IItem`.

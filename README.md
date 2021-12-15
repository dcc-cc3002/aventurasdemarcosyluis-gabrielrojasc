# AventurasdeMarcosyLuis

## Run instructions

To run the homework, you need to run GameApp inside the gui folder (not complete at all). For now
still run the tests.

## Assumptions made

As of now the characters' initial statistics must be given and the next level are calculated based
on the indications given.

## Brief explanation of the functioning

They are five characters Marco, Luis, Goomba, Spiny and Boo, they all share methods like getters and
setters, so the abstract class `abstractCharacter` was created to not repeat code and implements the
interface `ICharacters`, which has all the methods in common between all 5 characters. They are two
players, Marco and Luis, which are created with the abstract class `abstractPlayer`
which extends `abstractCharacter`, this class has all the implementations of the methods specific to
the players and this class implements the interface `IPlayers` which extends `ICharacters`, which
has all the methods specific to the players. The enemies, Goomba, Spiny and Boo, and items follow
the same logic with the enemies having the abstract class `abstractEnemy` which
extends `abstractCharacter`
and the interface `IEnemies` which extends `ICharacters`, and the items having the abstract
class `abstractItem` and the interface `IItem`.

The controller was created to make the interaction between characters, enemies and items without
directly calling the model classes and methods, so it can be able to communicate with the view (to
be created) and execute the requested actions.

Lastly, the phases were introduced to make the interaction between the controller and the view,
where the main phases are:

- StartPhase: the phase in which the game starts
- AttackPhase: the phase in which the player chooses the attack to use
- JumpAttackPhase/HammerAttackPhase: the phase in which the player chooses the target for the attack
- ItemPhase: the phase in which the player chooses the item to use
- PassPhase: the phase used by the player to pass






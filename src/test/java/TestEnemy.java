import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import enemy.Boo;
import enemy.Goomba;
import enemy.Spiny;
import enemy.interfaces.IEnemies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.Luis;
import player.Marco;

public class TestEnemy {

  private Goomba testGoomba;
  private Spiny testSpiny;
  private Boo testBoo;

  @BeforeEach
  public void setUp() {
    testGoomba = new Goomba(8, 5, 7, 42, 67);
    testSpiny = new Spiny(10, 52, 4, 2, 10);
    testBoo = new Boo(3, 9, 6, 27, 47);
  }

  @Test
  public void constructorTest() {
    /* Can't create a new enemy if maxHp is less than 0 */
    Exception exception1 =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IEnemies testExceptionGoomba = new Goomba(8, 5, 7, 10, -100);
            });
    String expectedMessage1 = "is not a valid maxHp";
    String actualMessage1 = exception1.getMessage();
    assertTrue(actualMessage1.contains(expectedMessage1));

    /* Can't create a new enemy if the hp is less than 0 */
    Exception exception2 =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IEnemies testExceptionGoomba = new Goomba(8, 5, 7, -10, 100);
            });
    String expectedMessage2 = "is not a valid hp";
    String actualMessage2 = exception2.getMessage();
    assertTrue(actualMessage2.contains(expectedMessage2));

    /* Can't create a new enemy if the hp is greater than maxHp */
    Exception exception3 =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IEnemies testExceptionGoomba = new Goomba(8, 5, 7, 150, 100);
            });
    String expectedMessage3 = "is not a valid hp";
    String actualMessage3 = exception3.getMessage();
    assertTrue(actualMessage3.contains(expectedMessage3));
  }

  @Test
  public void lvlGetterTest() {
    assertEquals(8, testGoomba.getLvl());
    assertEquals(10, testSpiny.getLvl());
    assertEquals(3, testBoo.getLvl());
  }

  @Test
  public void lvlSetterTest() {
    testGoomba.setLvl(10);
    assertEquals(10, testGoomba.getLvl());
    testSpiny.setLvl(15);
    assertEquals(15, testSpiny.getLvl());
    testBoo.setLvl(6);
    assertEquals(6, testBoo.getLvl());
  }

  @Test
  public void atkGetterTest() {
    assertEquals(5, testGoomba.getAtk());
    assertEquals(52, testSpiny.getAtk());
    assertEquals(9, testBoo.getAtk());
  }

  @Test
  public void atkSetterTest() {
    testGoomba.setAtk(10);
    assertEquals(10, testGoomba.getAtk());
    testSpiny.setAtk(40);
    assertEquals(40, testSpiny.getAtk());
    testBoo.setAtk(8);
    assertEquals(8, testBoo.getAtk());
  }

  @Test
  public void defGetterTest() {
    assertEquals(7, testGoomba.getDef());
    assertEquals(4, testSpiny.getDef());
    assertEquals(6, testBoo.getDef());
  }

  @Test
  public void defSetterTest() {
    testGoomba.setDef(10);
    assertEquals(10, testGoomba.getDef());
    testSpiny.setDef(9);
    assertEquals(9, testSpiny.getDef());
    testBoo.setDef(3);
    assertEquals(3, testBoo.getDef());
  }

  @Test
  public void hpGetterTest() {
    assertEquals(42, testGoomba.getHp());
    assertEquals(2, testSpiny.getHp());
    assertEquals(27, testBoo.getHp());
  }

  @Test
  public void hpSetterTest() {
    testGoomba.setHp(6);
    assertEquals(6, testGoomba.getHp());
    testSpiny.setHp(1);
    assertEquals(1, testSpiny.getHp());
    testBoo.setHp(17);
    assertEquals(17, testBoo.getHp());

    /* Can't set the hp of the enemy to a number smaller than 0 */
    Exception exception1 =
        assertThrows(IllegalArgumentException.class, () -> testGoomba.setHp(-13));
    String expectedMessage1 = "is not a valid hp";
    String actualMessage1 = exception1.getMessage();
    assertTrue(actualMessage1.contains(expectedMessage1));

    /* Can't set the hp of the enemy to a number greater than maxHp */
    Exception exception2 = assertThrows(IllegalArgumentException.class, () -> testGoomba.setHp(73));
    String expectedMessage2 = "is not a valid hp";
    String actualMessage2 = exception2.getMessage();
    assertTrue(actualMessage2.contains(expectedMessage2));
  }

  @Test
  public void maxHpGetterTest() {
    assertEquals(67, testGoomba.getMaxHp());
    assertEquals(10, testSpiny.getMaxHp());
    assertEquals(47, testBoo.getMaxHp());
  }

  @Test
  public void isKOTest() {
    assertFalse(testGoomba.isKO());
    assertFalse(testSpiny.isKO());
    assertFalse(testBoo.isKO());
    testGoomba.setHp(0);
    testSpiny.setHp(0);
    testBoo.setHp(0);
    assertTrue(testGoomba.isKO());
    assertTrue(testSpiny.isKO());
    assertTrue(testBoo.isKO());
  }

  @Test
  public void receiveDmgTest() {
    int dmg = 20;
    int expectedGoombaHp = testGoomba.getHp() - dmg;

    testGoomba.receiveDmg(dmg);

    assertEquals(expectedGoombaHp, testGoomba.getHp());
  }

  @Test
  public void getDmgTest() {
    Luis testLuis = new Luis(10, 20, 20, 50, 30, 50, 30);
    int expectedGoombaDmg =
        Math.round(
            (float) 0.75
                * testGoomba.getAtk()
                * ((float) testGoomba.getLvl() / (float) testLuis.getDef()));

    assertEquals(expectedGoombaDmg, testGoomba.getDmg(testLuis));
  }

  @Test
  public void jumpAttackedByPlayerTest() {
    Marco testMarco = new Marco(10, 20, 20, 50, 30, 50, 30);

    int expectedGoombaHp = testGoomba.getHp() - testMarco.getJumpDmg(testGoomba);
    int expectedSpinyHp = testSpiny.getHp();

    testGoomba.jumpAttackedByPlayer(testMarco);
    testSpiny.jumpAttackedByPlayer(testMarco);

    assertEquals(expectedGoombaHp, testGoomba.getHp());
    assertEquals(expectedSpinyHp, testSpiny.getHp());
  }

  @Test
  public void hammerAttackedByPlayerTest() {}
}

import com.example.aventurasdemarcoyluis.IEnemies;
import com.example.aventurasdemarcoyluis.Goomba;
import com.example.aventurasdemarcoyluis.Spiny;
import com.example.aventurasdemarcoyluis.Boo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestEnemy {

  private IEnemies testGoomba;
  private IEnemies testSpiny;
  private IEnemies testBoo;

  @BeforeEach
  public void setUp() {
    testGoomba = new Goomba(8, 5, 7, 42);
    testSpiny = new Spiny(10, 52, 4, 2);
    testBoo = new Boo(3, 9, 6, 27);
  }

  @Test
  public void constructorTest() {
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IEnemies testExceptionGoomba = new Goomba(8, 5, 7, -10);
            });
    String expectedMessage = "is not a valid hp";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
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

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              testGoomba.setHp(-10);
            });
    String expectedMessage = "is not a valid hp";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void isAliveTest() {
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
}

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.aventurasdemarcoyluis.HoneySyrup;
import com.example.aventurasdemarcoyluis.IItems;
import com.example.aventurasdemarcoyluis.IPlayers;
import com.example.aventurasdemarcoyluis.Luis;
import com.example.aventurasdemarcoyluis.Marco;
import com.example.aventurasdemarcoyluis.RedMushroom;
import com.example.aventurasdemarcoyluis.Star;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPlayer {
  private IPlayers testMarco;
  private IPlayers testLuis;

  @BeforeEach
  public void setUp() {
    testMarco = new Marco(10, 14, 3, 50, 30, 50, 50);
    testLuis = new Luis(12, 5, 4, 35, 6, 55, 18);
  }

  @Test
  public void constructorTest() {
    /* Can't create a new player if maxHp is less than 0 */
    Exception exception1 =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IPlayers testExceptionMarco = new Marco(8, 5, 7, 10, 6, -5, 10);
            });
    String expectedMessage1 = "is not a valid maxHp";
    String actualMessage1 = exception1.getMessage();
    assertTrue(actualMessage1.contains(expectedMessage1));

    /* Can't create a new enemy if the hp is less than 0 */
    Exception exception2 =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IPlayers testExceptionMarco = new Marco(8, 5, 7, -10, 6, 5, 18);
            });
    String expectedMessage2 = "is not a valid hp";
    String actualMessage2 = exception2.getMessage();
    assertTrue(actualMessage2.contains(expectedMessage2));

    /* Can't create a new enemy if the hp is greater than maxHp */
    Exception exception3 =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IPlayers testExceptionMarco = new Marco(8, 5, 7, 10, 6, 5, 18);
            });
    String expectedMessage3 = "is not a valid hp";
    String actualMessage3 = exception3.getMessage();
    assertTrue(actualMessage3.contains(expectedMessage3));

    /* Can't create a new player if maxFp is less than 0 */
    Exception exception4 =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IPlayers testExceptionMarco = new Marco(8, 5, 7, 10, 6, 50, -10);
            });
    String expectedMessage4 = "is not a valid maxFp";
    String actualMessage4 = exception4.getMessage();
    assertTrue(actualMessage4.contains(expectedMessage4));

    /* Can't create a new enemy if the fp is less than 0 */
    Exception exception5 =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IPlayers testExceptionMarco = new Marco(8, 5, 7, 10, -6, 50, 10);
            });
    String expectedMessage5 = "is not a valid fp";
    String actualMessage5 = exception5.getMessage();
    assertTrue(actualMessage5.contains(expectedMessage5));

    /* Can't create a new enemy if the fp is greater than maxFp */
    Exception exception6 =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IPlayers testExceptionMarco = new Marco(8, 5, 7, 10, 60, 50, 10);
            });
    String expectedMessage6 = "is not a valid fp";
    String actualMessage6 = exception6.getMessage();
    assertTrue(actualMessage6.contains(expectedMessage6));
  }

  @Test
  public void lvlGetterTest() {
    assertEquals(10, testMarco.getLvl());
    assertEquals(12, testLuis.getLvl());
  }

  @Test
  public void lvlSetterTest() {
    testMarco.setLvl(9);
    assertEquals(9, testMarco.getLvl());
    testLuis.setLvl(15);
    assertEquals(15, testLuis.getLvl());
  }

  @Test
  public void atkGetterTest() {
    assertEquals(14, testMarco.getAtk());
    assertEquals(5, testLuis.getAtk());

    testMarco.setHp(0);
    testLuis.setHp(0);

    assertEquals(0, testMarco.getAtk());
    assertEquals(0, testLuis.getAtk());
  }

  @Test
  public void atkSetterTest() {
    testMarco.setAtk(10);
    assertEquals(10, testMarco.getAtk());
    testLuis.setAtk(7);
    assertEquals(7, testLuis.getAtk());
  }

  @Test
  public void defGetterTest() {
    assertEquals(3, testMarco.getDef());
    assertEquals(4, testLuis.getDef());
  }

  @Test
  public void defSetterTest() {
    testMarco.setDef(9);
    assertEquals(9, testMarco.getDef());
    testLuis.setDef(6);
    assertEquals(6, testLuis.getDef());
  }

  @Test
  public void hpGetterTest() {
    assertEquals(50, testMarco.getHp());
    assertEquals(35, testLuis.getHp());
  }

  @Test
  public void hpSetterTest() {
    testMarco.setHp(20);
    assertEquals(20, testMarco.getHp());
    testLuis.setHp(12);
    assertEquals(12, testLuis.getHp());

    Exception exception1 = assertThrows(IllegalArgumentException.class, () -> testMarco.setHp(-10));
    String expectedMessage1 = "is not a valid hp";
    String actualMessage1 = exception1.getMessage();
    assertTrue(actualMessage1.contains(expectedMessage1));

    Exception exception2 = assertThrows(IllegalArgumentException.class, () -> testMarco.setHp(100));
    String expectedMessage2 = "is not a valid hp";
    String actualMessage2 = exception2.getMessage();
    assertTrue(actualMessage2.contains(expectedMessage2));
  }

  @Test
  public void fpGetterTest() {
    assertEquals(30, testMarco.getFp());
    assertEquals(6, testLuis.getFp());

    Exception exception1 = assertThrows(IllegalArgumentException.class, () -> testMarco.setFp(-10));
    String expectedMessage1 = "is not a valid fp";
    String actualMessage1 = exception1.getMessage();
    assertTrue(actualMessage1.contains(expectedMessage1));

    Exception exception2 = assertThrows(IllegalArgumentException.class, () -> testMarco.setFp(100));
    String expectedMessage2 = "is not a valid fp";
    String actualMessage2 = exception2.getMessage();
    assertTrue(actualMessage2.contains(expectedMessage2));
  }

  @Test
  public void fpSetterTest() {
    testMarco.setFp(21);
    assertEquals(21, testMarco.getFp());
    testLuis.setFp(9);
    assertEquals(9, testLuis.getFp());
  }

  @Test
  public void maxHpGetterTest() {
    assertEquals(50, testMarco.getMaxHp());
    assertEquals(55, testLuis.getMaxHp());
  }

  @Test
  public void itemGetterTest() {
    ArrayList<String> items = new ArrayList<>();
    assertEquals(items.toString(), testMarco.getItems());
  }

  @Test
  public void isAliveTest() {
    assertFalse(testMarco.isKO());
    assertFalse(testLuis.isKO());
    testMarco.setHp(0);
    testLuis.setHp(0);
    assertTrue(testMarco.isKO());
    assertTrue(testLuis.isKO());
  }

  @Test
  public void addItemTest() {
    IItems redMushroom = new RedMushroom();
    IItems star = new Star();
    ArrayList<String> items = new ArrayList<>();

    testMarco.addItem(redMushroom);
    items.add(redMushroom.getName());

    assertEquals(items.toString(), testMarco.getItems());

    testMarco.addItem(star);
    items.add(star.getName());

    assertEquals(items.toString(), testMarco.getItems());
  }

  @Test
  public void useItemTest() {
    IItems honeySyrup = new HoneySyrup();
    ArrayList<String> items = new ArrayList<>();

    testMarco.addItem(honeySyrup);
    items.add(honeySyrup.getName());
    assertEquals(items.toString(), testMarco.getItems());

    int beforeFp = testMarco.getFp();
    testMarco.useItem(honeySyrup);
    int afterFp = beforeFp + 3;
    assertEquals(afterFp, testMarco.getFp());
    items.remove(honeySyrup.getName());

    assertEquals(items.toString(), testMarco.getItems());
  }
}

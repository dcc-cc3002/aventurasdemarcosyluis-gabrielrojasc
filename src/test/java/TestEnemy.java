import com.example.aventurasdemarcoyluis.Enemies;
import com.example.aventurasdemarcoyluis.Goomba;
import com.example.aventurasdemarcoyluis.Spiny;
import com.example.aventurasdemarcoyluis.Boo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEnemy {

  private Enemies testGoomba;
  private Enemies testSpiny;
  private Enemies testBoo;

  @BeforeEach
  public void setUp() {
    testGoomba = new Goomba(8, 5, 7, 42, 50);
    testSpiny = new Spiny(10, 52, 4, 2, 2);
    testBoo = new Boo(3, 9, 6, 27, 30);
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
    testSpiny.setHp(9);
    assertEquals(9, testSpiny.getHp());
    testBoo.setHp(17);
    assertEquals(17, testBoo.getHp());
  }

  @Test
  public void maxHpGetterTest() {
    assertEquals(50, testGoomba.getMaxHp());
    assertEquals(2, testSpiny.getMaxHp());
    assertEquals(30, testBoo.getMaxHp());
  }
}

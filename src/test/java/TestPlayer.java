import com.example.aventurasdemarcoyluis.Marco;
import com.example.aventurasdemarcoyluis.Luis;
import com.example.aventurasdemarcoyluis.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPlayer {
  private Players testMarco;
  private Players testLuis;

  @BeforeEach
  public void setUp() {
    testMarco = new Marco(10, 14, 3, 50, 30, 50);
    testLuis = new Luis(12, 5, 4, 35, 6, 55);
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
  }

  @Test
  public void fpGetterTest() {
    assertEquals(30, testMarco.getFp());
    assertEquals(6, testLuis.getFp());
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
}

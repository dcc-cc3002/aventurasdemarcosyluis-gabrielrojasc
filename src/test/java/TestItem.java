import com.example.aventurasdemarcoyluis.HoneySyrup;
import com.example.aventurasdemarcoyluis.IItems;
import com.example.aventurasdemarcoyluis.Marco;
import com.example.aventurasdemarcoyluis.IPlayers;
import com.example.aventurasdemarcoyluis.RedMushroom;
import com.example.aventurasdemarcoyluis.Star;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestItem {

  private Star testStar;
  private RedMushroom testRedMushroom;
  private HoneySyrup testHoneySyrup;
  private IPlayers player;

  @BeforeEach
  public void setUp() {
    testStar = new Star();
    testRedMushroom = new RedMushroom();
    testHoneySyrup = new HoneySyrup();
    player = new Marco(10, 5, 2, 5, 10, 10);
  }

  @Test
  public void starTest() {
    int initialHp = player.getHp();
    testStar.applyTo(player);
    assertEquals(initialHp, player.getHp());
  }

  @Test
  public void redMushroomTest() {
    int beforeHp = player.getHp();
    int tenPercent = (int) (player.getMaxHp() * 0.1);
    int afterHp = beforeHp + tenPercent;
    testRedMushroom.applyTo(player);
    assertEquals(afterHp, player.getHp());
  }

  @Test
  public void honeySyrupTest() {
    int beforeFp = player.getFp();
    int afterFp = beforeFp + 3;
    testHoneySyrup.applyTo(player);
    assertEquals(afterFp, player.getFp());
  }

  @Test
  public void nameGetterTest() {
    assertEquals("Star", testStar.getName());
    assertEquals("RedMushroom", testRedMushroom.getName());
    assertEquals("HoneySyrup", testHoneySyrup.getName());
  }

  @Test
  public void equalTest() {
    IItems item1 = new HoneySyrup();
    IItems item2 = new HoneySyrup();
    assertEquals(item1, item2);
  }
}

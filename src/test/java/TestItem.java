import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.aventurasdemarcoyluis.model.characters.player.Marco;
import com.example.aventurasdemarcoyluis.model.item.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.item.IItems;
import com.example.aventurasdemarcoyluis.model.item.RedMushroom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestItem {

  private RedMushroom testRedMushroom;
  private HoneySyrup testHoneySyrup;
  private Marco player;

  @BeforeEach
  public void setUp() {
    testRedMushroom = new RedMushroom();
    testHoneySyrup = new HoneySyrup();
    player = new Marco(10, 5, 2, 5, 10, 10, 10);
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
    player.setFp(0);
    int beforeFp = player.getFp();
    int maxFp = player.getMaxFp();
    int afterFp = beforeFp + 3;

    testHoneySyrup.applyTo(player);
    assertEquals(afterFp, player.getFp());

    player.setFp(maxFp);
    testHoneySyrup.applyTo(player);
    assertEquals(maxFp, player.getFp());
  }

  @Test
  public void nameGetterTest() {
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

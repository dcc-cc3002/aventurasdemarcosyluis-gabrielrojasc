import com.example.aventurasdemarcoyluis.Marco;
import com.example.aventurasdemarcoyluis.Luis;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPlayer {
  private Marco testMarco;
  private Luis testLuis;

  @BeforeEach
  public void setUp() {
    testMarco = new Marco(10, 14, 3, 50, 30, 50);
  }

  @Test
  public void getterTest() {
    assertEquals(10, testMarco.getHp());
  }
}

import com.example.aventurasdemarcoyluis.Goomba;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEnemy {

  private Goomba testGoomba;

  @BeforeEach
  public void setUp() {
    testGoomba = new Goomba(8, 5, 2, 42, 50);
  }

  @Test
  public void getterTest() {
    assertEquals(8, testGoomba.getLvl());
  }
}

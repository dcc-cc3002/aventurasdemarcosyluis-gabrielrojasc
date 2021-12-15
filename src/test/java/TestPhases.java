import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.aventurasdemarcoyluis.controller.Controller;
import com.example.aventurasdemarcoyluis.controller.phases.AttackPhase;
import com.example.aventurasdemarcoyluis.controller.phases.Phase;
import com.example.aventurasdemarcoyluis.controller.phases.StartPhase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPhases {
  Controller controller;
  Phase startPhase;
  Phase attackPhase;

  @BeforeEach
  public void setUp() {
    this.controller = new Controller();
    this.startPhase = new StartPhase();
    this.attackPhase = new AttackPhase();
  }

  @Test
  public void toStringTest() {
    assertEquals(startPhase.toString(), "Start_Phase");
  }

  @Test
  public void changePhaseTest() {
    startPhase.setController(controller);
    controller.setPhase(startPhase);
    assertEquals(controller.getCurrentPhase(), startPhase.toString());
    controller.setPhase(attackPhase);
    assertEquals(controller.getCurrentPhase(), attackPhase.toString());
  }
}

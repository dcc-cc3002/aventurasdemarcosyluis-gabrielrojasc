module com.example.aventurasdemarcoyluis {
  requires javafx.controls;
  requires javafx.fxml;

  exports characters.enemy;

  opens characters.enemy to
      javafx.fxml;

  exports item;

  opens item to
      javafx.fxml;

  exports characters.player;

  opens characters.player to
      javafx.fxml;

  exports characters.enemy.interfaces;

  opens characters.enemy.interfaces to
      javafx.fxml;

  exports characters.player.interfaces;

  opens characters.player.interfaces to
      javafx.fxml;

  exports characters.enemy.interfaces.attacker;

  opens characters.enemy.interfaces.attacker to
      javafx.fxml;

  exports characters.enemy.interfaces.attackable;

  opens characters.enemy.interfaces.attackable to
      javafx.fxml;

  exports characters.player.interfaces.attackable;

  opens characters.player.interfaces.attackable to
      javafx.fxml;

  exports characters.player.interfaces.attacker;

  opens characters.player.interfaces.attacker to
      javafx.fxml;
}

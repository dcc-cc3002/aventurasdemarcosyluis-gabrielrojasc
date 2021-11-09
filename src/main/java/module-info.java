module com.example.aventurasdemarcoyluis {
  requires javafx.controls;
  requires javafx.fxml;

  exports model.characters.enemy;

  opens model.characters.enemy to
      javafx.fxml;

  exports model.item;

  opens model.item to
      javafx.fxml;

  exports model.characters.player;

  opens model.characters.player to
      javafx.fxml;

  exports model.characters.enemy.interfaces;

  opens model.characters.enemy.interfaces to
      javafx.fxml;

  exports model.characters.player.interfaces;

  opens model.characters.player.interfaces to
      javafx.fxml;
  opens model.characters.enemy.interfaces.attacker to
      javafx.fxml;

  exports model.characters.enemy.interfaces.attackable;

  opens model.characters.enemy.interfaces.attackable to
      javafx.fxml;

  exports model.characters.player.interfaces.attackable;

  opens model.characters.player.interfaces.attackable to
      javafx.fxml;
  opens model.characters.player.interfaces.attacker to
      javafx.fxml;

  exports model.characters.enemy.abstract_classes;

  opens model.characters.enemy.abstract_classes to
      javafx.fxml;

  exports model.characters.player.abstract_classes;

  opens model.characters.player.abstract_classes to
      javafx.fxml;
}

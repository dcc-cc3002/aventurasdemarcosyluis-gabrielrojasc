module com.example.aventurasdemarcoyluis {
  requires javafx.controls;
  requires javafx.fxml;

  exports com.example.aventurasdemarcoyluis;

  opens com.example.aventurasdemarcoyluis to
      javafx.fxml;

  exports com.example.aventurasdemarcoyluis.controller;

  opens com.example.aventurasdemarcoyluis.controller to
      javafx.fxml;

  exports com.example.aventurasdemarcoyluis.model.characters.character.abstract_classes;

  opens com.example.aventurasdemarcoyluis.model.characters.character.abstract_classes to
      javafx.fxml;

  exports com.example.aventurasdemarcoyluis.model.characters.character.interfaces;

  opens com.example.aventurasdemarcoyluis.model.characters.character.interfaces to
      javafx.fxml;

  exports com.example.aventurasdemarcoyluis.model.characters.enemy;

  opens com.example.aventurasdemarcoyluis.model.characters.enemy to
      javafx.fxml;

  exports com.example.aventurasdemarcoyluis.model.characters.enemy.abstract_classes;

  opens com.example.aventurasdemarcoyluis.model.characters.enemy.abstract_classes to
      javafx.fxml;

  exports com.example.aventurasdemarcoyluis.model.characters.enemy.factories;

  opens com.example.aventurasdemarcoyluis.model.characters.enemy.factories to
      javafx.fxml;

  exports com.example.aventurasdemarcoyluis.model.characters.enemy.interfaces;

  opens com.example.aventurasdemarcoyluis.model.characters.enemy.interfaces to
      javafx.fxml;

  exports com.example.aventurasdemarcoyluis.model.characters.enemy.interfaces.attackable;

  opens com.example.aventurasdemarcoyluis.model.characters.enemy.interfaces.attackable to
      javafx.fxml;

  exports com.example.aventurasdemarcoyluis.model.characters.player;

  opens com.example.aventurasdemarcoyluis.model.characters.player to
      javafx.fxml;

  exports com.example.aventurasdemarcoyluis.model.characters.player.abstract_classes;

  opens com.example.aventurasdemarcoyluis.model.characters.player.abstract_classes to
      javafx.fxml;

  exports com.example.aventurasdemarcoyluis.model.characters.player.interfaces;

  opens com.example.aventurasdemarcoyluis.model.characters.player.interfaces to
      javafx.fxml;

  exports com.example.aventurasdemarcoyluis.model.characters.player.interfaces.attackable;

  opens com.example.aventurasdemarcoyluis.model.characters.player.interfaces.attackable to
      javafx.fxml;

  exports com.example.aventurasdemarcoyluis.model.item;

  opens com.example.aventurasdemarcoyluis.model.item to
      javafx.fxml;

  exports com.example.aventurasdemarcoyluis.view;

  opens com.example.aventurasdemarcoyluis.view to
      javafx.fxml;
}

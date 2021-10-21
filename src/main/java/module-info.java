module com.example.aventurasdemarcoyluis {
  requires javafx.controls;
  requires javafx.fxml;

  exports enemy;

  opens enemy to
      javafx.fxml;

  exports item;

  opens item to
      javafx.fxml;

  exports player;

  opens player to
      javafx.fxml;
}

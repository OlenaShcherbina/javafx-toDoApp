module sample.todoapp {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;

  opens sample.todoapp to javafx.fxml;
  exports sample.todoapp;
  exports sample.todoapp.controllers;
  opens sample.todoapp.controllers to javafx.fxml;
  exports sample.todoapp.model;
  opens sample.todoapp.model to javafx.fxml;
  exports sample.todoapp.view;
  opens sample.todoapp.view to javafx.fxml;
}
package com.example.aventurasdemarcoyluis.controller.phases.exceptions;

/** Class that represents an invalid move exception */
public class InvalidMoveException extends Exception {

  /**
   * Creates an invalid movement exception
   *
   * @param message the message of exception
   */
  public InvalidMoveException(String message) {
    super(message);
  }
}

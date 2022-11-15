package encryptor.controller;

import encryptor.view.Console;

public class App {
  public static void main(String[] args) {
    try {
      Console console = new Console();
      User user = new User(console);
      user.startProgram();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
}

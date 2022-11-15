package encryptor.controller;

import java.io.File;
import java.util.Scanner;

import encryptor.model.Substitution;
import encryptor.model.Transposition;
import encryptor.view.Action;
import encryptor.view.Console;
import encryptor.view.InvalidInputException;

public class User {
  private Console console;
  private Substitution substitution = new Substitution();
  private Transposition transposition = new Transposition();

  public User(Console console) {
    this.console = console;
  }

  public void startProgram() {
    console.printWelcomeMessage();

    Action action = null;
    do {
      try {
        action = console.getAction();
        if (action == Action.SUBSTITUTION) {
          substitute();
        } else if (action == Action.TRANSPOSITION) {
          transpose();
        }
      } catch (InvalidInputException e) {
        console.printErrorMessage(e.getMessage());
      }
    } while (action != Action.QUIT);

    quitProgram();
  }

  private void quitProgram() {
    System.exit(0);
  }

  private void substitute() {
    System.out.println("\nSubstitution");

    // TODO: Implementera nedanstående
    /*
    Mode mode = console.getMode();
    SubstitutionKey key = console.getSubstitutionKey();
    File file = console.getFile();
    String text = getTextFromFile(file);

    if (mode == Mode.ENCRYPT) {
      substitution.encrypt(key, text);
    } else if (mode == Mode.DECRYPT) {
      substitution.decrypt(key, text);
    }
    */
  }

  private void transpose() {
    System.out.println("\nTransposition");
  }

  private String getTextFromFile(File file) {
    String text = null;

    try {
      StringBuffer buffer = new StringBuffer();
      Scanner reader = new Scanner(file, "utf-8");
      while (reader.hasNextLine()) {
        buffer.append(reader.nextLine());
      }
      reader.close();
      text = buffer.toString();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.exit(1);
    }

    return text;
  }
}

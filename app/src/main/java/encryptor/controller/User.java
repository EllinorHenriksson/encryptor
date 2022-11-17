package encryptor.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import encryptor.model.Substitution;
import encryptor.model.SubstitutionKey;
import encryptor.model.Transposition;
import encryptor.view.Action;
import encryptor.view.Console;
import encryptor.view.InvalidInputException;
import encryptor.view.Mode;

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
    Mode mode = getMode();
    SubstitutionKey key = console.getSubstitutionKey();
    File file = console.getFile();
    String text = getTextFromFile(file);

    if (mode == Mode.ENCRYPTION) {
      String cipher = substitution.encrypt(key, text);
      File cipherfile = createFile("cipher.txt");
      writeToFile(cipherfile, cipher);
      console.printFilePath(cipherfile);
    } else if (mode == Mode.DECRYPTION) {
      // TODO:
      // substitution.decrypt(key, text);
    }
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
    } catch (FileNotFoundException e) {
      System.out.println("The file was not found, quits program");
      System.exit(1);
    }

    return text;
  }

  public Mode getMode () {
    Mode mode = null;

    while (mode == null) {
      try {
        mode = console.getMode();
      } catch (InvalidInputException e) {
        console.printErrorMessage(e.getMessage());
      }
    }

    return mode;
  }

  private File createFile(String filename) {
    File file = new File(filename);

    try {  
      if (file.exists()) {
        file.delete();
      }

      file.createNewFile();
    } catch (IOException e) {
      console.printErrorMessage("Failed to create textfile, quits program");
      System.exit(1); 
    }

    return file;
  }

  private void writeToFile(File file, String text) {
    try {
      FileWriter fileWriter = new FileWriter(file);
      fileWriter.write(text);
      fileWriter.close();
    } catch (IOException e) {
      console.printErrorMessage("Failed to write to file, quits program");
      System.exit(1); 
    }
  }
}

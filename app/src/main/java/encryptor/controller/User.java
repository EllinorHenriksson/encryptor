package encryptor.controller;

import encryptor.model.Substitution;
import encryptor.model.SubstitutionKey;
import encryptor.model.Transposition;
import encryptor.view.Action;
import encryptor.view.Console;
import encryptor.view.InvalidInputException;
import encryptor.view.Mode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    File inputFile = console.getFile();
    String text = readFromFile(inputFile);

    String result = null;
    if (mode == Mode.ENCRYPTION) {
      result = substitution.encrypt(key, text);
    } else if (mode == Mode.DECRYPTION) {
      result = substitution.decrypt(key, text);
    }

    Path path = Paths.get(inputFile.getAbsoluteFile().getParent(), "result.txt");
    File outputFile = createFile(path);
    writeToFile(outputFile, result);
    console.printFilePath(outputFile);
  }

  private void transpose() {
    System.out.println("\nTransposition");
  }

  private String readFromFile(File file) {
    String text = null;
    try {
      text = Files.readString(file.toPath(), StandardCharsets.ISO_8859_1);
    } catch (IOException e) {
      System.out.println("Failed to read from file, quits program");
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

  private File createFile(Path path) {
    File file = new File(path.toString());

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
      FileOutputStream outputStream = new FileOutputStream(file.getAbsolutePath());
      OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "ISO-8859-1");
      outputStreamWriter.write(text);
      outputStreamWriter.close();
    } catch (Exception e) {
      console.printErrorMessage("Failed to write to file, quits program");
      System.exit(1);
    }
  }
}

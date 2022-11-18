package encryptor.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import encryptor.model.SubstitutionKey;

public class Console {
  private final Scanner scan = new Scanner(System.in, "utf-8");

  public void printWelcomeMessage() {
    System.out.println("\n***** Encryption/decryption tool *****");
  }

  public Action getAction() throws InvalidInputException {
    printMenu();
    String choice = scan.nextLine();
    
    if (choice.equals("s")) {
      return Action.SUBSTITUTION;
    } else if (choice.equals("t")) {
      return Action.TRANSPOSITION;
    } else if (choice.equals("q")) {
      return Action.QUIT;
    } else {
      throw new InvalidInputException("\"" + choice + "\"" + " is not a valid menu choice");
    }
  }

  public void printMenu() {
    String menu = "\ns : Substitution\nt : Transposition\nq : Quit\n\nEnter menu choice: ";
    System.out.print(menu);
  }

  public void printErrorMessage(String message) {
    System.out.println("\nError: " + message);
  }

  public Mode getMode() throws InvalidInputException {
    System.out.print("\nWould you like to encrypt or decrypt (e/d)? ");

    String input = scan.nextLine();
    if (input.equals("e")) {
      return Mode.ENCRYPTION;
    } else if (input.equals("d")) {
      return Mode.DECRYPTION;
    } else {
      throw new InvalidInputException("\"" + input + "\"" + " is not a valid mode");
    }
  }

  public SubstitutionKey getSubstitutionKey() {
    SubstitutionKey key = null;

    do {
      System.out.print("\nEnter a key (0-255): ");
      int input = Integer.parseInt(scan.nextLine());
      try {
        key = new SubstitutionKey(input);
      } catch (IllegalArgumentException e) {
        printErrorMessage(e.getMessage());
      }
    } while (key == null);

    return key;
  }

  public File getFile() {
    File file = null;

    do {
      System.out.print("\nEnter the absolute or relative path of the file: ");
      String input = scan.nextLine();
      try {
        file = new File(input);
        if (!file.isFile()) {
          file = null;
          throw new FileNotFoundException("The file does not exist");
        }
      } catch (NullPointerException e) {
        printErrorMessage("You must specify a file path");
      } catch (FileNotFoundException e) {
        printErrorMessage(e.getMessage());
      }
    } while (file == null);

    return file;
  }

  public void printFilePath(File file) {
    System.out.println("\nPath to file with the result: " + file.getPath());
  }
}

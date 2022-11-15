package encryptor.view;

import java.util.Scanner;

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
}

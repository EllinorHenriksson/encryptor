package encryptor.model;

public class Substitution {

  public String encrypt(SubstitutionKey keyobj, String plaintext) {
    char keychar = keyobj.getKey();

    /*
    int ascicode = keychar;
    System.out.println("ASCII-code: " + ascicode);
    */

    String cipher = "";
    // TODO: Algoritm

    return cipher + keychar;
  }

  public String decrypt(SubstitutionKey key, String chipher) {
    // TODO Auto-generated method stub
    return null;
  }
  
}

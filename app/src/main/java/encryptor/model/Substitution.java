package encryptor.model;

public class Substitution {

  private final int maxValue = 256;

  public String encrypt(SubstitutionKey keyobj, String plaintext) {
    int key = keyobj.getKey();

    char[] chars = plaintext.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      int charvalue = chars[i];
      int newCharValue = (charvalue + key) % maxValue;
      chars[i] = (char) newCharValue;
    }

    return String.valueOf(chars);
  }

  public String decrypt(SubstitutionKey keyobj, String cipher) {
    int key = keyobj.getKey();

    char[] chars = cipher.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      int charvalue = chars[i];
      int newCharValue = (maxValue + charvalue - key) % maxValue;
      chars[i] = (char) newCharValue;
    }

    return String.valueOf(chars);
  }
}


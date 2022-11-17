package encryptor.model;

public class SubstitutionKey {
  private char key;

  public SubstitutionKey(String key) {
    setKey(key);
  }

  public char getKey() {
    return key;
  }

  private void setKey(String key) {
    if (key.length() != 1) {
      throw new IllegalArgumentException("The key must be only one character long");
    }

    this.key = key.charAt(0);
  }
}

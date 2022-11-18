package encryptor.model;

public class SubstitutionKey {
  private int key;

  public SubstitutionKey(int key) {
    setKey(key);
  }

  public int getKey() {
    return key;
  }

  private void setKey(int key) {
    if (key < 0 || key > 255) {
      throw new IllegalArgumentException("The key must be a number between 0 and 255");
    }

    this.key = key;
  }
}

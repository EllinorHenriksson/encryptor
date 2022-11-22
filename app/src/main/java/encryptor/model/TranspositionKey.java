package encryptor.model;

public class TranspositionKey {
  String key;

  public TranspositionKey(String key) {
    setKey(key);
  }

  private void setKey(String key) {
    if (key == null || key.length() < 1) {
      throw new IllegalArgumentException("The key must be at least one character long");
    }

    this.key = key;
  }

  public String getKey() {
    return key;
  }
}

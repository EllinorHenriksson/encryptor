package hasher;

import java.util.ArrayList;
import java.util.Collections;

public class UniformityTester {
  private HashCodeGenerator hashCodeGenerator = new HashCodeGenerator();
  private StringGenerator randomStringGenerator = new StringGenerator();
  private ArrayList<String> inputs = new ArrayList<>();
  private final int numberOfInput = 2000;
  private final int maxStringLength = 1000;
  private final int numberOfHashCodes = 256;

  public UniformityTester() {
    generateInput();
  }

  private void generateInput() {
    for (int i = 0; i < numberOfInput; i++) {
      inputs.add(randomStringGenerator.generateRandomString(maxStringLength));
    }
  }

  public void testUniformity() {
    ArrayList<ArrayList<String>> hashTable = createHashTable();

    for (int i = 0; i < inputs.size(); i++) {
      String input = inputs.get(i);
      int hashCode = hashCodeGenerator.hash(input);
      hashTable.get(hashCode).add(input);
    }

    printHashTable(hashTable);
    printSummary(hashTable);
  }

  private ArrayList<ArrayList<String>> createHashTable() {
    ArrayList<ArrayList<String>> hashTable = new ArrayList<ArrayList<String>>();

    for (int i = 0; i < numberOfHashCodes; i++) {
      hashTable.add(new ArrayList<String>());
    }

    return hashTable;
  }

  private void printHashTable(ArrayList<ArrayList<String>> hashTable) {
    System.out.println("\n***** Hash table for uniformity test *****");
    System.out.println("(Bucket: Number of hash codes)");
    for (int i = 0; i < hashTable.size(); i++) {
      System.out.println(i + ": " +  hashTable.get(i).size());
    }
  }

  private void printSummary(ArrayList<ArrayList<String>> hashTable) {
    ArrayList<Integer> collisions = getCollisions(hashTable);

    int maxBucketSize = Collections.max(collisions);
    int numberOfEmptyBuckets = getNumberOfEmptyBuckets(collisions);
    double standardDeviation = calculateStandardDeviation(collisions);

    System.out.println("\n***** Summary of uniformity test *****");
    System.out.println("Max bucket size: " + maxBucketSize);
    System.out.println("Number of empty buckets: " + numberOfEmptyBuckets);
    System.out.println("Standard deviation: " + standardDeviation);
  }

  private ArrayList<Integer> getCollisions(ArrayList<ArrayList<String>> hashTable) {
    ArrayList<Integer> collisions = new ArrayList<>();
    for (int i = 0; i < hashTable.size(); i++) {
      collisions.add(hashTable.get(i).size());
    }
    return collisions;
  }

  private int getNumberOfEmptyBuckets(ArrayList<Integer> collisions) {
    int count = 0;
    for (int i = 0; i < collisions.size(); i++) {
      if (collisions.get(i) == 0) {
        count++;
      }
    }
    return count;
  }

  private double calculateStandardDeviation(ArrayList<Integer> collisions) {
    double average = getAverage(collisions);
    double sum = 0.0;
    for (int i = 0; i < collisions.size(); i++) {
      sum += Math.pow((collisions.get(i) - average), 2);
    }
    return Math.sqrt(sum / collisions.size());
  }

  private double getAverage(ArrayList<Integer> collisions) {
    double sum = 0.0;
    for (int i = 0; i < collisions.size(); i++) {
      sum += collisions.get(i);
    }
    return sum / collisions.size();
  }
}

package hasher.view;

import hasher.model.TestResult;
import java.util.ArrayList;

public class Console {

  public void printMessage(String message) {
    System.out.println(message);
  }

  public void printTestResult(TestResult result) {
    printHashTable(result.getHashTable());
    printSummary(result);
  }

  private void printHashTable(ArrayList<ArrayList<String>> hashTable) {
    System.out.println("----- Hash table -----");
    System.out.println("(Bucket: Number of hash codes)");
    for (int i = 0; i < hashTable.size(); i++) {
      System.out.println(i + ": " +  hashTable.get(i).size());
      for (int j = 0; j < hashTable.get(i).size(); j++) {
        System.out.println(hashTable.get(i).get(j));
      }
    }
  }
  
  private void printSummary(TestResult result) {
    System.out.println("\n---- Summary -----");
    System.out.println("Number of hashed strings: " + result.getNumberOfHashedStrings());
    System.out.println("Number of hash buckets: " + result.getNumberOfHashBuckets());
    System.out.println("Max bucket size: " + result.getMaxBucketSize());
    System.out.println("Number of empty buckets: " + result.getNumberOfEmptyBuckets());
    System.out.println("Standard deviation: " + result.getStandardDeviation());
  }
}

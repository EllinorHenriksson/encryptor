package hasher.model;

import java.util.ArrayList;
import java.util.Collections;

public class TestResult {
  ArrayList<ArrayList<String>> hashTable;
  ArrayList<Integer> collisions;
  String title;

  public TestResult(ArrayList<ArrayList<String>> hashTable, String title) {
    this.hashTable = hashTable;
    setCollisions();
    this.title = title;
  }

  private void setCollisions() {
    ArrayList<Integer> collisions = new ArrayList<>();
    for (int i = 0; i < hashTable.size(); i++) {
      collisions.add(hashTable.get(i).size());
    }
    this.collisions = collisions;
  }

  public String getTitle() {
    return title;
  }

  public ArrayList<ArrayList<String>> getHashTable() {
    return hashTable;
  }

  public int getNumberOfHashedStrings() {
    int sum = 0;
    for (int i = 0; i < collisions.size(); i++) {
      sum += collisions.get(i);
    }
    return sum;
  }

  public int getNumberOfHashBuckets() {
    return collisions.size();
  }

  public int getMaxBucketSize() {
    return Collections.max(collisions);
  }

  public int getNumberOfEmptyBuckets() {
    int count = 0;
    for (int i = 0; i < collisions.size(); i++) {
      if (collisions.get(i) == 0) {
        count++;
      }
    }
    return count;
  }

  public double getStandardDeviation() {
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

package hasher;

import java.util.ArrayList;

public class Tester {
  HashTester hashTester = new HashTester();
  StringGenerator stringGenerator = new StringGenerator();
  private final int numberOfInputForUniformity = 2000;
  private final int numberOfInputForRandomness = 1000;
  private final int maxStringLength = 1000;

  public void runTests() {
    ArrayList<String> inputsForUniformity = generateUniformityInput(); 
    hashTester.testUniformity(inputsForUniformity);
    ArrayList<String> inputsForRandomness = stringGenerator.generateSimilarStrings(numberOfInputForRandomness);
    hashTester.testRandomness(inputsForRandomness);
  }

  private ArrayList<String> generateUniformityInput() {
    ArrayList<String> inputs = new ArrayList<>();
    for (int i = 0; i < numberOfInputForUniformity; i++) {
      inputs.add(stringGenerator.generateRandomStringOfRandomSize(maxStringLength));
    }
    return inputs;
  }
}

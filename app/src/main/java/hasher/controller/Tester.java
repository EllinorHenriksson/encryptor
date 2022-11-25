package hasher.controller;

import hasher.model.HashTester;
import hasher.model.StringGenerator;
import hasher.model.TestResult;
import hasher.view.Console;
import java.util.ArrayList;

public class Tester {
  HashTester hashTester = new HashTester();
  StringGenerator stringGenerator = new StringGenerator();
  Console console = new Console();
  private final int numberOfInputForUniformity = 2000;
  private final int numberOfInputForRandomness = 1000;
  private final int maxStringLength = 1000;

  public void runTests() {
    ArrayList<String> inputsForUniformity = generateUniformityInput(); 
    TestResult uniformity = hashTester.testUniformity(inputsForUniformity);
    ArrayList<String> inputsForRandomness = stringGenerator.generateSimilarStrings(numberOfInputForRandomness);
    TestResult randomness = hashTester.testRandomness(inputsForRandomness);
    console.printMessage("\n********** Uniformity test **********");
    console.printTestResult(uniformity);
    console.printMessage("\n********** Randomness test **********");
    console.printTestResult(randomness);
  }

  private ArrayList<String> generateUniformityInput() {
    ArrayList<String> inputs = new ArrayList<>();
    for (int i = 0; i < numberOfInputForUniformity; i++) {
      inputs.add(stringGenerator.generateRandomStringOfRandomSize(maxStringLength));
    }
    return inputs;
  }
}

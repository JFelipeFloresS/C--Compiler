package test;

import static test.utils.CodeGeneratorTestUtils.runCGTest;

public class FullCodeGeneratorTest {
	public static void main(String... args) throws Exception {
		String inputFilePath = "./src/test/assets/full_cg_test_input.txt";
		String outputFilePath = "./src/test/assets/full_cg_test_output.txt";
		String expectedOutputFilePath = "./src/test/assets/full_cg_test_expected_output.txt";

		runCGTest(inputFilePath, outputFilePath, expectedOutputFilePath);
	}
}

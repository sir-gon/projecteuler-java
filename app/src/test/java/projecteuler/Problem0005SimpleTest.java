package projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

class Problem0005SimpleTest {

  static java.util.logging.Logger logger = projecteuler.util.CustomLogger.getLogger();

  @Test void problem0005InstanceTest() {
    Problem0005Simple classUnderTest = new Problem0005Simple();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0005Simple.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0005Simple.class)
    );
  }

  @Test void problem0005SmallTest() {

    Integer answer = 2520;
    Integer bottom = 1;
    Integer top = 10;
    Integer startFrom = 1;

    Integer solutionFound = Problem0005Simple.problem0005(bottom, top, startFrom);

    assertEquals(answer, solutionFound,
        String.format("Problem 0005 answer must be: %d", answer)
    );

  }

  @Test void problem0005BruteForceCuttedTest() {

    Integer answer = 232792560;
    Integer bottom = 1;
    Integer top = 20;
    Integer startFrom = answer - 1000;

    Integer solutionFound = Problem0005Simple.problem0005(bottom, top, startFrom);

    logger.info(String.format("Problem 00005 BRUTE FORCE stars..."));

    assertEquals(answer, solutionFound,
        String.format("Problem 0005 BRUTE-FORCE answer must be: %d", answer)
    );

    logger.info(String.format("Problem 00005 BRUTE FORCE ends."));
  }

  @EnabledIfEnvironmentVariable(named = "BRUTEFORCE", matches = "TRUE")
  @Test void problem0005BruteForceFull() {

    Integer answer = 232792560;
    Integer bottom = 1;
    Integer top = 20;
    Integer startFrom = 1;

    Integer solutionFound = Problem0005Simple.problem0005(bottom, top, startFrom);

    logger.info(String.format("Problem 00005 BRUTE FORCE stars..."));

    assertEquals(answer, solutionFound,
        String.format("Problem 0005 BRUTE-FORCE answer must be: %d", answer)
    );

    logger.info(String.format("Problem 00005 BRUTE FORCE ends."));
  }
}

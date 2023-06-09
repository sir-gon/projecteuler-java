// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Non-abundant sums
 *
 * https://projecteuler.net/problem=23
 *
 * A perfect number is a number for which the sum of its proper
 * divisors is exactly equal to the number. For example, the sum
 * of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28,
 * which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is
 * less than n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the
 * smallest number that can be written as the sum of two abundant numbers is 24.
 * By mathematical analysis, it can be shown that all integers greater
 * than 28123 can be written as the sum of two abundant numbers.
 * However, this upper limit cannot be reduced any further by analysis
 * even though it is known that the greatest number that cannot be expressed
 *  as the sum of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as
 * the sum of two abundant numbers.
 */

package projecteuler;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import projecteuler.helper.Divisors;
import projecteuler.helper.Divisors.DivisorsAbundance;
import projecteuler.helper.Sum;
// import projecteuler.helper.Sum;

/**
 * Problem 0023.
 */
public class Problem0023 {

  static java.util.logging.Logger logger = projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0023.
   */
  public static Integer problem0023(int _underLimit, int _superLimit) {
    ArrayList<Integer> abundantNumberList = new ArrayList<Integer>();

    // Produce a list of abundant numbers below limit
    for (int i = _underLimit; i <= _superLimit; i++) {
      DivisorsAbundance abundancyOf = Divisors.abundance((long) i);

      if (abundancyOf == DivisorsAbundance.DIVISORS_ABUNDANT) {
        abundantNumberList.add(i);
      }
    }

    logger.info(String.format(
        "abundant nums list size => %d", abundantNumberList.size()
    ));
    logger.fine(String.format(
        "abundant nums list result: => %s", abundantNumberList
    ));

    ArrayList<Integer> sumsAbundantNums = new ArrayList<Integer>();

    // Produce a list of sums of pair of abundant numbers below limit
    for (int i = 0; i < abundantNumberList.size(); i++) {
      for (int j = 0;
          j < abundantNumberList.size();
          j++
      ) {
        if (abundantNumberList.get(i) + abundantNumberList.get(j) <= _superLimit) {
          sumsAbundantNums.add(abundantNumberList.get(i) + abundantNumberList.get(j));
        }
      }
    }

    logger.info(String.format(
        "sumsAbundantNums size => %d", abundantNumberList.size()
    ));
    logger.fine(String.format(
        "sumsAbundantNums => %s", abundantNumberList
    ));

    ////////////////////
    // filter duplicates
    ////////////////////

    // Create a new LinkedHashSet
    Set<Integer> set = new LinkedHashSet<>();

    // Add the elements to set
    set.addAll(sumsAbundantNums);

    // Clear the list
    sumsAbundantNums.clear();

    // add the elements of set
    // with no duplicates to the list
    sumsAbundantNums.addAll(set);

    logger.fine(String.format(
        "sumsAbundantNums size: %d. result => %s",
        sumsAbundantNums.size(),
        sumsAbundantNums)
    );

    // All numbers below limit that not present in list of sums of pair of abundant numbers
    ArrayList<Integer> found = new ArrayList<Integer>();

    for (int i = 1; i <= _superLimit; i++) {
      if (!sumsAbundantNums.contains(i)) {
        found.add(i);
      }
    }

    logger.fine(String.format("found: %d, found => %s", found.size(), found));

    Integer[] foundArr = found.toArray(Integer[]::new);
    Integer result = Sum.sum(foundArr);

    logger.info(String.format("Problem 0023 result: %d", result));

    return result;
  }
}

//CHECKSTYLE.ON: JavadocParagraph

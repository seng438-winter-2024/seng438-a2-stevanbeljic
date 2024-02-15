**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group  8  |
| :--------------:|
| **Student Names**      |
|       Stevan Beljic            |
|        Aaron Giang             |
|        Angelo Troncone             |
|        Rutvi Brahmbhatt             |

# 1 Introduction

In this lab we were tasked with implemnting black box testing using unit tests on JFreeChart. Were meant to first familiarize ourselves with JFreeChart, then develop unit tests, using JMock and JUnit, based on the Javadoc files provided which outline the expected output and behaviour of given classes and methods. 
Upon familiarization with the system under test (SUT), we were asked to design a test plan and several test cases using a specific black-box test-case technique (equivalence classes, boundary values, etc.), and then evaluate the SUT's performance with our unit tests. We were to do this for method across 2 classes.
Specifically, we were tasked with creating unit tests for all 5 methods within org.jfree.data.DataUtilities, and 5 of our choosing within org.jfree.data.Range.

# 2 Detailed description of unit test strategy

Seeing as we are creating unit tests using documentation without getting familiar with the intricate inner workings of JFreeChart, we determined black-box testing as the most appropriate testing method to apply as we wish to analyze the system outputs compared to expected system outputs, specifically through the equivalance class technique. We deemed this technique to be most suitable seeing as we must consider wide ranges of inputs for each method, and we can largely expect the equivalent output for similarly valid or invalid inputs. 

Seeing as we are performing black-box testing using equivalence classes, it is necessary to parition a method's possible input parameters into groups which are divided by equivalent expected outputs. 

The 5 methods under test within **org.jfree.data.DataUtilities** are:
|   Method   |   Equivalence Class   |   Domains |   Validity  |
|  --------  |  :-------------------:  |  :--------: |   -----:   |
|`calculateColumnTotal(Values2D data, int column)`|  data: null value  |  data is null  |  Invalid |
|    |  data: null value  |  data is not null  |  Valid |
|    |  data: Sign of sum of values |  sum is negative  |  Valid |
|    |  data: Sign of sum of values |  sum is zero  |  Valid |
|    |  data: Sign of sum of values |  sum is positive  |  Valid |
|    |  data: Emptiness of data  |  data is empty  |  Valid |
|    |  data: Emptiness of data  |  data is not empty  |  Valid |
|    |  column: Validity of index  |  column < 0  |  Invalid |
|    |  column: Validity of index  |  column >= 0  |  Valid |
|  |  |  |  |
|`calculateRowTotal(Values2D data, int row)`|  data: null value  |  data is null  |  Invalid |
|    |  data: null value  |  data is not null  |  Valid |
|    |  data: Sign of sum of values |  sum is negative  |  Valid |
|    |  data: Sign of sum of values |  sum is zero  |  Valid |
|    |  data: Sign of sum of values |  sum is positive  |  Valid |
|    |  data: Emptiness of data  |  data is empty  |  Valid |
|    |  data: Emptiness of data  |  data is not empty  |  Valid |
|    |  row: Validity of index  |  row < 0  |  Invalid |
|    |  row: Validity of index  |  row >= 0  |  Valid |
|  |  |  |  |
|`createNumberArray(double[] data)`|  data: null value  |  data is null  |  Invalid |
|  | data:null value | data is not null | Valid |
|  | data: Emptiness of data | data is empty | Valid |
|  |  |  |  |
|`createNumberArray2D(double[][] data)`|  data: null value  |  data is null  | Invalid |
|  | data:Null value | data is not null | Valid |
|  | data: Empty | data is empty | Valid |
|  |  |  |  |
|`getCumulativePercentages(KeyedValues data)`|  KeyedValues: null value  |  data is null  |  Valid  |
|  |  KeyedValues: Empty  | data is empty | Valid |
|  | KeyedValues: positive | positive entries | Valid |
|  | KeyedValues: positive and negative| positive and negative entries | Valid |

Mock objects will be necessary for the testing of some methods in DataUtilities since they utilize complex objects whose inner-workings we are not concerned with, we simply need to simulate their outputs.

The 5 methods under test within **org.jfree.data.Range** are: 
|   Method   |   Equivalence Class   |   Domains |   Validity  |
|  --------  |  :-------------------:  |  :--------: |   -----:   |
|`shift​(Range base, double delta)`|delta: Sign|delta = 0|Valid|
|  |delta: Sign|delta > 0|Valid|
|  |base: Sign of bounds|upper bound > 0, lower bound > 0|Valid|
|  |base: Sign of bounds|upper bound > 0, lower bound < 0|Valid|
|  |base: Sign of bounds|upper bound < 0, lower bound < 0|Valid|
|  |base: Sign of bounds|upper bound < 0, lower bound > 0|Invalid|
|`intersects(double b0, double b1)`|bounds| object bound1 < b0 < object bound2 < b1   |Valid|
|  |bounds| object bound1 = b0 < object bound2 < b1   |Valid|
|  |bounds| object bound1 < object bound2 < b0 < b1   |Invalid|
|`range.getLowerBound()`| bounds | lower > 0  | Valid  |
|  | bounds | lower < 0 | Valid |
|  | bounds | lower = 0 | Valid |
|`range.getUpperBound()`| bounds | upper > 0  | Valid  |
|  | bounds | upper < 0 | Valid |
|  | bounds | upper = 0 | Valid |
|`range.toString()`|  bounds  |  upper bound > 0, lower bound > 0 |  Valid |
||  bounds  | upper bound > 0, lower bound < 0  |  Valid |
||  bounds  | upper bound < 0, lower bound < 0  |  Valid |
||  bounds  |  upper bound = 0 or lower bound = 0 |  Valid |


# 3 Test cases developed

## org.jfree.data.DataUtilities
| Method under Test| Test Method | Equivalence Class | Domain | Pass/Fail  |
|  --------  |--------|  :-------------------:  |  :--------: |   -----:   |
|`calculateColumnTotal(Values2D data, int column)`| `testCalculateColumnTotalDataNull` | data: null value  |  data is null  |  Fail |
| |`testCalculateColumnTotalDataNotNull`| data: null value  |  data is not null  |  Pass |
| |`testCalculateColumnTotalSumNegative`| data: Sign of sum of values |  sum is negative  |  Pass |
| |`testCalculateColumnTotalSumZero`| data: Sign of sum of values |  sum is zero  |  Pass |
| |`testCalculateColumnTotalSumPositive`| data: Sign of sum of values |  sum is positive  |  Pass |
| |`testCalculateColumnTotalEmpty`| data: Emptiness of data  |  data is empty  |  Pass |
| |`testCalculateColumnTotalNotEmpty`| data: Emptiness of data  |  data is not empty  |  Pass |
| |`testCalculateColumnTotalInvalidIndex`| column: Validity of index  |  column < 0  |  Pass |
| |`testCalculateColumnTotalInvalidIndex`|  column: Validity of index  |  column >= 0  |  Pass |
|`calculateRowTotal(Values2D data, int row)`| `testCalculateRowTotalDataNull`| data: null value  |  data is null  | Fail |
|  |`testCalculateRowTotalDataNotNull`  |  data: null value  |  data is not null  | Pass |
|  |`testCalculateRowTotalSumNegative`  |  data: Sign of sum of values |  sum is negative  | Pass |
|  |`testCalculateRowTotalSumZero`  |  data: Sign of sum of values |  sum is zero  | Pass |
|  |`testCalculateRowTotalSumPositive`  |  data: Sign of sum of values |  sum is positive  | Pass |
|  |`testCalculateRowTotalEmpty`  |  data: Emptiness of data  |  data is empty  | Pass |
|  |`testCalculateRowTotalNotEmpty`  |  data: Emptiness of data  |  data is not empty  | Pass |
|  |`testCalculateRowTotalInvalidIndex`  |  row: Validity of index  |  row < 0  | Pass |
|  |`testCalculateRowTotalValidIndex`  |  row: Validity of index  |  row >= 0  | Pass |
|`createNumberArray(double[] data)`| `testCreateNumberArrayNullData`| data: null value  |  data is null  | Fail |
|  |`testCreateNumberArrayNotNullData`| data:null value | data is not null | Fail |
|  |`testCreateNumberArrayEmptyData`| data: Emptiness of data | data is empty | Pass |
|`createNumberArray2D(double[][] data)`|`testCalculateNumberArray2DNullData`|  data: null value  |  data is null  | Fail |
|  |`testCalculateNumberArray2DNotNullData`| data:Null value | data is not null | Fail |
|  |`testCalculateNumberArray2DEmptyData`| data: Empty | data is empty | Pass |
|`getCumulativePercentages(KeyedValues data)`|`testGetCumulativePercentagesNullData`|  KeyedValues: null value  |  data is null  | Pass |
|  |`testGetCumulativePercentagesEmptyData`|  KeyedValues: Empty  | data is empty | Pass |
|  |`testGetCumulativePercentagesNonEmptyData`| KeyedValues: positive | positive entries | Fail |
|  |`testGetCumulativePercentagesNegativeValues`| KeyedValues: positive and negative| positive and negative entries | Fail |
## org.jfree.data.Range
| Method under Test| Test Method |Equivalence Class | Domain | Pass/Fail |
| ---- | ---- |:--: | :--: | ---: |
| `shift​(Range base, double delta)` | `shiftPositiveAndPositiveRangeWith0Test` |delta: Sign | delta = 0 | Pass |
|  | `` | delta: Sign | delta > 0 | Pass |
|  |``| base: Sign of bounds | upper bound > 0, lower bound > 0 | Pass |
|  |``| base: Sign of bounds | upper bound > 0, lower bound < 0 | Pass |
|  |``| base: Sign of bounds | upper bound < 0, lower bound < 0 | Pass |
| `intersects(double b0, double b1)` |`intersectsWithinBoundsTest`| bounds | object bound1 < b0 < object bound2 < b1 | Fail |
|  |`intersectsOnBoundsTest`| bounds | object bound1 = b0 < object bound2 < b1 | Fail |
|  |`intersectOutsideBoundsTest`| bounds | object bound1 < object bound2 < b0 < b1 | Pass |
| `getLowerBound()` |`getLowerBoundTestWithPositiveBounds`| bounds | lower > 0 | Pass |
| <br> |`getLowerBoundTestWithNegativeLowerBound`| bounds | lower < 0 | Pass |
|  |`getLowerBoundTestWithZeroLower`| bounds | lower = 0 | Pass |
| `getUpperBound()` |`getUpperBoundTestWithPositiveBounds`| bounds | upper > 0 | Fail |
|  |`getUpperBoundTestWithNegativeLowerBound`| bounds | upper < 0 | Fail |
|  |`getUpperBoundTestWithZeroUpper`| bounds | upper = 0 | Fail |
| `toString()` |`toStringTestWithPositiveBounds`| bounds | upper bound > 0, lower bound > 0 | Fail |
|  |`toStringTestWithNegativeLowerBound`| bounds | upper bound > 0, lower bound < 0 | Fail |
|  |`toStringTestWithTwoNegative`| bounds | upper bound < 0, lower bound < 0  | Fail |
|  |`toStringTestWithZeroUpper`| bounds | upper bound = 0  | Fail |
|  |`toStringTestWithZeroLower`| bounds | lower bound = 0 | Fail |

# 4 How the team work/effort was divided and managed

Familiarization with the SUT, planning of the specific test cases, as well as their developments have been done individually. Since there were 10 methods and 4 group members, two group members had to develop tests for one extra method. We established the equivalence class technique of black-box testing as a group, but ultimately decided familiarization and test case planning and development should be done individually as each method was very different and very few had common parameters which would be similar to other methods. After development and implementation of the unit tests, we came together as a group to educate and demonstrate our unit tests to eachother to familiarize eachother with eachothers' test cases and review in case of errors. 

# 5 Difficulties encountered, challenges overcome, and lessons learned

A difficulty we expected to run into during this lab, which we did, was learning how to use JMock. Even still, we do not feel confident in our ability to utilize JMock effectively, as our knowledge mostly comes from simple Google searches and the provided mocked code in the assignment description. We also had difficulty developing the unit tests for certain methods, such as calculateRowTotal of DataUtilities, when the component's behaviour did not align with the Javadoc information. In calculateRowTotal, for example, the indeces do not align with the documentation, as the documentation states they are 0-based when they are in practice 1-based. Furthermore, even the initial setup of all the various libraries and IDEs was somewhat difficult to get working on all of our computers even when following the provided instructions.

Overall, from the challenges posed by the lab, we learned the value of what mocking can provide for unit testing and why it is useful to use (so that you do not need to learn the intricacies of various other classes/objects which are isolated or distinct from the SUT. Even if we are not adept at using JMock, we better understand how and when it could be implemented.

# 6 Comments/feedback on the lab itself

**Stevan:** I found this lab to be much better than Assignment 1, as the instructions were much more clear and better-worded. The material for this lab was also very interesting and useful. I was already very familiar with JUnit going into this lab as I have used it for various personal and academic projects prior to this, but this was my first time using JMock and it was a very good technology to learn. JMock seems very useful when using it to subsitute for code not actively under test, and this lab did a good job of introducing us into its implementation and use.

**Angelo:** I found this lab to be more clearly defined that assignment 1. I also found it more applicational to what we were learning in class with the use of boundary values, weak/strong ECT, and mocking. Using JMock and actually seeing how mocking is used practically was very useful and made it easier for me to understand why it is used and when it should be used. I also appreciate the flexibility of allowing us to choose which methods of each library we wanted to test. Overall, I think this lab was very helpful in applying the concepts learned in class.

**Aaron:** The lab was straight forward and great practice in creating test sets for simple functions.  It was a practical experience in developing tests using black box testing techniques like equivalence classes and boundary values. Having to think about every class and boundary to cover all potential errors was a useful skill to learn during the assignment. Learning to use eclipse was initially a struggle but was very useful to use.

**Rutvi:** We used Junit as a primary testing framework for this lab. Test cases were designed as individual methods within the JUnit test class, allowing for clear separation and focused testing of specific functionalities. For this lab, our test suite aimed to achieve comprehensive coverage by testing various aspects of each method, including edge cases, empty datasets, and different input values. I found this lab a bit more practical and useful than the first lab.

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
|calculateColumnTotal(Values2D data, int column)|  data: null value  |  data is null  |  Invalid |
|    |  data: null value  |  data is not null  |  Valid |
|    |  data: Sign of sum of values |  sum is negative  |  Valid |
|    |  data: Sign of sum of values |  sum is zero  |  Valid |
|    |  data: Sign of sum of values |  sum is positive  |  Valid |
|    |  data: Emptiness of data  |  data is empty  |  Valid |
|    |  data: Emptiness of data  |  data is not empty  |  Valid |
|    |  column: Validity of index  |  column < 0  |  Invalid |
|    |  column: Validity of index  |  column >= 0  |  Valid |
|  |  |  |  |
|calculateRowTotal(Values2D data, int row)|  data: null value  |  data is null  |  Invalid |
|    |  data: null value  |  data is not null  |  Valid |
|    |  data: Sign of sum of values |  sum is negative  |  Valid |
|    |  data: Sign of sum of values |  sum is zero  |  Valid |
|    |  data: Sign of sum of values |  sum is positive  |  Valid |
|    |  data: Emptiness of data  |  data is empty  |  Valid |
|    |  data: Emptiness of data  |  data is not empty  |  Valid |
|    |  row: Validity of index  |  row < 0  |  Invalid |
|    |  row: Validity of index  |  row >= 0  |  Valid |
|  |  |  |  |
|createNumberArray(double[] data)|  data: null value  |  data is null  |  Invalid |
|  | data:null value | data is not null | Valid |
|  | data: Emptiness of data | data is empty | Valid |
|  |  |  |  |
|createNumberArray2D(double[][] data)|    |    |   |
|  |  |  |  |
|  |  |  |  |
| getCumulativePercentages(KeyedValues data) |    |    |    |
|  |  |  |  |

Mock objects will be necessary for the testing of some methods in DataUtilities since they utilize complex objects whose inner-workings we are not concerned with, we simply need to simulate their outputs.

The 5 methods under test within **org.jfree.data.Range** are: 
|   Method   |   Equivalence Class   |   Domains |   Validity  |
|  --------  |  :-------------------:  |  :--------: |   -----:   |
|Method 1|    |   |   |
|  |  |  |  |
|  |  |  |  |
|Method 2|    |   |   |
|  |  |  |  |
|  |  |  |  |
|Method 3|    |   |   |
|  |  |  |  |
|  |  |  |  |
|Method 4|    |   |   |
|  |  |  |  |
|  |  |  |  |
|Method 5|    |   |   |
|  |  |  |  |


# 3 Test cases developed

## org.jfree.data.DataUtilities
| Method  | Equivalence Class | Domain | Pass/Fail  |
|  --------  |  :-------------------:  |  :--------: |   -----:   |

## org.jfree.data.Range
| Method  | Equivalence Class | Domain | Pass/Fail  |
|  --------  |  :-------------------:  |  :--------: |   -----:   |

# 4 How the team work/effort was divided and managed

Familiarization with the SUT, planning of the specific test cases, as well as their developments have been done individually. Since there were 10 methods and 4 group members, two group members had to develop tests for one extra method. We established the equivalence class technique of black-box testing as a group, but ultimately decided familiarization and test case planning and development should be done individually as each method was very different and very few had common parameters which would be similar to other methods. After development and implementation of the unit tests, we came together as a group to educate and demonstrate our unit tests to eachother to familiarize eachother with eachothers' test cases and review in case of errors. 

# 5 Difficulties encountered, challenges overcome, and lessons learned

A difficulty we expected to run into during this lab, which we did, was learning how to use JMock. Even still, we do not feel confident in our ability to utilize JMock effectively, as our knowledge mostly comes from simple Google searches and the provided mocked code in the assignment description. We also had difficulty developing the unit tests for certain methods, such as calculateRowTotal of DataUtilities, when the component's behaviour did not align with the Javadoc information. In calculateRowTotal, for example, the indeces do not align with the documentation, as the documentation states they are 0-based when they are in practice 1-based. Furthermore, even the initial setup of all the various libraries was somewhat difficult to get working on all of our computers.

Overall, from the challenges posed by the lab, we learned the value of what mocking can provide for unit testing and why it is useful to use (so that you do not need to learn the intricacies of various other classes/objects which are isolated or distinct from the SUT. Even if we are not adept at using JMock, we better understand how and when it could be implemented.

# 6 Comments/feedback on the lab itself

**Stevan:** I found this lab to be much better than Assignment 1, as the instructions were much more clear and better-worded. The material for this lab was also very interesting and useful. I was already very familiar with JUnit going into this lab as I have used it for various personal and academic projects prior to this, but this was my first time using JMock and it was a very good technology to learn. JMock seems very useful when using it to subsitute for code not actively under test, and this lab did a good job of introducing us into its implementation and use.

**Angelo:** Stuff here...

**Aaron:** Stuff here...

**Rutvi:** Stuff here...

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

Text…

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

// write down the name of the test methods and classes. Organize the based on
the source code method they test. identify which tests cover which partitions
you have explained in the test strategy section above



# 4 How the team work/effort was divided and managed

Text…

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…

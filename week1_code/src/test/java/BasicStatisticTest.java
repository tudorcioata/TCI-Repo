import org.junit.Test;
import static org.junit.Assert.*;

public class BasicStatisticTest {
    private static final double DELTA = 1e-15;

    //the number of data items is 0 when none are present
    @Test
    public void testNrOfDataEqualsZeroWhenArrayIsEmpty() {
        // Arrange
        BasicStatistic bs = new BasicStatistic();
        // Act
        int expectedResult = bs.numberOfDataItems();
        // Assert
        assertEquals(0,expectedResult);
    }

    //after clearing of data, the number of items is 0
    @Test
    public void testCountAfterClearingData() {
        BasicStatistic bs = new BasicStatistic();
        bs.addDoubleToData(25.0);
        bs.addDoubleToData(32.0);
        // act
        bs.clearData();
        int expectedResult = bs.numberOfDataItems();
        // assert
        assertEquals(0,expectedResult);
    }

    //after adding, the number of items is != 0
    @Test
    public void testCountDifferentThanZeroAfterAddingData() {
        // arrange
        BasicStatistic bs = new BasicStatistic();
        bs.addDoubleToData(10.0);
        bs.addDoubleToData(17.0);
        // act
        int expectedResult = bs.numberOfDataItems();
        // assert
        assertTrue(expectedResult != 0);
    }

    //after adding of X data items, the number of items is increased by X
    @Test
    public void testIfIncreasesIsCorrectAfterAddingData() {
        // arrange
        BasicStatistic bs = new BasicStatistic();
        bs.addDoubleToData(10.0);
        bs.addDoubleToData(13.0);
        bs.addDoubleToData(19.0);
        bs.addDoubleToData(25.0);
        // act
        int expectedResult = bs.numberOfDataItems();
        // assert
        assertEquals(4, expectedResult);
    }

    //Define and create tests which test the behaviour of the sum() method
    //1. test if sum = 0 if there is no data
    @Test
    public void testMethodSumIfDataIsEmpty() {
        // arrange
        BasicStatistic bs = new BasicStatistic();
        // act
        double expectedResult = bs.sum();
        // assert
        assertEquals(0, expectedResult, DELTA);
    }

    //2. test if sum works as intended
    @Test
    public void testMethodSum() {
        // arrange
        BasicStatistic bs = new BasicStatistic();
        bs.addDoubleToData(11.0);
        bs.addDoubleToData(25.3);
        bs.addDoubleToData(25.0);
        // act
        double expectedResult = bs.sum();
        // assert
        assertEquals(61.3,expectedResult,DELTA);
    }

    //1. test getMedian(), odd numbers
    @Test
    public void testMedianForOddNr() throws NoDataItemsException {
        // arrange
        BasicStatistic bs = new BasicStatistic();
        bs.addDoubleToData(22.0);
        bs.addDoubleToData(16.1);
        bs.addDoubleToData(35.0);
        bs.addDoubleToData(16.2);
        bs.addDoubleToData(9.0);
        // act
        double expectedResult = bs.getMedian();
        // assert
        assertEquals(16.2,expectedResult,DELTA);
    }

    //2. test getMedian(), even numbers
    @Test
    public void testMedianForEvenNr() throws NoDataItemsException {
        // arrange
        BasicStatistic bs = new BasicStatistic();
        bs.addDoubleToData(26.0);
        bs.addDoubleToData(16.0);
        bs.addDoubleToData(22.0);
        bs.addDoubleToData(15.0);
        // act
        double expectedResult = bs.getMedian();
        // assert
        assertEquals(19.0, expectedResult, DELTA);
    }

    //test mean method if works as intended - must return average
    @Test
    public void testIfMeanResultIsDisplayed() throws NoDataItemsException {
        // arrange
        BasicStatistic bs = new BasicStatistic();
        bs.addDoubleToData(10.5);
        bs.addDoubleToData(25.5);
        // act
        double result = bs.getMean();
        // assert
        assertEquals(18,result,DELTA);
    }

    //test to see if the highest value is displayed
    @Test
    public void testIfHighestValueIsDisplayed() throws NoDataItemsException {
        // arrange
        BasicStatistic bs = new BasicStatistic();
        bs.addDoubleToData(3.3);
        bs.addDoubleToData(99.0);
        bs.addDoubleToData(74.5);
        // act
        double result = bs.highestValue();
        // assert
        assertEquals(99,result,DELTA);
    }
}


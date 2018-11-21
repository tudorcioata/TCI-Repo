import java.util.ArrayList;
import java.util.Collections;

public class BasicStatistic implements BasicStatisticInterface {

    private ArrayList<Double> data = new ArrayList<>();
    @Override
    public void addDoubleToData(Double valueToAdd)
    {
        data.add(valueToAdd);
    }

    @Override
    public void clearData()
    {
        data.clear();
    }
	
    @Override
    public int numberOfDataItems(){
        int nrOfItems = 0;
        nrOfItems = data.size();
        return nrOfItems;
    }

    @Override
    public Double sum(){
        double nrOfItems = 0.0;
        if (checkArrayList() == true)
        {
            for (double value : data)
            {
                nrOfItems += value;
            }
        }
        return nrOfItems;
    }

    @Override
    public Double highestValue() throws NoDataItemsException {
        double nrOfItems = 0.0;
        if (checkArrayList() == true)
        {
            for (double value : data)
            {
                nrOfItems = Math.max(value, nrOfItems);
            }
        }
        return nrOfItems;
    }

    @Override
    public Double getMean() throws NoDataItemsException {
        double nrOfItems = 0.0;
        double result = 0.0;
        if (checkArrayList() == true)
        {
            for (double value : data)
            {
                nrOfItems = sum();
                result = nrOfItems / numberOfDataItems();
            }
        }
        return result;
    }

    @Override
    public double getMedian() throws NoDataItemsException {
        double nrOfItems = 0.0;
        if (checkArrayList() == true)
        {
            Collections.sort(data);
            double result = numberOfDataItems() % 2;
            int median = numberOfDataItems() / 2;
            if (result == 0)
            {
                nrOfItems = (data.get(median - 1) + data.get(median)) / 2;
            }else
                {
                    nrOfItems = data.get(median);
                }
        }
        return nrOfItems;
    }

    @Override
    public double getStandardDeviation() throws NoDataItemsException {
        double nrOfItems = 0.0;
        double mean = getMean();
        ArrayList<Double> result = new ArrayList<>();
        for (double value : data)
        {
            result.add(Math.pow((value - mean),2));
        }
        for (double value2 : result)
        {
            nrOfItems += value2;
        }
        nrOfItems = nrOfItems / numberOfDataItems();
        nrOfItems = Math.sqrt(nrOfItems);
        return nrOfItems;
    }

    //Method that checks if the array is populated or not
    public boolean checkArrayList(){

        if (data.size() != 0)
            return  true;
        else
            return false;
    }
}

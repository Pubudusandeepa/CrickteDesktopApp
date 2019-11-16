package operation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AdditionOperationTest {
    @Test
    public void addPositivetoPostive(){
        List list = new ArrayList<Double>();
        list.add(10.0);
        list.add(30.0);

        AdditionOperation add = new AdditionOperation(list);
        double total =  add.perform();
        assertThat(total, is(40.0));


    }

    @Test
    public void addPositivetoZero(){
        List list = new ArrayList<Double>();
        list.add(10.0);
        list.add(0.0);

        AdditionOperation add = new AdditionOperation(list);
        double total =  add.perform();
        assertThat(total, is(10.0));


    }
    @Test
    public void addZerotoZero(){
        List list = new ArrayList<Double>();
        list.add(0.0);
        list.add(0.0);

        AdditionOperation add = new AdditionOperation(list);
        double total =  add.perform();
        assertThat(total, is(0.0));


    }



}
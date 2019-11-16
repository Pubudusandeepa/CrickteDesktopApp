package operation;

import java.util.List;

public class AdditionOperation implements Operation {

    private List<Double> inputNumbers;
    public AdditionOperation(List<Double> inputNumbers) {
        this.inputNumbers=inputNumbers;
    }

    @Override
    public double perform() {
        if (inputNumbers==null){
            return 0;
        }
        double total=0;
        for (double d:inputNumbers){
            total+=d;
        }
        return total;
    }
}

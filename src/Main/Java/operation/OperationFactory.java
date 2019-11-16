package operation;

import java.util.List;

public class OperationFactory {


    public Operation getOperation(String operator, List<Double> inputNumbers){
        Operation operation=null;

        if ("add".equals(operator)){
            operation=new AdditionOperation(inputNumbers);
        }

        return operation;
    }
}

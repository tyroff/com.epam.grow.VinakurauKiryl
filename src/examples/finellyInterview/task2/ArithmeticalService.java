package examples.finellyInterview.task2;

public class ArithmeticalService {
    public Integer performOperation(String operation, Integer leftOperand, Integer rightOperand) {
        Integer result = null;
        switch (operation) {
            case "summa":
                result = leftOperand + rightOperand;
                break;
            case "multiply":
                result = leftOperand * rightOperand;
                break;
            case "divisions":
                result = leftOperand / rightOperand;
                break;
            case "subtraction":
                result = leftOperand - rightOperand;
                break;
        }
        return result;
    }
}

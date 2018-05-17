public class Main {
    public static void main(String[] args) {
        SharedResource dictionary = new SharedResource();
        ComputeDataThread computer  = new ComputeDataThread(dictionary, "Compute");
        EvaluateDataThread evaluater  = new EvaluateDataThread(dictionary, "Evaluate");
        InsertDataThread inserter = new InsertDataThread(dictionary ,"Insert");
        UpdateDataThread updater = new UpdateDataThread(dictionary ,"Update");
        computer.start();
        evaluater.start();
        inserter.start();
        updater.start();
    }
}

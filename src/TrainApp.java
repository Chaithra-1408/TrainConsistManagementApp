import java.util.ArrayList;
import java.util.List;

public class TrainApp {
    public static void main(String[] args) {
        // UC1: Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // UC1: Initialize empty List using ArrayList
        List<String> trainConsist = new ArrayList<>();

        // UC1: Display summary
        System.out.println("Status: Train initialized.");
        System.out.println("Initial Bogie Count: " + trainConsist.size());
    }
}
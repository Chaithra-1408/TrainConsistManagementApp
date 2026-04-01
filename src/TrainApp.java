import java.util.ArrayList;
import java.util.List;

public class TrainApp {
    public static void main(String[] args) {
        // --- UC1: Initialization ---
        System.out.println("=== Train Consist Management App ===");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Status: Train initialized.");

        // --- UC2: Passenger Bogie Operations ---
        System.out.println("\n--- UC2: Adding Passenger Bogies ---");

        // 1. Adding bogies
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        System.out.println("Added: Sleeper, AC Chair, First Class.");

        // 2. Display the list
        System.out.println("Current Consist: " + trainConsist);
        System.out.println("Total Bogies: " + trainConsist.size());

        // 3. Removing a bogie
        System.out.println("\nDetaching 'AC Chair' for maintenance...");
        trainConsist.remove("AC Chair");
        System.out.println("Updated Consist: " + trainConsist);

        // 4. Checking existence
        System.out.print("Checking for 'Sleeper' bogie: ");
        if (trainConsist.contains("Sleeper")) {
            System.out.println("Found! Sleeper is attached.");
        } else {
            System.out.println("Not Found!");
        }

        System.out.println("\nFinal Bogie Count: " + trainConsist.size());
        System.out.println("====================================");
    }
}
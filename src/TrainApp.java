import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrainApp {
    public static void main(String[] args) {
        // --- UC1 & UC2: Existing List Logic ---
        System.out.println("=== Train Consist Management App ===");
        List<String> trainConsist = new ArrayList<>();
        trainConsist.add("Sleeper");
        trainConsist.add("First Class");

        // --- UC3: Unique Bogie ID Tracking (HashSet) ---
        System.out.println("\n--- UC3: Tracking Unique Bogie IDs ---");

        // 1. Initialize a HashSet for unique IDs
        Set<String> bogieIds = new HashSet<>();

        // 2. Add Bogie IDs (including intentional duplicates)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");

        System.out.println("Attempting to add duplicate ID: BG101...");
        boolean isAdded = bogieIds.add("BG101"); // This will return false

        if (!isAdded) {
            System.out.println("System Alert: Duplicate Bogie ID 'BG101' rejected!");
        }

        // 3. Print the final set
        System.out.println("\nRegistered Unique Bogie IDs: " + bogieIds);

        // 4. Verify count
        System.out.println("Total Unique Bogies Registered: " + bogieIds.size());
        System.out.println("====================================");
    }
}
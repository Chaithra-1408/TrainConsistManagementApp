import java.util.LinkedHashSet;
import java.util.Set;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // --- UC5: Preservation of Order with Uniqueness (LinkedHashSet) ---
        System.out.println("\n--- UC5: Preserving Insertion Order with Uniqueness ---");

        // 1. Create a LinkedHashSet for the train formation
        Set<String> trainFormation = new LinkedHashSet<>();

        // 2. Attach bogies: Engine, Sleeper, Cargo, Guard
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        System.out.println("Initial Formation: " + trainFormation);

        // 3. Attempt to attach a duplicate bogie intentionally
        System.out.println("\nAttempting to re-attach 'Sleeper'...");
        boolean isAdded = trainFormation.add("Sleeper");

        if (!isAdded) {
            System.out.println("Alert: 'Sleeper' is already part of the train. Duplicate rejected.");
        }

        // 4. Display the final formation order
        System.out.println("\nFinal Formation (Order Preserved): " + trainFormation);

        // 5. Verify the count
        System.out.println("Total Unique Bogies in Order: " + trainFormation.size());
        System.out.println("====================================");
    }
}
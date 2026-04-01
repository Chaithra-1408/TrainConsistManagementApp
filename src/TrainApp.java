import java.util.HashMap;
import java.util.Map;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // --- UC6: Bogie to Capacity Mapping (HashMap) ---
        System.out.println("\n--- UC6: Maintaining Bogie Capacities ---");

        // 1. Create a HashMap to store Bogie Name -> Capacity
        Map<String, Integer> bogieCapacities = new HashMap<>();

        // 2. Use put() to map each bogie to its capacity
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair", 56);
        bogieCapacities.put("First Class", 24);
        bogieCapacities.put("General", 90);

        System.out.println("Capacity data successfully mapped.");

        // 3. Fast Lookup Example
        String searchBogie = "AC Chair";
        System.out.println("\nSearching capacity for: " + searchBogie);
        System.out.println("Result: " + bogieCapacities.get(searchBogie) + " seats available.");

        // 4. Iterate over the map using entrySet() to display all details
        System.out.println("\n--- Full Bogie Capacity List ---");
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey() + " | Capacity: " + entry.getValue() + " seats");
        }

        System.out.println("====================================");
    }
}
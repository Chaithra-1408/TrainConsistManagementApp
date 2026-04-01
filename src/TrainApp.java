import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("\n--- UC8: Filtering Bogies using Streams ---");

        // 1. Create a List of bogies (Reuse logic from UC7)
        List<Bogie> allBogies = new ArrayList<>();
        allBogies.add(new Bogie("Sleeper", 72));
        allBogies.add(new Bogie("AC Chair", 56));
        allBogies.add(new Bogie("First Class", 24));
        allBogies.add(new Bogie("General", 90));

        System.out.println("All Available Bogies: " + allBogies);

        // 2. Apply Stream Filtering
        // Goal: Select bogies with capacity > 60
        int threshold = 60;
        List<Bogie> highCapacityBogies = allBogies.stream()
                .filter(b -> b.capacity > threshold) // Lambda expression for condition
                .collect(Collectors.toList());      // Collect results into a new list

        // 3. Display Filtered Results
        System.out.println("\n--- High Capacity Bogies ( > " + threshold + " seats) ---");
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            highCapacityBogies.forEach(b -> System.out.println(">> " + b));
        }

        // 4. Verify Original List Integrity (Requirement)
        System.out.println("\nVerification: Original list size remains " + allBogies.size());
        System.out.println("====================================");
    }
}
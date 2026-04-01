import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Key Requirement: Create a Bogie class with name and capacity
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
        System.out.println("\n--- UC7: Sorting Bogies by Capacity ---");

        // 1. Create a List<Bogie> to store passenger bogies
        List<Bogie> passengerBogies = new ArrayList<>();

        // 2. Add bogie objects
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting: " + passengerBogies);

        // 3. Use Comparator to sort by capacity (Low to High)
        // Key Concept: Comparator.comparingInt()
        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));

        // 4. Display the sorted bogies
        System.out.println("\nAfter Sorting (Capacity: Low to High):");
        for (Bogie b : passengerBogies) {
            System.out.println(">> " + b);
        }

        // Optional: Sort High to Low
        passengerBogies.sort((b1, b2) -> b2.capacity - b1.capacity);
        System.out.println("\nAfter Sorting (Capacity: High to Low):");
        passengerBogies.forEach(b -> System.out.println(">> " + b));

        System.out.println("====================================");
    }
}
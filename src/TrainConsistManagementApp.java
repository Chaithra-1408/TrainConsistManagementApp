import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        System.out.println("\n--- UC8: Filtering Bogies using Streams ---");

        List<Bogie> allBogies = new ArrayList<>();
        allBogies.add(new Bogie("Sleeper", 72));
        allBogies.add(new Bogie("AC Chair", 56));
        allBogies.add(new Bogie("First Class", 24));
        allBogies.add(new Bogie("General", 90));
        allBogies.add(new Bogie("AC Sleeper", 48));
        allBogies.add(new Bogie("Express General", 85));

        System.out.println("All Available Bogies: " + allBogies);

        int threshold = 60;
        List<Bogie> highCapacityBogies = allBogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        System.out.println("\n--- High Capacity Bogies ( > "
                + threshold + " seats) ---");
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            highCapacityBogies.forEach(
                    b -> System.out.println(">> " + b));
        }

        System.out.println("\nVerification: Original list size remains "
                + allBogies.size());
        System.out.println("====================================");

        System.out.println("\n--- UC9: Grouping Bogies using Streams ---");

        Map<String, List<Bogie>> groupedBogies = allBogies.stream()
                .collect(Collectors.groupingBy(b -> {
                    if (b.capacity >= 70) {
                        return "High Capacity";
                    } else if (b.capacity >= 50) {
                        return "Medium Capacity";
                    } else {
                        return "Low Capacity";
                    }
                }));

        System.out.println("\n--- Grouped Bogie Structure ---");
        for (Map.Entry<String, List<Bogie>> entry
                : groupedBogies.entrySet()) {
            System.out.println("\nCategory : " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("  >> " + b);
            }
        }

        System.out.println("\nVerification: Original list size remains "
                + allBogies.size());
        System.out.println("====================================");
    }
}
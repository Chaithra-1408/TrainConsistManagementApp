import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
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

class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
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

        System.out.println("\n--- UC10: Count Total Seats in Train ---");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity of Train: "
                + totalSeats);
        System.out.println("\nUC10 aggregation completed...");
        System.out.println("====================================");

        System.out.println("\n============================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code");
        System.out.println("============================================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        Pattern trainIdPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}");

        Matcher trainIdMatcher = trainIdPattern.matcher(trainId);
        Matcher cargoCodeMatcher = cargoCodePattern.matcher(cargoCode);

        boolean isTrainIdValid = trainIdMatcher.matches();
        boolean isCargoCodeValid = cargoCodeMatcher.matches();

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainIdValid);
        System.out.println("Cargo Code Valid: " + isCargoCodeValid);

        System.out.println("\nUC11 validation completed...");
        System.out.println("====================================");

        System.out.println("\n============================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("============================================\n");

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie gb : goodsBogies) {
            System.out.println(gb.type + " -> " + gb.cargo);
        }

        boolean isSafetyCompliant = goodsBogies.stream()
                .allMatch(gb -> {
                    if (gb.type.equals("Cylindrical")) {
                        return gb.cargo.equals("Petroleum");
                    }
                    return true;
                });

        System.out.println("\nSafety Compliance Status: "
                + isSafetyCompliant);

        if (isSafetyCompliant) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
        System.out.println("====================================");

        System.out.println("\n============================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("============================================\n");

        List<Bogie> testBogies = new ArrayList<>();
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("First Class", 24));
        testBogies.add(new Bogie("General", 90));
        testBogies.add(new Bogie("AC Sleeper", 48));
        testBogies.add(new Bogie("Express General", 85));

        int filterThreshold = 60;

        long loopStart = System.nanoTime();
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : testBogies) {
            if (b.capacity > filterThreshold) {
                loopResult.add(b);
            }
        }
        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        long streamStart = System.nanoTime();
        List<Bogie> streamResult = testBogies.stream()
                .filter(b -> b.capacity > filterThreshold)
                .collect(Collectors.toList());
        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        System.out.println("\nUC13 performance benchmarking completed...");
        System.out.println("====================================");

        scanner.close();
    }
}
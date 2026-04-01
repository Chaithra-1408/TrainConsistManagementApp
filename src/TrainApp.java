import java.util.LinkedList;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // --- UC4: Ordered Train Consist (LinkedList) ---
        System.out.println("\n--- UC4: Maintaining Physical Bogie Sequence ---");

        // 1. Create a LinkedList for the consist
        LinkedList<String> trainSequence = new LinkedList<>();

        // 2. Add bogies: Engine, Sleeper, AC, Cargo, Guard
        trainSequence.add("Engine");
        trainSequence.add("Sleeper");
        trainSequence.add("AC Chair");
        trainSequence.add("Cargo");
        trainSequence.add("Guard Coach");

        System.out.println("Initial Sequence: " + trainSequence);

        // 3. Insert a Pantry Car at position 2 (Index 2)
        System.out.println("\nInserting 'Pantry Car' at position 2...");
        trainSequence.add(2, "Pantry Car");
        System.out.println("Updated Sequence: " + trainSequence);

        // 4. Remove the first and last bogie
        System.out.println("\nDetaching Engine (First) and Guard Coach (Last)...");
        trainSequence.removeFirst();
        trainSequence.removeLast();

        // 5. Display the final ordered train consist
        System.out.println("Final Consist: " + trainSequence);
        System.out.println("Current Coach Count: " + trainSequence.size());
        System.out.println("====================================");
    }
}
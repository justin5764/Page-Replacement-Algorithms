import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the reference string separated by spaces (e.g., '3 2 1 0 3 2 4 3 2 1 0 4'): ");
        String referenceString = sc.nextLine();
        System.out.println("Enter the frame size: ");
        int frameSize = sc.nextInt();
        sc.close();

        Algorithms algorithms = new Algorithms(referenceString, frameSize);

        System.out.println("----------------------------------------------------");
        System.out.println("Reference String: " + referenceString);
        System.out.println("----------------------------------------------------");
        System.out.println("Frame Size: " + frameSize);
        System.out.println("----------------------------------------------------");
        algorithms.FIFO();
        System.out.println();
        algorithms.LRU();
        System.out.println();
        algorithms.MRU();
    }
}
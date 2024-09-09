import java.util.Scanner;

import Algorithms.FIFO;
import Algorithms.LRU;
import Algorithms.MRU;
import Algorithms.OPT;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the reference string separated by spaces (e.g., '3 2 1 0 3 2 4 3 2 1 0 4'): ");
        String referenceString = sc.nextLine();
        System.out.println("Enter the frame size: ");
        int frameSize = sc.nextInt();
        sc.close();

        FIFO algorithm1 = new FIFO(referenceString, frameSize);
        OPT algorithm2 = new OPT(referenceString, frameSize);
        LRU algorithm3 = new LRU(referenceString, frameSize);
        MRU algorithm4 = new MRU(referenceString, frameSize);
        
        System.out.println("----------------------------------------------------");
        System.out.println("Reference String: " + referenceString);
        System.out.println("----------------------------------------------------");
        System.out.println("Frame Size: " + frameSize);
        System.out.println("----------------------------------------------------");
        algorithm1.run();
        System.out.println();
        algorithm2.run();
        System.out.println();
        algorithm3.run();
        System.out.println();
        algorithm4.run();
        
    }
}
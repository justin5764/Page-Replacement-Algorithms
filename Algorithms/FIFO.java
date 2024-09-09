package Algorithms;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FIFO extends Algorithms {
    public FIFO(String referenceString, int frameSize) {
        super(referenceString, frameSize);
    }

    public void run() {
        Queue<Integer> pageOrder = new LinkedList<>();
        ArrayList<Integer> memory = new ArrayList<Integer>();
        int pageFaults = 0, pageHits = 0;
        int[] referencePages = getReferencePages();
        int frameSize = getFrameSize();

        System.out.println("First In First Out (FIFO)");
        
        for (int i = 0; i < referencePages.length; i++) {
            if (memory.size() < frameSize) {  
                if (!pageOrder.contains(referencePages[i])) {
                    pageOrder.add(referencePages[i]);
                    pageFaults++;
                    memory.add(referencePages[i]);
                }
            } else if (!pageOrder.contains(referencePages[i])) {
                int firstPage = pageOrder.peek();
                pageOrder.poll();
                pageOrder.add(referencePages[i]);
                memory.set(memory.indexOf(firstPage), referencePages[i]);
                pageFaults++;
            } else {
                pageHits++;
            }
            System.out.println(memory);
        }

        System.out.println("Page Hits: " + pageHits);
        System.out.println("Page Faults: " + pageFaults);
    }
}

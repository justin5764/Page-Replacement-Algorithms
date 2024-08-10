import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Algorithms {
    int[] referencePages;
    int frameSize;

    public Algorithms(String referenceString, int frameSize) {
        this.frameSize = frameSize;
        referencePages = Arrays.stream(referenceString.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public void FIFO() {
        Set<Integer> currentPages = new LinkedHashSet<>();
        Queue<Integer> pageOrder = new LinkedList<>();
        int pageFaults = 0, pageHits = 0;

        System.out.println("First In First Out (FIFO)");
        
        for (int i = 0; i < referencePages.length; i++) {
            if (currentPages.size() < frameSize) {  
                if (!currentPages.contains(referencePages[i])) {
                    currentPages.add(referencePages[i]);
                    pageFaults++;
                    pageOrder.add(referencePages[i]);
                }
            } else if (!currentPages.contains(referencePages[i])) {
                int firstPage = pageOrder.peek();
                pageOrder.poll();
                currentPages.remove(firstPage)  ;
                currentPages.add(referencePages[i]);
                pageOrder.add(referencePages[i]);
                pageFaults++;
            } else {
                pageHits++;
            }
            System.out.println(currentPages);
        }
        System.out.println("Page Hits: " + pageHits);
        System.out.println("Page Faults: " + pageFaults);
    }

    public void OPT() {
        Queue<Integer> currentPages = new LinkedList<>();
        int pageFaults = 0, pageHits = 0;
        
    }

    public void LRU() {
        Queue<Integer> currentPages = new LinkedList<>();
        int pageFaults = 0, pageHits = 0;
        
    }

    public void MRU() {
        Queue<Integer> currentPages = new LinkedList<>();
        int pageFaults = 0, pageHits = 0;
        
    }
}

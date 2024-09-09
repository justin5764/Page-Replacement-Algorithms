package Algorithms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class LRU extends Algorithms {
    public LRU(String referenceString, int frameSize) {
        super(referenceString, frameSize);
    }

    public void run() {
        Set<Integer> currentPages = new LinkedHashSet();
        ArrayList<Integer> memory = new ArrayList<Integer>();
        int pageFaults = 0, pageHits = 0;
        int[] referencePages = getReferencePages();
        int frameSize = getFrameSize();

        System.out.println("Least Recently Used (LRU)");

        for (int i = 0; i < referencePages.length; i++) {
            if (currentPages.size() < frameSize) {  
                if (!currentPages.contains(referencePages[i])) {
                    currentPages.add(referencePages[i]);
                    pageFaults++;
                    memory.add(referencePages[i]);
                }
            } else if (!currentPages.contains(referencePages[i])) {
                int leastRecentlyUsedPage = currentPages.iterator().next();
                currentPages.remove(leastRecentlyUsedPage)  ;
                currentPages.add(referencePages[i]);
                memory.set(memory.indexOf(leastRecentlyUsedPage), referencePages[i]);
                pageFaults++;
            } else {
                currentPages.remove(referencePages[i]);
                currentPages.add(referencePages[i]);
                pageHits++;
            }
            System.out.println(memory);
        }

        System.out.println("Page Hits: " + pageHits);
        System.out.println("Page Faults: " + pageFaults);
    }
}
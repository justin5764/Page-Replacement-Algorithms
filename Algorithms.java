import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class Algorithms {
    int[] referencePages;
    int frameSize;

    public Algorithms(String referenceString, int frameSize) {
        this.frameSize = frameSize;
        referencePages = Arrays.stream(referenceString.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public void FIFO() {
        Queue<Integer> pageOrder = new LinkedList<>();
        ArrayList<Integer> memory = new ArrayList<Integer>();
        int pageFaults = 0, pageHits = 0;

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

    public void OPT() {
        Set<Integer> currentPages = new LinkedHashSet<>();
        int pageFaults = 0, pageHits = 0;

        System.out.println("Optimal (OPT)");

        for (int i = 0; i < referencePages.length; i++) {
            if (currentPages.size() < frameSize) {
                if (!currentPages.contains(referencePages[i])) {
                    currentPages.add(referencePages[i]);
                    pageFaults++;
                }
            } else if (!currentPages.contains(referencePages[i])) {
                int farthestPageIndex = -1;
                int farthestPage = -1;

                for (int page : currentPages) {
                    int nextPageIndex = getNextPageIndex(i, page);
                    if (nextPageIndex == -1) {
                        farthestPageIndex = i;
                        farthestPage = page;
                        break;
                    } else if (nextPageIndex > farthestPageIndex) {
                        farthestPageIndex = nextPageIndex;
                        farthestPage = page;
                    }
                }

                currentPages.remove(farthestPage);
                currentPages.add(referencePages[i]);
                pageFaults++;
            } else {
                pageHits++;
            }
            System.out.println(currentPages);
        }

        System.out.println("Page Hits: " + pageHits);
        System.out.println("Page Faults: " + pageFaults);
    }

    public void LRU() {
        Set<Integer> currentPages = new LinkedHashSet();
        ArrayList<Integer> memory = new ArrayList<Integer>();
        int pageFaults = 0, pageHits = 0;

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

    public void MRU() {
        Set<Integer> currentPages = new LinkedHashSet();
        ArrayList<Integer> memory = new ArrayList<Integer>();
        int pageFaults = 0, pageHits = 0;

        System.out.println("Most Recently Used (MRU)");

        for (int i = 0; i < referencePages.length; i++) {
            if (currentPages.size() < frameSize) {  
                if (!currentPages.contains(referencePages[i])) {
                    currentPages.add(referencePages[i]);
                    pageFaults++;
                    memory.add(referencePages[i]);
                }
            } else if (!currentPages.contains(referencePages[i])) {
                int mostRecentlyUsedPage = 0;
                for (int page : currentPages) mostRecentlyUsedPage = page;
                currentPages.remove(mostRecentlyUsedPage)  ;
                currentPages.add(referencePages[i]);
                memory.set(memory.indexOf(mostRecentlyUsedPage), referencePages[i]);
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

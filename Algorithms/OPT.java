package Algorithms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;


public class OPT extends Algorithms {
    public OPT(String referenceString, int frameSize) {
        super(referenceString, frameSize);
    }

    private boolean search(int key, ArrayList<Integer> memory) {
        return memory.contains(key);
    }

    private int predict(int[] referencePages, ArrayList<Integer> memory, int index) {
        int res = -1;
        int farthest = index;
        for (int i = 0; i < memory.size(); i++) {
            int j;
            for (j = index; j < referencePages.length; j++) {
                if (memory.get(i) == referencePages[j]) {
                    if (j > farthest) {
                        farthest = j;
                        res = i;
                    }
                    break;
                }
            }

            if (j == referencePages.length) {
                return i;
            }
        }

        return (res == -1) ? 0 : res;
    }

    public void run() {
        ArrayList<Integer> memory = new ArrayList<Integer>();
        int pageFaults = 0, pageHits = 0;
        int[] referencePages = getReferencePages();
        int frameSize = getFrameSize();

        System.out.println("Optimal (OPT)");

        for (int i = 0; i < referencePages.length; i++) {
            if (memory.size() < frameSize) {
                if (!search(referencePages[i], memory)) {
                    memory.add(referencePages[i]);
                    pageFaults++;
                }
            } else if (!search(referencePages[i], memory)) {
                int j = predict(referencePages, memory, i + 1);
                memory.set(j, referencePages[i]);
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

package Algorithms;
import java.util.Arrays;

public class Algorithms {
    private int[] referencePages;
    private int frameSize;

    public Algorithms(String referenceString, int frameSize) {
        this.frameSize = frameSize;
        referencePages = Arrays.stream(referenceString.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public int[] getReferencePages() {
        return referencePages;
    }

    public int getFrameSize() {
        return frameSize;
    }
}

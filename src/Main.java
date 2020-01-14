import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] instructions = {3, 4, 4, 6, 1, 4, 4};
        System.out.println("Instructions : " + Arrays.toString(instructions));

        int counterRange = 5;

        int[] counters = solution(counterRange, instructions);
        System.out.println("Result  : " + Arrays.toString(counters));
    }

    public static int[] solution(int counterRange, int[] instructions) {
        int[] counters = new int[counterRange];
        Arrays.fill(counters, 0);

        int maxCounter = 0;
        int startLine = 0;

        for (int instruction : instructions) {
            if (instruction <= counterRange) {

                if (counters[instruction - 1] > startLine) {
                    counters[instruction - 1] += 1;
                } else {
                    counters[instruction - 1] = startLine + 1;
                }

                if (maxCounter < counters[instruction - 1]) {
                    maxCounter = counters[instruction - 1];
                }

            } else {
                startLine = maxCounter;
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < startLine) {
                counters[i] = startLine;
            }
        }

        return counters;
    }
}

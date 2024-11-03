import java.util.ArrayList;
import java.util.List;
/** @URL: https://leetcode.com/problems/pascals-triangle/ */
class PascalsTrianglePrint {
    public static void main(String[] args) {
        final int numRows = 6;
        var pascalsTriangle = generate(numRows);
        pascalsTriangle.forEach(entry -> {
            entry.forEach(value -> System.out.print(value + " "));
            System.out.println();
        });
    }

    public static List<List<Integer>> generate(int numRows) {
        final var pascalsTriange = new ArrayList<List<Integer>>(numRows);
        int capacity = 0;
        while (++capacity <= numRows) {
            var entry = new ArrayList<Integer>(capacity);
            entry.add(1);
            if (capacity > 2) {
                var rowBefore = pascalsTriange.get(capacity - 2);
                for (int i = 1; i < capacity - 1; i++) {
                    entry.add(rowBefore.get(i - 1) + rowBefore.get(i));
                }
            }
            if (capacity > 1) {
                entry.add(1);
            }
            pascalsTriange.add(entry);
        }
        return pascalsTriange;
    }
}
package greedy_algos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
//        task1();
        List<Segment> segments = List.of(new Segment(0, 5), new Segment(3, 6), new Segment(5, 9), new Segment(8, 10), new Segment(6, 8));
        Segment mainSegment = new Segment(0, 10);
        boolean task2Res = task2(segments, mainSegment);
        System.out.println(task2Res);
    }

    private static void task1() {
        List<List<Integer>> a = new ArrayList<>();
        List<Integer> pair1 = new ArrayList<>();
        pair1.add(1);
        pair1.add(4);
        List<Integer> pair2 = new ArrayList<>();
        pair2.add(3);
        pair2.add(5);
        List<Integer> pair3 = new ArrayList<>();
        pair3.add(0);
        pair3.add(6);
        List<Integer> pair4 = new ArrayList<>();
        pair4.add(5);
        pair4.add(7);
        List<Integer> pair5 = new ArrayList<>();
        pair5.add(8);
        pair5.add(9);
        List<Integer> pair6 = new ArrayList<>();
        pair6.add(5);
        pair6.add(9);
        
        a.add(pair3);
        a.add(pair1);
        a.add(pair2);
        a.add(pair6);
        a.add(pair4);
        a.add(pair5);

        a.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                int e1 = l1.get(1);
                int e2 = l2.get(1);
                if (e1 < e2)
                    return -1;
                else if (e1 > e2)
                    return 1;
                else
                    return 0;
            }
        });
        System.out.println(a);
        List<List<Integer>> b = new ArrayList<>();
        b.add(a.get(0));
        List<Integer> prev = b.get(b.size() - 1);
        for (int i = 1; i < a.size(); i++) {
            List<Integer> e = a.get(i);
            if (e.get(0) > prev.get(1)) {
                b.add(e);
                prev = e;
            }
        }
        System.out.println(b);
    }

    private static boolean task2(List<Segment> segments, Segment mainSegment) {
        var sortedSegments = segments.stream()
                .sorted()
                .collect(Collectors.toList());

        int next = 0;
        Segment lastSegment = sortedSegments.get(next++);
        mainSegment.coverage(lastSegment);


        while (!mainSegment.isFilled() && next < segments.size()) {
            Segment nextSegment = sortedSegments.get(next++);
            if (lastSegment.coverageNew(nextSegment)) {
                mainSegment.coverage(nextSegment);
            }
            lastSegment = nextSegment;
        }

        return mainSegment.isFilled();
    }

    public static class Segment implements Comparable<Segment> {
        int start;
        int end;
        List<Boolean> points = new ArrayList<>();

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
            for (int i = start; i <= end; i++) {
                points.add(false);
            }
        }

        public int length() {
            return end - start;
        }

        public boolean coverageNew(Segment other) {
            return start > other.start || end < other.end;
        }

        public void coverage(Segment segment) {
            for (int i = segment.start; i <= segment.end; i++) {
                points.set(i, true);
            }
        }

        public boolean isFilled() {
            return points.stream().allMatch(e -> e == true);
        }

        // сравнивается наоборот для сортировки по убыванию
        @Override
        public int compareTo(Segment other) {
            int len1 = length();
            int len2 = other.length();

            if (len1 > len2)
                return - 1;
            else if (len1 < len2)
                return 1;
            else
                return 0;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

}

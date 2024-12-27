import java.util.*;

public class Main {
    public static String display(List<Interval> l1) {
        if (l1.size() == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < l1.size(); i++) {
            sb.append("[").append(l1.get(i).start).append(", ")
                    .append(l1.get(i).end).append("]");
            if (i < l1.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        {
            List<List<List<Interval>>> inputs1 = Arrays.asList(
                    Arrays.asList(
                            Arrays.asList(new Interval(1, 5)),
                            Arrays.asList(new Interval(6, 10)),
                            Arrays.asList(new Interval(4, 7))),
                    Arrays.asList(
                            Arrays.asList(new Interval(1, 3), new Interval(6, 7)),
                            Arrays.asList(new Interval(2, 4)),
                            Arrays.asList(new Interval(2, 5), new Interval(9, 12))),
                    Arrays.asList(
                            Arrays.asList(new Interval(2, 3), new Interval(7, 9)),
                            Arrays.asList(new Interval(1, 4), new Interval(6, 7))),
                    Arrays.asList(
                            Arrays.asList(new Interval(3, 5), new Interval(8, 10)),
                            Arrays.asList(new Interval(4, 6), new Interval(9, 12)),
                            Arrays.asList(new Interval(5, 6), new Interval(8, 10))),
                    Arrays.asList(
                            Arrays.asList(new Interval(1, 3), new Interval(6, 9), new Interval(10, 11)),
                            Arrays.asList(new Interval(3, 4), new Interval(7, 12)),
                            Arrays.asList(new Interval(1, 3), new Interval(7, 10)),
                            Arrays.asList(new Interval(1, 4)),
                            Arrays.asList(new Interval(7, 10), new Interval(11, 12))),
                    Arrays.asList(
                            Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6),
                                    new Interval(7, 8)),
                            Arrays.asList(new Interval(2, 3), new Interval(4, 5), new Interval(6, 8))),
                    Arrays.asList(
                            Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6),
                                    new Interval(7, 8), new Interval(9, 10), new Interval(11, 12)),
                            Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6),
                                    new Interval(7, 8), new Interval(9, 10), new Interval(11, 12)),
                            Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6),
                                    new Interval(7, 8), new Interval(9, 10), new Interval(11, 12)),
                            Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6),
                                    new Interval(7, 8), new Interval(9, 10), new Interval(11, 12))));

            int i = 1;
            List<List<List<Interval>>> inputs = new ArrayList<>();

            for (int j = 0; j < inputs1.size(); j++) {
                inputs.add(new ArrayList<List<Interval>>());

                for (int k = 0; k < inputs1.get(j).size(); k++) {
                    inputs.get(j).add(new ArrayList<Interval>());

                    for (int g = 0; g < inputs1.get(j).get(k).size(); g++) {
                        inputs.get(j).get(k).add(inputs1.get(j).get(k).get(g));
                    }
                }
            }

            for (int j = 0; j < inputs.size(); j++) {
                System.out.println(i + ".\tEmployee Schedules:\n");

                for (int s = 0; s < inputs.get(j).size(); s++) {
                    System.out.println("\t\t" + display(inputs.get(j).get(s)));
                }

                System.out.println("\n\tEmployees' free time " + display(Solution.employeeFreeTime(inputs.get(j))));
                System.out.println(new String(new char[100]).replace('\0', '-'));
                i += 1;
            }
        }
    }
}

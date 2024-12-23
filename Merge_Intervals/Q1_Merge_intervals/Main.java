import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int[][][] allIntervals = {
                { { 1, 5 }, { 3, 7 }, { 4, 6 } },
                { { 1, 5 }, { 4, 6 }, { 6, 8 }, { 11, 15 } },
                { { 3, 7 }, { 6, 8 }, { 10, 12 }, { 11, 15 } },
                { { 1, 5 } },
                { { 1, 9 }, { 3, 8 }, { 4, 4 } },
                { { 1, 2 }, { 3, 4 }, { 8, 8 } },
                { { 1, 5 }, { 1, 3 } },
                { { 1, 5 }, { 6, 9 } },
                { { 0, 0 }, { 1, 18 }, { 1, 3 } }
        };

        int index = 1;
        for (int[][] intervals : allIntervals) {
            System.out.println(index + ".\tIntervals to merge: " + Arrays.deepToString(intervals));
            int[][] result = mergeIntervals(intervals);
            System.out.println("\tMerged intervals: " + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            index++;
        }
    }

    private static int[][] mergeIntervals(int[][] intervals) {
        //创建一个linked list，之后我们可以用to array方法将其转换为int[][]类型
        LinkedList<int[]> merged = new LinkedList<>();

        //如果intervals为空，直接返回空数组
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        //将intervals按照第一个元素的大小进行排序
        /*
         * 对interval进行排序，排序规则是按照interval的第一个元素进行排序
         * sort function takes a lambda expression as a parameter
         * 如果a[0] < b[0]，返回-1，表示a在b之前
         * 如果a[0] == b[0]，返回0，表示a和b相等
         * 如果a[0] > b[0]，返回1，表示a在b之后
         */
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        //将第一个interval加入到merged中
        merged.add(intervals[0]);

        //开始循环
        for(int i = 1; i < intervals.length; i++){
            int[] interval = intervals[i]; //当前interval
            int[] lastAddedInterval = merged.getLast(); //merged中的最后一个interval

            //存储当前的start和end
            int currStart = interval[0];
            int currEnd = interval[1];

            //思考：对于在merge中的这个数组，我们只需要考虑最后一个数组的end和当前数组的start的关系
            //因为前一个数字再小 比如说[1,5]，后一个数字再大 比如说[3,7]，那么这两个数字就可以合并成[1,7]

            //因此，我们只需要考虑a的end和b的start的关系是否是<=，如果是的话，我们就可以合并

            int preEnd = lastAddedInterval[1];

            if(currStart <= preEnd){
                lastAddedInterval[1] = Math.max(preEnd, currEnd);
            }else{
                merged.add(interval);
            }
        }
        
        return  merged.toArray(new int[merged.size()][]);
    }

}

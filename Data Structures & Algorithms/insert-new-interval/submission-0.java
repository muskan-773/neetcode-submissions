class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < start) {
                res.add(intervals[i]);
            } else if (intervals[i][0] <= end) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            } else {
                res.add(new int[] {start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
}
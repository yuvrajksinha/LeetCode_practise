class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        for(int[] interval:intervals){
            if(interval[0]<=current[1]){
                current[1]=Math.max(interval[1],current[1]);
            } else {
                result.add(current);
                current=interval;
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}
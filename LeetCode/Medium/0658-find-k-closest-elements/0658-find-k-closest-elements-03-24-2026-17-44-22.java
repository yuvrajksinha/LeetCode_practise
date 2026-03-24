class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->{
            int distA=Math.abs(a-x);
            int distB=Math.abs(b-x);
            if(distA==distB){
                return b-a;
            }
            return distB-distA;
        });
        for(int num:arr){
            maxHeap.add(num);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<k;i++){
            result.add(maxHeap.poll());
        }
        Collections.sort(result);
        return result;
    }
}
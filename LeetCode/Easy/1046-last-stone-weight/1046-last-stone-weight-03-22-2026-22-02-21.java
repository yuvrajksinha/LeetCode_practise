class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int stone:stones){
            maxHeap.add(stone);
        }
        while(maxHeap.size()>1){
            int firstStone=maxHeap.poll();
            int secondStone=maxHeap.poll();
            if(firstStone>secondStone){
                maxHeap.add(firstStone-secondStone);
            }
        }
        return maxHeap.isEmpty()?0:maxHeap.poll();
    }
}
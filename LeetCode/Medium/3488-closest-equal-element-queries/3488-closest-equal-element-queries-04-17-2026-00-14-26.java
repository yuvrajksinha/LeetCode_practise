class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n=nums.length;
        Map<Integer,List<Integer>> map = new HashMap<>(); //stores indexes of unique elements
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        List<Integer> answer = new ArrayList<>();
        for(int qIndex : queries){ //value of queries act as index for nums
            List<Integer> indexes = map.get(nums[qIndex]); //get the indexes for the value of qIndex in nums
            if(indexes.size()<=1){ //if size <=1 means it is only 1 present element so no other
                answer.add(-1);
                continue;
            }
            int positionOfQueryInIndexes = Collections.binarySearch(indexes,qIndex);//this gets the position of current qIndex in the indexes list as in [2,5,7] and qIndex=5 then pos = 1

            int prevIndex,nextIndex; //pointers going both sides of the indexes getting the closes indexes to qIndex as indexes are stored in a sorted way already cause we go 0 to n
            if(positionOfQueryInIndexes == indexes.size()-1){ //if the pos in indexes is at the end
                nextIndex = indexes.get(0); //the next index will be at the start so get the index at start
            } else { //otherwise just get the next index in the indexes as that will be the closest to qIndex
                nextIndex = indexes.get(positionOfQueryInIndexes+1);
            }
            if(positionOfQueryInIndexes == 0){ //if pos is at the start 
                prevIndex = indexes.get(indexes.size()-1);//the prev index is at the end as circle
            } else {//otherwise we just take the prev closes index
                prevIndex = indexes.get(positionOfQueryInIndexes-1);
            }

            int distToPrev = (qIndex-prevIndex+n)%n; //calculate both side difference
            int distToNext = (nextIndex-qIndex+n)%n;

            answer.add(Math.min(distToPrev,distToNext)); //add the min of the two
        }
        return answer;
    }
}
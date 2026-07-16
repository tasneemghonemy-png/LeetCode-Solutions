
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        List<Integer> lengthsOfConsecutive = new ArrayList<>();
        int counter = 1;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]) continue;
            if(nums[i] == nums[i + 1] - 1){
                counter++;
            }
            else{
                lengthsOfConsecutive.add(counter);
                counter = 1;
            }
        }
        lengthsOfConsecutive.add(counter);
        int maxLength = lengthsOfConsecutive.getFirst();
        for(int i = 0; i < lengthsOfConsecutive.size(); i++){
            maxLength = Math.max(maxLength,lengthsOfConsecutive.get(i));
        }
        return maxLength;
    }
} 
/*class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        
        Set<Integer>hS = new HashSet<>();
        for(int num: nums){
            hS.add(num);
        }
        
        int maxLength = 1;
        for(int num: hS){
            int currentNum = num;
            int currLength = 1;
            if(!hS.contains(num - 1)){
                while (hS.contains(currentNum + 1)){
                    currLength++;
                    currentNum++;
                }
                maxLength = Math.max(maxLength,currLength);
            }
        }
        return maxLength;
    }
}*/

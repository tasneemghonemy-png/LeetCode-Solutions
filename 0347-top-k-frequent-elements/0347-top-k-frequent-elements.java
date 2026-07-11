class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[]res= new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int f = 0;
        for(int i = 0; i < k; i++){
            int maxfreq = Integer.MIN_VALUE;
            int indexOfMaxFreq = Integer.MIN_VALUE;
           for(int  j = 0; j < nums.length;j++){
               if(map.get(nums[j]) != null) {
                   if(maxfreq < map.get(nums[j])){
                       maxfreq = map.get(nums[j]);
                       indexOfMaxFreq = j;
                   }

               }
           }
           map.remove(nums[indexOfMaxFreq]);
           res[f++] = nums[indexOfMaxFreq] ;
        }
        return res;
    }
}
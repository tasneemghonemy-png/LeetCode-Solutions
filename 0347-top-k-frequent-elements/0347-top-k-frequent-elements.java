class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0) + 1);
        }

        final int BUCKET_NUMBER = nums.length + 1;

        List<List<Integer>> buckets = new ArrayList<>();

        for(int i = 0; i < BUCKET_NUMBER; i++){
            buckets.add(new ArrayList<>());
        }

        for(int num: freqMap.keySet()){
            int bucket_index = freqMap.get(num);
            buckets.get(bucket_index).add(num);
        }

        int[]res = new int[k];
        int m = 0;
        for(int i = buckets.size() - 1; i >= 0; i--){
            List<Integer> currBucket = buckets.get(i);
            if(!currBucket.isEmpty()){
                for (int h = 0; m < k && h < currBucket.size(); h++, m++){
                    res[m] = currBucket.get(h);
                }
            }
        }
        return res;
    }
}

/*class Solution {
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
}*/
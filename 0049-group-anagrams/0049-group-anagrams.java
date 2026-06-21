
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        String[] sortedStrs = new String[strs.length]; 
        for(int i = 0; i < strs.length; i++){
            char[]arr = strs[i].toCharArray();
            Arrays.sort(arr);
            sortedStrs[i] = new String(arr);
        }
        for(int i = 0; i < strs.length; i++){
            if(!map.containsKey(sortedStrs[i])){
                List l = new ArrayList<>();
                map.put(sortedStrs[i],l);
                l.add(strs[i]);
            }
            else {
                map.get(sortedStrs[i]).add(strs[i]);
            }
        }
        List<List<String>> res= new ArrayList<>();
        for(String k:map.keySet()){
            res.add(map.get(k));
        }
        return  res;
    }
}


class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        if(t.length() != s.length())return false;

        for(int i = 0; i < t.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0) + 1);
        }

        for(int i = 0; i < t.length(); i++){
            if(! (sMap.containsKey(t.charAt(i)) && tMap.containsKey(t.charAt(i)))) return false;
            if(!sMap.get(t.charAt(i)).equals(tMap.get(t.charAt(i)))) return false;
        }
        return true;
    }
}
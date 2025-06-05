
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        int len=0;
        if(s.length()==1){
            return 1;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int j=0;
        int i=0;
        while(i<s.length()){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i))>=j){
                len = i-j;
                maxLen = Math.max(maxLen,len);
                j=map.get(s.charAt(i))+1;
                map.put(s.charAt(i),i);
            }
            map.put(s.charAt(i),i);
            i++;
        }
        len = i-j;
        maxLen = Math.max(maxLen,len);
        return maxLen;
    }
}

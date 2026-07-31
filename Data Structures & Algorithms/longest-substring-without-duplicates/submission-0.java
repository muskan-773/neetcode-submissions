class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> st = new HashSet<>();
        int max = 0;
        int i = 0;
        for(int j = 0;j < s.length();j++){
            while(st.contains(s.charAt(j))){
                st.remove(s.charAt(i));
                i++;
            }
            st.add(s.charAt(j));
            max = Math.max(max, j-i+1);
        }
        return max;
    }
}

// Time Complexity : O(s+p)
// Space Complexity : O(52)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //base case
        if(p.length() > s.length()) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        int[] frequencyP = new int[26];
        int[] frequencyWindow = new int[26];
        
        //populate the frequencies of P
        for(int i=0;i<p.length();i++)
        {
            char ch = p.charAt(i);
            frequencyP[ch - 'a']++;
        }
        
        int start=0, end=0;
        
        while(end < s.length())
        {
            char ch = s.charAt(end);
            frequencyWindow[ch - 'a']++;
            
            if(end-start+1 > p.length())
            {
                frequencyWindow[s.charAt(start) - 'a']--;
                start++;
            }
            
            //found anagram
            if(Arrays.equals(frequencyP, frequencyWindow))
                result.add(start);
        
            end++;
        }
        return result;
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length(), plen = p.length();
        if(slen<plen)   return new ArrayList<Integer>();

        int[] win_s = new int[26];
        int[] p_count = new int[26];
        List<Integer> ans = new ArrayList<Integer>();

        for(int i=0;i<plen;i++){
            p_count[p.charAt(i)-'a']++;
            win_s[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(p_count,win_s)){
            ans.add(0);
        }

        for(int i=1;i<slen-plen+1;i++){
            win_s[s.charAt(i+plen-1)-'a']++;
            win_s[s.charAt(i-1)-'a']--;
            if(Arrays.equals(p_count,win_s)){
                ans.add(i);
            }
        }
        return ans;
    }
}

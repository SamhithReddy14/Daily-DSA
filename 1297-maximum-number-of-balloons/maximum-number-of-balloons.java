class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length() ;
        //HashMap<Character,Integer> map = new HashMap<>() ;
        int cnt[] = new int[26] ;
        for (char ch : text.toCharArray()) {
            cnt[ch - 'a']++;
        }
        int ans = Integer.MAX_VALUE;

        ans = Math.min(ans, cnt['b' - 'a']);
        ans = Math.min(ans, cnt['a' - 'a']);
        ans = Math.min(ans, cnt['l' - 'a'] / 2);
        ans = Math.min(ans, cnt['o' - 'a'] / 2);
        ans = Math.min(ans, cnt['n' - 'a']);

        return ans;

    }
}
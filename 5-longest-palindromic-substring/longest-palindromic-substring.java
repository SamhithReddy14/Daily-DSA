class Solution {
    static String getValidSubstring(String s,int p1,int p2){
        int n=s.length();
        while(p1>=0 && p2<n){
            if(s.charAt(p1)==s.charAt(p2)){
                p1--;
                p2++;
            }
            else{
                break;
            }
        }
        String ans=s.substring(p1+1,p2);
        return ans;
    }
    public String longestPalindrome(String s) {
        String max="";
        for(int i=0;i<s.length();i++){
            String odd=getValidSubstring(s,i,i);
            String even=getValidSubstring(s,i,i+1);
            String ans=odd.length()>even.length() ? odd : even;
            max=max.length()>ans.length() ? max :ans;
        }
        return max;
    }
}
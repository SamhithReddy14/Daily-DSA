class Solution {
    public boolean checkDivisibility(int n) {
        int number = n ;
        int sum = 0 , product = 1 ;
        while(n>0) {
            int digit = n%10 ;
            sum += digit ;
            product *= digit ;
            n /= 10 ;
        }
        int total = sum+product ;
        return number%total == 0 ;
    }
}
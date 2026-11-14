class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int prev2=1;                          
        int prev1=s.charAt(0)=='0'?0:1;
        for(int i=2;i<=n;i++){
            int oneDigit=s.charAt(i-1)-'0';
            int twoDigits=(s.charAt(i-2)-'0')*10+oneDigit;
            int current=0;
            if(oneDigit>=1) current+=prev1;
            if(twoDigits>=10&&twoDigits<=26) current+=prev2;
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
}
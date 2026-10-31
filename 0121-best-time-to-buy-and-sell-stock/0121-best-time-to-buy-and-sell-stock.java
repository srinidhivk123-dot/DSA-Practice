class Solution {
    public int maxProfit(int[] prices) {
        int minp=Integer.MAX_VALUE;
        int maxpro=0;
        for(int price:prices){
            if(price<minp){
                minp=price;
            }
            else{
                maxpro=Math.max(maxpro,price-minp);
            }
        }
        return maxpro;
    }
}
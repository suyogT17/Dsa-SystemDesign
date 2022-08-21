package com.dsalgo.arrays;

/**
 * Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
class BuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0 ;
        }
        int min=prices[0], profit = 0;
        for(int i=1;i<prices.length;i++){
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);

        }
        return profit;
    }
}
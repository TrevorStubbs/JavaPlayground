package org.example.leetcode;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        Integer lowest = Integer.MAX_VALUE;
        Integer lowestIndex = 0;
        Integer highest = Integer.MIN_VALUE;

        Integer now = 0;
        Integer lookAhead = 0;
        Integer profit = Integer.MIN_VALUE;

        if (prices.length == 1) {
            return 0;
        }

        while (now < prices.length && lookAhead < prices.length) {
            System.out.println(prices[now]);
            if (prices[now] < lowest) {
                if(now == prices.length - 1) {
                    return profit > 0 ? profit : 0;
                }
                lowest = prices[now];
                lowestIndex = now;
                lookAhead = now + 1;
            } else {
                profit = prices[lookAhead] - prices[lowestIndex] > profit ? prices[lookAhead] - prices[lowestIndex] : profit;
                lookAhead++;
            }
            now++;
        }

        return profit;
    }

    public static int maxProfitFaster(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price: prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}

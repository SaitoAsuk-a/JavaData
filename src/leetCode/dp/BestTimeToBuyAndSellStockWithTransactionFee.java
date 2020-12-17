package leetCode.dp;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * date 2020/12/17 15:19
 * description ������Ʊ�����ʱ����������
 * ����һ����������?prices�����е�?i?��Ԫ�ش����˵�?i?��Ĺ�Ʊ�۸� ���Ǹ�����?fee �����˽��׹�Ʊ���������á�
 * ��������޴ε���ɽ��ף�������ÿ�ʽ��׶���Ҫ�������ѡ�������Ѿ�������һ����Ʊ����������֮ǰ��Ͳ����ټ��������Ʊ�ˡ�
 * ���ػ����������ֵ��
 * ע�⣺�����һ�ʽ���ָ������в�������Ʊ���������̣�ÿ�ʽ�����ֻ��ҪΪ֧��һ�������ѡ�
 * ʾ�� 1:
 * ����: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * ���: 8
 * ����: �ܹ��ﵽ���������:
 * �ڴ˴�����?prices[0] = 1
 * �ڴ˴����� prices[3] = 8
 * �ڴ˴����� prices[4] = 4
 * �ڴ˴����� prices[5] = 9
 * ������:?((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * ע��:
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
@UtilityClass
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        int i = maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        System.out.println("i = " + i);
    }

    /**
     * dp[i][0] ��i�콻�׺󲻳��й�Ʊӯ��
     * dp[i][1] ��i�콻�׺����һֻ��Ʊ��ӯ��
     * dp[i][0]=max{dp[i-1][0],dp[i-1][1]+prices[i]}
     * dp[i][1]=max{dp[i-1][1],dp[i-1][0]-dp[i]-fee}
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }

        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = 0 - prices[0] - fee;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }

    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < n; ++i) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }

    /**
     * ��������̰���㷨
     * ˼·���㷨
     * ����һ�У����ǽ������ѷ�������ʱ���м��㡣������ǻ�һ���Ƕȿ��ǣ��������ѷ�������ʱ���м��㣬��ô�Ϳ��Եõ�һ�ֻ���̰�ĵķ�����
     * ������ buy ��ʾ����������ǰ���£������������ӵ��һ֧��Ʊ����ô�����������۸��Ƕ��١�
     * �ڳ�ʼʱ��buy ��ֵΪprices[0] ����������fee����ô�����Ǳ�������i?(i>0) ��ʱ��
     * �����ǰ�Ĺ�Ʊ�۸� prices[i] ���������� fee С�� buy����ô����ʹ�� buy �ļ۸����Ʊ�����ǲ�����prices[i]+fee �ļ۸����Ʊ��
     * ������ǽ� buy ����Ϊ prices[i]+fee��
     * �����ǰ�Ĺ�Ʊ�۸�prices[i] ���� buy����ô����ֱ��������Ʊ���һ�� prices[i]?buy �����档
     * ��ʵ���ϣ����Ǵ�ʱ������Ʊ���ܲ�����ȫ�����ŵģ�������һ���Ʊ�۸������������������ǿ����ṩһ�����ڲ�����
     * ���ɵ�ǰ����ӵ��һ֧����۸�Ϊ prices[i] �Ĺ�Ʊ���� buy ����Ϊprices[i]������һ���������һ���Ʊ�۸�������������ǻ���prices[i+1]?prices[i] �����棬
     * ������һ�� prices[i]?buy �����棬ǡ�þ͵�������һ�첻�����κβ�����������һ��������Ʊ�����棻
     * ��������������prices[i] �������� [buy?fee,buy] �ڣ����ļ۸�û�е͵����Ƿ������ϵĹ�Ʊȥѡ������Ҳû�иߵ����ǿ���ͨ������������棬������ǲ������κβ�����
     * �����̰��˼�����Ũ����һ�仰��������������һ֧��Ʊʱ�����Ǿ��������������ͬ�۸����������������һ֧��Ʊ��Ȩ�����ڱ������������� prices ֮��֮�����Ǿ͵õ������������档
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit3(int[] prices, int fee) {
        int n = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}

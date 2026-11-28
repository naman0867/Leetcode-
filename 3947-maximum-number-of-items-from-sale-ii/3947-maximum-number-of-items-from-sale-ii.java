
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int maxFactor = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] freq = new int[maxFactor + 1];
        int[] cnt = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        for (int i = 1; i <= maxFactor; i++) {
            for (int j = i; j <= maxFactor; j += i) {
                cnt[i] += freq[j];
            }
        }

        List<int[]> offers = new ArrayList<>();

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            int freeCount = cnt[factor] - 1;

            if (freeCount > 0 && price <= 2L * minPrice) {
                offers.add(new int[]{price, freeCount});
            }
        }

        offers.sort(Comparator.comparingInt(a -> a[0]));

        long ans = 0;
        long remaining = budget;

        for (int[] offer : offers) {
            long price = offer[0];
            long count = offer[1];

            long take = Math.min(count, remaining / price);

            ans += 2 * take;
            remaining -= take * price;
        }

        ans += remaining / minPrice;

        return (int) ans;
    }
}

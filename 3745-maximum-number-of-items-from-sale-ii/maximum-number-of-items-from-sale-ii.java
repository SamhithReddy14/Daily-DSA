class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        long minPrice = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            maxFactor = Math.max(maxFactor, items[i][0]);
            minPrice = Math.min(minPrice, items[i][1]);
        }
        int[] factors = new int[maxFactor + 1];
        for (int i = 0; i < n; i++) {
            factors[items[i][0]]++;
        }
        long[] factorToFree = new long[maxFactor + 1];
        for (int i = 1; i <= maxFactor; i++) {
            if (factors[i] > 0) {
                long freeItems = 0;
                for (int j = 2 * i; j <= maxFactor; j += i) {
                    freeItems += factors[j];
                }
                freeItems += (factors[i] - 1);
                factorToFree[i] = freeItems;
            }
        }
        List<long[]> specialItems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            long price = items[i][1];
            long count = factorToFree[factor];
            if (count > 0 && price < 2L * minPrice) {
                specialItems.add(new long[]{price, count});
            }
        }
        Collections.sort(specialItems, (a, b) -> Long.compare(a[0], b[0]));
        long specialcopies = 0;
        long remainingBudget = budget;
        for (long[] special : specialItems) {
            long price = special[0];
            long count = special[1];
            if (remainingBudget >= price) {
                long affordable = remainingBudget / price;
                long take = Math.min(affordable, count);
                specialcopies += take;
                remainingBudget -= take * price;
            }
        }
        long maxItems =(2L * specialcopies)+(remainingBudget/minPrice) ;
        return (int) maxItems;
    }
}
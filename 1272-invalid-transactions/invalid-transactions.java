class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        String[] name = new String[n];
        int[] time = new int[n];
        int[] amount = new int[n];
        String[] city = new String[n];
        for (int i = 0; i < n; i++) {
            String[] parts = transactions[i].split(",");
            name[i] = parts[0];
            time[i] = Integer.parseInt(parts[1]);
            amount[i] = Integer.parseInt(parts[2]);
            city[i] = parts[3];
        }
        boolean[] invalid = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (amount[i] > 1000) {
                invalid[i] = true;
            }
            for (int j = i + 1; j < n; j++) {
                if (name[i].equals(name[j]) &&
                    !city[i].equals(city[j]) &&
                    Math.abs(time[i] - time[j]) <= 60) {
                    invalid[i] = true;
                    invalid[j] = true;
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (invalid[i]) {
                ans.add(transactions[i]);
            }
        }
        return ans;
    }
}
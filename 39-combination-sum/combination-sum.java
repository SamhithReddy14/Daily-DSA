class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), list);
        return list;
    }
    public void backtrack(int[] candidates, int idx, int target,
                          List<Integer> l, List<List<Integer>> list) {
        if (target == 0) {
            list.add(new ArrayList<>(l));
            return;
        }
        if (idx == candidates.length || target < 0) {
            return;
        }
        l.add(candidates[idx]);
        backtrack(candidates, idx, target - candidates[idx], l, list);
        l.remove(l.size() - 1);
        backtrack(candidates, idx + 1, target, l, list);
    }
}
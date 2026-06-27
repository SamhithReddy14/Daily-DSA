class Solution {
    static String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        backtrack(digits, 0, new StringBuilder(), list);
        return list;
    }
    public void backtrack(String digits, int index, StringBuilder sb, List<String> list) {
        if (index == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtrack(digits, index + 1, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
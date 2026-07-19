class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        boolean[] visited = new boolean[26];
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int currIdx = curr - 'a';
            count[currIdx]--;
            if (visited[currIdx]) {
                continue;
            }
            while (stack.length() > 0 && 
                   stack.charAt(stack.length() - 1) > curr && 
                   count[stack.charAt(stack.length() - 1) - 'a'] > 0) {
                char removed = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);
                visited[removed - 'a'] = false;
            }
            stack.append(curr);
            visited[currIdx] = true;
        }
        return stack.toString();
    }
}
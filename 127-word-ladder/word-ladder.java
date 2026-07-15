class Solution {
    class Pair {
        String word;
        int count;
        Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord))
            return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            String word = curr.word;
            int level = curr.count;
            if (word.equals(endWord))
                return level;
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char original = arr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if (set.contains(newWord)) {
                        q.offer(new Pair(newWord, level + 1));
                        set.remove(newWord);
                    }
                }
                arr[i] = original;
            }
        }

        return 0;
    }
}
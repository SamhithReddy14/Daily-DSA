import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> counts = new HashMap<>();
        
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!counts.containsKey(c) || counts.get(c) == 0) {
                return false;
            }
            
            counts.put(c, counts.get(c) - 1);
        }
        
        return true;
    }
}
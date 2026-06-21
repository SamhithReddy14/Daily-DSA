class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();
        for (String s : arr) {
            if (s.equals("") || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(s);
            }
        }
        if (st.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : st) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }
}
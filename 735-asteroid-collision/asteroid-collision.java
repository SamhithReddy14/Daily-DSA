class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (st.isEmpty()) {
                st.push(asteroids[i]);
            }
            else {
                boolean alive = true;
                while (!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0) {
                    int val = st.peek();
                    if (Math.abs(val) < Math.abs(asteroids[i])) {
                        st.pop();
                    }
                    else if (Math.abs(val) == Math.abs(asteroids[i])) {
                        st.pop();
                        alive = false;
                        break;
                    }
                    else {
                        alive = false;
                        break;
                    }
                }
                if (alive) {
                    st.push(asteroids[i]);
                }
            }
        }
        int arr[] = new int[st.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = st.get(i);
        }
        return arr;
    }
}
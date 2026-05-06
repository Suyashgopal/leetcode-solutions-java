class Solution {
    public int[] asteroidCollision(int[] arr) {

        int n = arr.length;
        int i = 0;

        Stack<Integer> st = new Stack<>();

        while (i < n) {

            if (arr[i] < 0) {

                while (!st.isEmpty() &&
                       st.peek() > 0 &&
                       -arr[i] > st.peek()) {

                    st.pop();
                }

                // equal case AFTER popping smaller ones
                if (!st.isEmpty() &&
                    st.peek() > 0 &&
                    -arr[i] == st.peek()) {

                    st.pop();
                }

                else if (st.isEmpty()) {
                    st.push(arr[i]);
                }

                else if (st.peek() < 0) {
                    st.push(arr[i]);
                }
            }

            if (arr[i] > 0) {
                st.push(arr[i]);
            }

            i++;
        }

        int[] res = new int[st.size()];

        for (int k = st.size() - 1; k >= 0; k--) {
            res[k] = st.pop();
        }

        return res;
    }
}
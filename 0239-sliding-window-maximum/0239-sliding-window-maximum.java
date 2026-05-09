class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {

        int n = arr.length;

        Deque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> al = new ArrayList<>();

        // first window
        for (int i = 0; i < k; i++) {

            while (!q.isEmpty() && arr[i] >= arr[q.getLast()]) {
                q.removeLast();
            }

            q.addLast(i);
        }

        al.add(arr[q.getFirst()]);

        int i = k;

        while (i < n) {

            int curr = arr[i];
            int idxlimit = i - k;

            // remove out of window
            while (!q.isEmpty() && q.getFirst() <= idxlimit) {
                q.removeFirst();
            }

            // maintain decreasing deque
            while (!q.isEmpty() && curr >= arr[q.getLast()]) {
                q.removeLast();
            }

            q.addLast(i);

            al.add(arr[q.getFirst()]);

            i++;
        }

        int[] res = new int[al.size()];

        for (int j = 0; j < al.size(); j++) {
            res[j] = al.get(j);
        }

        return res;
    }
}
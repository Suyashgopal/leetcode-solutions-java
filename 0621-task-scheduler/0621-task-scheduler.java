import java.util.*;

class Solution {

    public int leastInterval(char[] arr, int n) {

        // frequency map
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // max heap array
        int[] max = new int[map.size()];

        int ptr = 0;
        for (int k : map.values()) {
            max[ptr++] = k;
        }

        int size = max.length;

        // build heap
        for (int i = (size / 2) - 1; i >= 0; i--) {
            downheap(i, max, size);
        }

        int time = 0;

        while (size > 0 && max[0] > 0) {

            ArrayList<Integer> used = new ArrayList<>();

            int cycle = n + 1;
            int workDone = 0;

            for (int i = 0; i < cycle; i++) {

                if (size > 0 && max[0] > 0) {

                    int val = max[0];

                    // remove root
                    swap(max, 0, size - 1);
                    size--;

                    if (size > 0) {
                        downheap(0, max, size);
                    }

                    val--;

                    if (val > 0) {
                        used.add(val);
                    }

                    workDone++;
                    time++;
                }
                else {

                    // no task left
                    if (used.size() == 0) {
                        break;
                    }

                    // idle time
                    time++;
                }
            }

            // reinsert used tasks
            for (int val : used) {

                max[size] = val;
                int idx = size;
                size++;

                // upheap
                while (idx > 0) {

                    int parent = (idx - 1) / 2;

                    if (max[parent] < max[idx]) {
                        swap(max, parent, idx);
                        idx = parent;
                    } else {
                        break;
                    }
                }
            }
        }

        return time;
    }

    // max heapify
    void downheap(int i, int[] arr, int size) {

        int idx = i;

        while (idx < size / 2) {

            int left = 2 * idx + 1;
            int right = 2 * idx + 2;

            int largest = idx;

            if (left < size && arr[left] > arr[largest]) {
                largest = left;
            }

            if (right < size && arr[right] > arr[largest]) {
                largest = right;
            }

            if (largest != idx) {
                swap(arr, idx, largest);
            } else {
                break;
            }

            idx = largest;
        }
    }

    void swap(int[] arr, int a, int b) {

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
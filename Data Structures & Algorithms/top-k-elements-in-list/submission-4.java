class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // List<int[]> arr = new ArrayList<>();
        // map.forEach((key, value) -> arr.add(new int[]{value, key}));
        // arr.sort((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> heap = getHeap(map, k);
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            // res[i] = arr.get(i)[1];
            res[i] = heap.poll()[1];
        }
        return res;
    }

    PriorityQueue<int[]> getHeap(Map<Integer, Integer> map, int k){
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        map.forEach((num, count) -> {
            heap.offer(new int[]{count, num});
            if(heap.size() > k){
            heap.poll();
        }
        });
        return heap;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map = new HashMap<Integer,Integer>();
        int leng = nums.length;
        for(int i=0;i<leng;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return map.get(a)-map.get(b);
            }
        });

        for(Integer key:map.keySet()){
            if(minHeap.size()<k){
                minHeap.add(key);
            }
            else if(map.get(key)>map.get(minHeap.peek())){
                minHeap.remove();
                minHeap.add(key);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!minHeap.isEmpty()){
            res.add(minHeap.remove());
        }
        int[] intres = res.stream().mapToInt(Integer::intValue).toArray();
        return intres;
    }
}

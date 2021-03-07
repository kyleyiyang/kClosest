class Solution {
    public int[][] kClosest(int[][] points, int k) {
      Map<Integer,Integer> map = new HashMap<>();
        //int[] dist = new int[points.length];
        for (int i=0;i<points.length;i++) {
            int dist=(int)(Math.pow(points[i][0],2)+Math.pow(points[i][1],2));
            map.put(i,dist);
        }
        Queue<Integer> heap = new PriorityQueue<>((n1,n2)->map.get(n2)-map.get(n1));
        for (int j:map.keySet()) {
            heap.add(j);
            if (heap.size()>k) heap.poll();
        }
        int[][] ans=new int[k][2];
        for (int i=0;i<k;i++) {
            ans[i]=points[heap.poll()];
        }
        return ans;
    }
}

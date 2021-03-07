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

//quickSelect
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(0,points.length-1,k-1,points);
        int[][] ans=new int[k][2];
        for (int i=0;i<k;i++) {
            ans[i]=points[i];
        }
        return ans;
    }
    public static void quickSelect(int left,int right,int k,int[][] points) {
        if (left==right) return;
        
        int pivot=partition(left,right,points);
        if (pivot == k) return;
        else if (pivot>k) {
            quickSelect(left,pivot-1,k,points);
        } else {
            quickSelect(pivot+1,right,k,points);
        }
    }
    public static int partition(int left, int right, int[][] points) {
        Random rdm=new Random();
        int pivot=left+rdm.nextInt(right-left);
        swap(pivot,right,points);
        int j=left;
        for (int i=left;i<right;i++) {
            if (distance(i,points)<distance(right,points)) {
                swap(j,i,points);
                j++;
            }
        }
        swap(j,right,points);
        return j;
    }
    public static int distance(int i,int[][] points) {
        return points[i][0]*points[i][0]+points[i][1]*points[i][1];
    }
    public static void swap(int a, int b, int[][] points) {
        int[] temp=points[a];
        points[a]=points[b];
        points[b]=temp;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        
        int n = position.length;
        int fleets = n;
        int[][] cars = new int[n][2];

        for(int i=0;i<n;i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars,(a,b) -> (a[0]-b[0]));

        Stack<Double> st = new Stack<>();

        for(int j=0;j<cars.length;j++) {
            double time = (double)(target-cars[j][0])/cars[j][1];
            while(!st.isEmpty() && st.peek() <= time) {
                fleets--;
                st.pop();
            }
            st.push(time);
        }

        return fleets;
        
       
    }
}

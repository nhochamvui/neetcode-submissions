class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // sort by descending order
        // iterate through array
        // calculate time
        // if max_time != 0, then compare time <= max_time
        // true -> number of fleet remains
        // false -> number of fleet ++
        // store position and their speed
        int[][] posNS = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            posNS[i][0] = position[i];
            posNS[i][1] = speed[i];
        }
        Arrays.sort(posNS, (a, b) -> Integer.compare(b[0], a[0]));
        float maxTime = 0;
        int fleet = 0;
        for (int i = 0; i < position.length; i++) {
            float time = (float) (target - posNS[i][0]) / posNS[i][1];
            if(maxTime == 0){
                maxTime = time;
                fleet++;
            }
            else if(time > maxTime){
                fleet++;
                maxTime = time;
            }
        }
        return fleet;
    }
}

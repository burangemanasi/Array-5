//1041. Robot Bounded in Circle - https://leetcode.com/problems/robot-bounded-in-circle/description/

//using direction Array
//Time Complexity: O(4n) ~ going over 4 times
class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}}; //N, E, S, W
        int idx = 0;
        int x = 0, y = 0;

        //4: 4 directions in total
        for(int i=0; i<4; i++){
            for(char c: instructions.toCharArray()){
                if(c == 'G'){
                    x = x + dirs[idx][0];
                    y = y + dirs[idx][1];
                } else if(c == 'R'){
                    idx = (idx+1) % 4; //to handle out of bounds
                } else if(c == 'L'){
                    idx = (idx+3) % 4; //to handle out of bounds
                }
            }
            if(x == 0 && y == 0) return true; //reached origin
        }
        return false;
    }
}

//Time Complexity: O(n) ~ going over once
class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // N, E, S, W
        int idx = 0;
        int x = 0, y = 0;

        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                x = x + dirs[idx][0];
                y = y + dirs[idx][1];
            } else if (c == 'R') {
                idx = (idx + 1) % 4; // to handle out of bounds
            } else if (c == 'L') {
                idx = (idx + 3) % 4; // to handle out of bounds
            }
        }
        //reached origin or if there is a change in direction
        //not facing north
        if((x == 0 && y == 0) || idx != 0){
            return true;
        }

        return false;
    }
}
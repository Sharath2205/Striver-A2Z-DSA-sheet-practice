package Arrays.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        // int N = A.size();
        // int count = 0;

        // for(int i = 0; i < N; i++) {
        // int xor = 0;
        // for(int j = i; j < N; j++) {
        // xor ^= A.get(j);
        // if(xor == B) {
        // count++;
        // }
        // }
        // }

        // return count;

        int N = A.size();
        int xor = 0, count = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        mp.put(0, 1);

        for (int i = 0; i < N; i++) {
            xor ^= A.get(i);
            int find = xor ^ B;
            if (mp.containsKey(find)) {
                count += mp.get(find);
            }
            mp.put(xor, mp.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}

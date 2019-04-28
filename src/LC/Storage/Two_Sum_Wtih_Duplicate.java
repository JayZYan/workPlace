package LC;

import java.util.*;

public class Two_Sum_Wtih_Duplicate {

    public List<int[]> findTwoSums(int[] arr, int target) {
        List<int[]> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                List<Integer> cur = map.get(target - arr[i]);
                for (int n : cur) {
                    res.add(new int[]{i, n});
                }
            }
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3,4,5};
        int target = 5;
        Two_Sum_Wtih_Duplicate test = new Two_Sum_Wtih_Duplicate();
        List<int[]> res = test.findTwoSums(arr, target);

        for (int[] a : res) {
            System.out.println(Arrays.toString(a));
        }
    }

}

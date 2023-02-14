import java.util.*;
class Solution {
    
    public List<List<Integer>> combinationSum(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> finalAns = new ArrayList<>();
        List<Integer> carrier = new ArrayList<>();
        generateCombination(nums, 0, target, carrier, finalAns);
        return finalAns;
    } 

    public void generateCombination(int [] nums, int idx, int target, List<Integer> carrier, List<List<Integer>> finalAns){
        if(target < 0){
            return;
        }
        if(target == 0){
            finalAns.add(new ArrayList<>(carrier));
            return;
        }
        if(idx == nums.length){
            if(target == 0){
                finalAns.add(new ArrayList<>(carrier));
                
            }
            return;
        }
        carrier.add(nums[idx]);
        target -= nums[idx];
        generateCombination(nums, idx, target, carrier, finalAns);
        target += nums[idx];
        carrier.remove(carrier.size()  -1);
        generateCombination(nums, idx + 1, target, carrier, finalAns);

    }
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int []nums = new int[n];
        for(int i = 0 ; i < n ; ++i){
            nums[i] = sc.nextInt();
        }
        Solution ob = new Solution();
        List<List<Integer>> ans = ob.combinationSum(nums,target);
        for(int i = 0 ; i < ans.size() ; ++i){
            Collections.sort(ans.get(i));
        }
        Collections.sort(ans, (o1, o2) -> {
                int m = Math.min(o1.size(), o2.size());
                for (int i = 0; i < m; i++) {
                    if (o1.get(i) == o2.get(i)){
                        continue;
                    }else{
                        return o1.get(i) - o2.get(i);
                    }
                }
                return 1;
            });
        for (int i = 0; i < ans.size (); i++)
            {
                for (int j = 0; j < ans.get(i).size (); j++)
                {
                    System.out.print(ans.get(i).get(j)+" ");
                }
                System.out.println();

            }


    }
}
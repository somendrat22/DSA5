class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> finalAns = new ArrayList<>();
        List<Integer> carrier = new ArrayList<>();
        generateCombination(candidates, target, 0, carrier, finalAns);
        return finalAns;
    }
    
    public void generateCombination(int [] candidates, int target, int idx, List<Integer> carrier, List<List<Integer>> finalAns){
        if(target < 0){
            return;
        }
        if(target == 0){
            finalAns.add(new ArrayList<>(carrier));
            return;
        }
        if(idx == candidates.length){
            if(target == 0){
                finalAns.add(new ArrayList<>(carrier));
                
            }
            return;
        }
        carrier.add(candidates[idx]);
        target -= candidates[idx];
        generateCombination(candidates, target, idx + 1, carrier, finalAns);
        target += candidates[idx];
        carrier.remove(carrier.size() - 1);
        int i  = idx;
        while(i < candidates.length && candidates[i] == candidates[idx]){
            i++;
        }
        generateCombination(candidates, target, i, carrier, finalAns);
    }
}
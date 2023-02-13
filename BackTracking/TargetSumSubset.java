import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> findSubsets(int[] arr, int tar) {
        ArrayList<Integer> carrier = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        generateSubsets(arr, tar, carrier, ans, 0, 0);
        return ans;
    }


	public static void generateSubsets(int [] arr, int tar, ArrayList<Integer> carrier, ArrayList<ArrayList<Integer>> ans, int idx, int sum){
        if(idx == arr.length){
            if(sum == tar){
                ans.add(new ArrayList<>(carrier));
            }
            return;
        }

        if(sum == tar){
            ans.add(new ArrayList<>(carrier));
            return;
        }


        sum += arr[idx];
        carrier.add(arr[idx]);
        generateSubsets(arr, tar, carrier, ans, idx + 1, sum);
        carrier.remove(carrier.size()  -1);
        sum -= arr[idx];
        generateSubsets(arr, tar, carrier, ans, idx + 1, sum);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, tar;
        n = sc.nextInt();
        tar = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        ArrayList<ArrayList<Integer>> subsets = findSubsets(arr, tar);
        Collections.sort(subsets, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        if (subsets.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < subsets.size(); i++) {
                for (int j = 0; j < subsets.get(i).size(); j++)
                    System.out.print(subsets.get(i).get(j) + " ");
                System.out.println();
            }
        }
        sc.close();
    }
}
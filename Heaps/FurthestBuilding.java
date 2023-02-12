import java.util.*;

class Solution {
    static int furthestBuilding(int height[], int bricks, int ladders)
    {
      PriorityQueue<Integer> maxBricks = new PriorityQueue<>();
      for(int i = 0; i<height.length - 1; i++){
        int diff = height[i+1] - height[i];
        if(bricks >= diff){
            maxBricks.add(diff);
            bricks -= diff;
        }else{
            if(maxBricks.size() > 0 && maxBricks.peek() >= diff){
                bricks = maxBricks.remove() + bricks;
                bricks -= diff;
                maxBricks.add(diff);
            }
            if(ladders > 0){
                ladders--;
            }else{
                return i;
            }
        }
      }
      return height.length - 1;
         
    }   

}

public class FurthestBuilding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int brick= sc.nextInt();
        int ladder= sc.nextInt();

        int height[] = new int[N];

        for(int i=0; i<N; i++){
            height[i]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.furthestBuilding(height,brick,ladder));

    }
}
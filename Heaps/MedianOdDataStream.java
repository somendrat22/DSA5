public import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MedianFinder medianFinder = new MedianFinder();
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      String s = sc.next();
      if (s.equals("addNum")) medianFinder.addNum(sc.nextInt()); else if (
        s.equals("findMedian")
      ) System.out.println(medianFinder.findMedian());
    }
    sc.close();
  }
}

class MedianFinder {

  // your code here
  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap
  double median;
  public MedianFinder() {
    // your code here
	minHeap = new PriorityQueue<>();
	maxHeap = new PriorityQUeue<>(Collections.reverseOrder());
    median = -1;
	
  }

  public void addNum(int num) {
    // your code here
    if(maxHeap.size() > 0 && maxHeap.peek() >= num){
        maxHeap.add(num);
    }else if(minHeap.size() > 0 && maxHeap.peek() < num){
        minHeap.add(num);
    }else{
        maxHeap.add(num);
    }

    int balance = maxHeap.size() - minHeap.size();

    if(balance > 1){
        int val = maxHeap.remove();
        minHeap.add(val);
    }else if(balance < 0){
        int val = minHeap.remove();
        maxHeap.add(val);
    }

    int totalElement = maxHeap.size() + minHeap.size();
    if(totalElement%2 == 0){
        median  = (minHeap.peek() + maxHeap.peek())/2.0;
    }else{
        median = (double)maxHeap.peek();
    }


  }

  public double findMedian() {
     return median;
  }
} {
    
}

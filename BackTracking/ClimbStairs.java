import java.util.*;
import static java.lang.Math.ceil;

class Accio {
    public int ClimbingStairs(int n) {
        
		int ans = tab(n);
		return ans;
    }


	public int tab(int n){
		int [] storage = new int[n + 1];
		storage[n] = 1;

		for(int i = n - 1; i>=0; i--){
			int w1 = i + 1 <= n ? storage[i + 1] : 0;
			int w2 = i + 2 <= n ? storage[i + 2] : 0;
			storage[i] = w1 + w2;
		}

		return storage[0];
	}

	public int memo(int src, int dest, int [] storage){
		if(src > dest){
			return 0;
		}
		if(src == dest){
			return 1;
		}
		if(storage[src] != 0){
			return storage[src];
		}
		int c1 = memo(src + 1, dest, storage);
		int c2 = memo(src + 2, dest, storage);
		storage[src] = c1 + c2;
		return c1 + c2;		
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Accio Obj = new Accio();
        System.out.println(Obj.ClimbingStairs(n));
    }
}
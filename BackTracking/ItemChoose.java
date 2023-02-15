package BackTracking;

public class ItemChoose {
    public static void main(String[] args) {
        // Enter Your Code Here
    }

    public void itemChoose(int [] boxes, int [] items, int idx){
        if(idx  ==  items.length){
            print(boxes)
        }
        for(int i = 0; i<boxes.length; i++){
            if(boxes[i] != 0){
                boxes[i] = items[idx];
                itemChoose(boxes, items, idx + 1);
                boxes[i] = 0;
            }
        }
    }


    public void boxChoose(int [] boxes, int [] items,int idx, int [] vis){
        if(idx == boxes.length){
            print(boxes);
            return;
        }
        for(int i = 0; i<items.length; i++){
            if(vis[i] == 0){
                boxes[idx] = items[i];
                vis[i] = 1;
                boxChoose(boxes, items, idx + 1, vis);
                boxes[idx] = 0;
                vis[i] = 0;
            }
        }
        boxChoose(boxes, items, idx + 1, vis);
    }
}

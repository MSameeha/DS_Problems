package LinkedLists;
import java.util.*;

class BrowserHistory {
    
    LinkedList<String> list;
    int index = 0;

    public BrowserHistory(String homepage) {
        list = new LinkedList<>();
        list.addLast(homepage);
    }
    
    public void visit(String url) {
        String element = list.get(index);
        while(list.getLast() != element){
            list.removeLast();
        }
        list.addLast(url);
        index++;
    }
    
    public String back(int steps) {
        index = Math.max(index-steps, 0);
        return list.get(index);
    }
    
    public String forward(int steps) {
        index = Math.min(index+steps, list.size()-1);
        return list.get(index);
    }
}


public class browsingHistory {
    
}

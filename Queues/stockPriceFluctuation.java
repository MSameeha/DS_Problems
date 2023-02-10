package Queues;

import java.util.*;

class StockRecord{

    int price;
    int timestamp;

    public StockRecord(){}

    public StockRecord(int timestamp, int price){
        this.price = price;
        this.timestamp = timestamp;
    }
}

class StockPrice{

    PriorityQueue<StockRecord> max = new PriorityQueue<>((s1, s2) -> (s2.price - s1.price));
    PriorityQueue<StockRecord> min = new PriorityQueue<>((s1, s2) -> (s1.price - s2.price));
    HashMap<Integer, Integer> map = new HashMap<>();
    StockRecord current_record;

    public StockPrice() {
        current_record = new StockRecord();
    }
    
    public void update(int timestamp, int price) {
        //update maximum and minimum
        if(timestamp >= current_record.timestamp){
            current_record.timestamp = timestamp;
            current_record.price = price;
        }
        StockRecord record = new StockRecord(timestamp, price);
        max.add(record);
        min.add(record);
        map.put(timestamp, price);
    }
    
    public int current() {
        return current_record.price;
    }
    
    public int maximum() {
        int ans = max.peek().price;
        while(max.peek().price != map.get(max.peek().timestamp)){
            max.poll();
        }
        ans = max.peek().price;
        return ans;
    }
    
    public int minimum() {
        int ans = min.peek().price;
        while(min.peek().price != map.get(min.peek().timestamp)){
            min.poll();
        }
        ans = min.peek().price;
        return ans;
    }
}

public class stockPriceFluctuation {

    StockPrice obj = new StockPrice();


}

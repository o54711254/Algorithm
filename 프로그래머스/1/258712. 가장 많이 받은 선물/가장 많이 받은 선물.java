import java.io.*;
import java.util.*;

class Trade{
    public final boolean send;
    public final String name;
    
    public Trade(boolean send, String name){
        this.send = send;
        this.name = name;
    }
    
    @Override
    public String toString(){
        return send + " " + name;
    }
}

class Solution {
    static Map<String, List<Trade>> tradeMap = new HashMap<>();
    static Map<String, Integer> resultMap = new HashMap<>();
    public int solution(String[] friends, String[] gifts) {
        
        for(String name : friends){
            tradeMap.put(name, new ArrayList<>());
            resultMap.put(name, 0);
        }
        
        for(String now : gifts){
            StringTokenizer st = new StringTokenizer(now);
            
            String sender = st.nextToken();
            String receiver = st.nextToken();
            
            tradeMap.get(sender).add(new Trade(true, receiver));
            tradeMap.get(receiver).add(new Trade(false, sender));
        }
        
        for(int i = 0; i< friends.length - 1; i++){
            for(int j = i+1; j<friends.length; j++){
                String a = friends[i];
                String b = friends[j];
                
                String winer = checkTrade(a, b);
                if(winer == null){
                    if(giftScore(a)>giftScore(b)){
                        winer = a;
                    }else if(giftScore(a)<giftScore(b)){
                        winer = b;
                    }else{
                        continue;
                    }
                }
                
                resultMap.put(winer, resultMap.get(winer) + 1);
            }
        }
        
        int answer = findResult(friends);
        
        return answer;
    }
    
    private String checkTrade(String a, String b){
        int sendToB = 0;
        int receiveByB = 0;
        
        List<Trade> tradeList = tradeMap.get(a);
        
        for(Trade trade : tradeList){
            if(trade.name.equals(b)){
                if(trade.send){
                    sendToB++;
                }else{
                    receiveByB++;
                }
            }    
        }
        
        if(sendToB > receiveByB){
            return a;
        }else if(sendToB < receiveByB){
            return b;
        }else{
            return null;   
        }
    }
    
    private int giftScore(String name){
        int send = 0;
        int receive = 0;
        
        List<Trade> tradeList = tradeMap.get(name);
        
        for(Trade trade : tradeList){
            if(trade.send){
                send++;
            }else{
                receive++;
            }
        }
        return send - receive;
    }
    
    private int findResult(String[] friends){
        
        int count = 0;
        
        for(String friend : friends){
            int score = resultMap.get(friend);
            if(count<score){
                count = score;
            }
        }
        
        return count;
    }
}

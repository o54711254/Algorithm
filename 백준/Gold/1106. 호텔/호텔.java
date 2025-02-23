import java.io.*;
import java.util.*;

class City {
    int cost;
    int customer;
    
    public City(int cost, int customer) {
        this.cost = cost;
        this.customer = customer;
    }
}

class Main {
    static int C, N;
    static int[] dp;
    static List<City> cityList = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            cityList.add(new City(cost, customer));
        }
        
        dp = new int[100001];
        knapsack();
        
        for (int i = 0; i <= 100000; i++) {
            if (dp[i] >= C) {
                System.out.println(i);
                return;
            }
        }
    }
    
    static void knapsack() {
        for (City city : cityList) {
            int nowCost = city.cost;
            int nowCustomer = city.customer;
            
            for (int i = nowCost; i <= 100000; i++) {
                dp[i] = Math.max(dp[i], dp[i - nowCost] + nowCustomer);
            }
        }
    }
}
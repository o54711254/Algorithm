import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	int num = sc.nextInt();
    	
    	double[] score = new double[num];
    	
    	for(int i = 0; i<num; i++) {
    		double a = sc.nextDouble();
    		score[i] = a;
    	}
    	
    	double max = 0;
    	for(int i =0; i<num; i++) {
    		if(score[i]>max) {
    			max = score[i];
    		}
    	}
    	
    	double sum = 0;
    	for(int i = 0; i<num; i++) {
    		sum += (score[i] / max)*100;
    	}
    	double result = sum/num;
    	System.out.println(result);
    }
}
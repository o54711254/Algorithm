import java.util.*;
import java.io.*;

class Student implements Comparable<Student>{
    int rank;
    int idx;
    
    public Student(int rank, int idx){
        this.rank = rank;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Student o){
        return this.rank - o.rank;
    }
    @Override
    public String toString(){
        return this.idx + " " + this.rank;
    }
}

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<Student> list = new ArrayList<>();
        
        for(int i = 0; i<rank.length; i++){
            if(attendance[i]){
                list.add(new Student(rank[i], i));
            }
        }
        
        Collections.sort(list);
        int answer = 0;
        answer += list.get(0).idx * 10000 + list.get(1).idx*100 + list.get(2).idx;
        return answer;
    }
}
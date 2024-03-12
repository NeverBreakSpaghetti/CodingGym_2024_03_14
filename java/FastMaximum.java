package java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Sequence {
    private int length;
    private int increaseToIndex;
    private int step;

    public Sequence(int length, int increaseToIndex, int step){
        this.length=length;
        this.increaseToIndex=increaseToIndex;
        this.step=step;
    }

    public int getLength(){
        return length;
    }

    public int getValueAt(int index){
        if (index<increaseToIndex)
            return step*index;
        else
            return length-1 -(step*index);
    }
}
public class FastMaximum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int increaseToIndex = Integer.parseInt(br.readLine());
        int step = Integer.parseInt(br.readLine());

        Sequence sequence = new Sequence(length,increaseToIndex,step);

        FastMaximum fastMaximum = new FastMaximum();

        System.out.println(fastMaximum.findPeak(sequence));
    }

    public int findPeak(Sequence sequence) {
        //write your code here
    }
}

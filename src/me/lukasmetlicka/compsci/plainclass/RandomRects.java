package me.lukasmetlicka.compsci.plainclass; /**
 * Created by LukasMetlicka on 10/31/14.
 */
import java.util.Random;
public class RandomRects {

    Random r = new Random();
    public int genRandomHW(){
        return r.nextInt(10) + 1;
    }
    public static void main(String[] args){
        RandomRects a = new RandomRects();
        int[] last4Heights = {0, 0, 0, 0};
        int[] last4Widths = {0, 0, 0, 0};
        while ( !(last4Heights[0] < last4Heights[1] && last4Heights[1] < last4Heights[2] && last4Heights[2] < last4Heights[3]) && !(last4Widths[0] < last4Widths[1] && last4Widths[1] < last4Widths[2] && last4Widths[2] < last4Widths[3]) )
        for(int i = 0; i < last4Heights.length - 1 ; i++) {
            last4Heights[i] = last4Heights[i+1];
            last4Widths[i] = last4Widths[i+1];
        }
        last4Heights[0] = a.genRandomHW();
        last4Widths[0] = a.genRandomHW();
    }

    }

package ArrayChar;

import java.util.ArrayList;
import java.util.List;

public class listPrimes {
    public static List<Integer> countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 2; i < n; i++){
            if(notPrime[i] == false){
                res.add(i);
                for(int j = 2; j * i < n; j++){
                    notPrime[i * j] = true;
                }
            }
        }
        return res;
    }
    public static void main(String[] arg){
        int n = 100;
        System.out.println(countPrimes(n));
    }
}

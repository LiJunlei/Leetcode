package ArrayChar;

public class countPrimes{
    public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++){
            if(notPrime[i] == false){
                count++;
                for(int j = 2; j * i < n; j++){
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }
    public static void main(String[] arg){
        int n = 10;
        System.out.println(countPrimes(n));
    }
}


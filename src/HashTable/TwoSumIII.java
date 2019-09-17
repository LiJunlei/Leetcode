package HashTable;

import java.util.HashMap;


/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */


public class TwoSumIII {
    HashMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSumIII() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number,map.getOrDefault(number, 0) + 1);  // count # of number
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Integer i : map.keySet()){
            int complement = value - i;
            if(map.containsKey(complement)){
                // avoid corner case. complement = i = value/2
                if(complement != i || map.get(complement) >= 2){
                    return true;
                }
            }
        }
        return false;
    }
}

import java.util.ArrayList;

class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> records = new ArrayList<Integer>(3);
        int top = -1;
        int result = 0;
        for(int i = 0; i < operations.length; i++){
            // If the operation at current index is an string representing an integer, cast to an int, move the top pointer one
            // index up, and add the integer value of the current operation to the result 
            if(operations[i].matches("-?\\d+")){
                records.add(Integer.valueOf(operations[i]));
                top++;
                result += records.get(top);
            }else if(operations[i].equals("C")){
                // As specified by the rules of the game, of the operation is C, we subtract the value of the top element
                // from the total result, and then remove the top element and move the top pointer down one index.
                // We assume there will be at least one integer before this operation, as specified in the constraints.
                result -= records.get(top);
                records.remove(top);
                top--;
            }else if(operations[i].equals("D")){
                // If the operation is D, we multiply the current top element by 2, then add this multiplication to the records,
                // move the pointer to the top one index up to point to this new element, and then add this new element to result
                int newEntry = 2 * records.get(top);
                records.add(newEntry);
                top++;
                result += records.get(top);
            }else if(operations[i].equals("+")){
                // If the operation is to add, we add the previous two elements. We access the element before the current top 
                // element by accessing one index before our current top. Then, add this new entry to the records, move the top
                // pointer up one index, and add this new entry to our result
                int newEntry = records.get(top) + records.get(top - 1); 
                records.add(newEntry);
                top++;
                result += records.get(top);
            }
            
        }
        return result;
    }
}
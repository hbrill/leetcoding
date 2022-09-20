class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> records = new ArrayList<Integer>(3);
        int top = -1;
        int result = 0;
        for(int i = 0; i < operations.length; i++){
            if(operations[i].matches("-?\\d+")){
                records.add(Integer.valueOf(operations[i]));
                top++;
                result += records.get(top);
            }else if(operations[i].equals("C")){
                result -= records.get(top);
                records.remove(records.get(top));
                top--;
            }else if(operations[i].equals("D")){
                int newEntry = 2 * records.get(top);
                records.add(newEntry);
                top++;
                result += records.get(top);
            }else if(operations[i].equals("+")){
                int newEntry = records.get(top) + records.get(top - 1);
                records.add(newEntry);
                top++;
                result += records.get(top);
            }
            
        }
        return result;
    }
}
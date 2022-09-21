class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        boolean isValid = false;
        int matches = 0;
        if(s.length() == 1)
            return false;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stk.push(s.charAt(i));
            }else if(s.charAt(i) == ')') {
                if(stk.isEmpty()){
                    break;
                }else if(stk.peek() == '('){
                    matches+=2;
                    stk.pop();
                }
            }else if(s.charAt(i) == '}') {
                if(stk.isEmpty()){
                    break;
                }else if(stk.peek() == '{'){
                    matches+=2;
                    stk.pop();
                }
            }else if(s.charAt(i) == ']') {
                if(stk.isEmpty()){
                    break;
                }else if(stk.peek() == '['){
                    matches+=2;
                    stk.pop();
                }
            }
        }
        if(matches == s.length()){
            isValid = true;
        }
        return isValid;
    }
}
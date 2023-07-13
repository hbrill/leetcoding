import java.util.Stack;

class Solution {
    Stack<Character> stk = new Stack<Character>(); 
    boolean isValid = false;
    int matches = 0;

    // This validation will not work if the opening brackets come after the closing ones.
    // For ex: If input is ")(" this will return false, even though we do have a corresponding set of brackets.
    public boolean isValid(String s) {
        if(s.length() == 1) // if only one bracket, we know it doesn't have a closing correspondent bracket, so return false
            return false;
        
        for(int i = 0; i < s.length(); i++){
            // Loop over string and if current character is an OPENING bracket, push it to stack 
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stk.push(s.charAt(i));
            }else if(s.charAt(i) == ')') { // but if character is a CLOSING bracket...
                /*
                 * We will check the next bracket, i.e the top if stack and see if it matches the current character.
                 * We execute checkValid passing the corresponding opening bracket as an argument. See function below.
                 */
                checkValid('(');
            }else if(s.charAt(i) == '}'){
                checkValid('{');
            }else if(s.charAt(i) == ']'){
                checkValid('[');
            }
        }
        if(matches == s.length()){
            isValid = true;
        }
        return isValid;
    }
    
    public void checkValid(char opening){
        /*
        * If we had found an opening bracket prior, it would be in our stack. If stack is empty, current bracket
        * does not have a corresponding closing bracket, so we exit out of loop. 
        * If the top of the stack has an opening bracket matching the current closing bracket, we remove the opening
        * bracket from the stack as we found it its corresponding, and we increase count by 2. See checkValid(bracket)
        * function.
        */
        if(stk.isEmpty())
            return;
        else if(stk.peek() == opening){
            matches+=2;
            stk.pop();
        }
    }
}
class Solution {
    public int lengthOfLastWord(String s) {
        // we will count backwards to start at the last word
        int curr = s.length() - 1;
        int lastLen = 0;

        // if string doesn't contain a space, there's only one word, hence the longest word is the length of the string
        if(s.contains(" ") != true)
            lastLen = s.length();
        else{
            // point to previous character
            char prev = ' ';
            while(curr >= 0){
                // if current character is a space and the previous character was not, we got the space in between the second to last word(if there is) and the last word
                if(s.charAt(curr) == ' ' && prev != ' ')
                    break;
                // if our current character is not a space, we're still counting characters of the last word
                else if(s.charAt(curr) != ' '){
                    lastLen++;
                    prev = s.charAt(curr); // make prev point to this current character before moving on to the next
                }
                curr--;
            }
        }

        return lastLen;
    }
}
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int circled, squared, top; // keeps track of num of students who prefer 
        // each type of sandwich and what type is at the top currently
        circled = squared = top = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < students.length; i++){
            // if current students likes current sandwich, they take it and top becomes next index
            if(sandwiches[top] == students[i])
                top++;
            else{
                // otherwise, add them to the queue of students who'll go a second round to try to
                // get their preferrence
                queue.add(students[i]);
                if(students[i] == 0)
                    circled++;
                else
                    squared++;
            }
        }
        
        while(!queue.isEmpty()){
            /*
             * Since we do not want to go on forever in the case of no one wanting the top sandwich,
             * if the current top is of one kind and everyone left in the queue wants the other,
             * since no one will take it we break out of this cycle and they do not eat lunch.
             */
            if((sandwiches[top] == 0 && squared == queue.size()) || 
              (sandwiches[top] == 1 && circled == queue.size()))
                break;
            else if(queue.peek() == sandwiches[top]){
                top++; // if current student wants the top sandwich, they can take if
                // Reduce whichever count of the students who preferred the sandwich just taken
                if(queue.peek() == 0)
                    circled--;
                else
                    squared--;
                
                queue.remove();
            }else{
                // otherwise add them back to the queue to go another round 
                queue.add(queue.remove());
            }            
            
            
        }
        
        return queue.size();
    }
}
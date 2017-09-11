public class CharStack
{
  private final int MAX_CAP = 100;
  private int top; //location of top item on the stack
  private char [] s; //The stack

  public CharStack(){
    //PRE:
    //POS:
    //TAS: Create an empty stack with a default capacity
    s = new char[MAX_CAP];
    top = -1;
  }

  public void push(char element){
    //PRE: stack is not full
    //POS: stack is one element larger. top element is input.
    //TAS: Add a new item to the stack
    top ++;
    s[top] = element;
  }

  public char pop (){
    //PRE: stack is not empty
    //POS: stack is one element shorter
    //TAS: remove and return the item on the top of the stack
    return s[top --];
  }

  public boolean isEmpty(){
    //PRE: any
    //POS: unchanged
    //TAS: return if the stack has no elements
    return top == -1;
  }

  public boolean isFull(){
    //PRE: any
    //POS: unchanged
    //TAS: return if the stack is at max capacity
    return top == MAX_CAP-1;
  }

  public int size(){
    return top + 1;
  }

  public char peek(){
    //PRE: stack is not empty
    //POS: unchanged
    //TAS:
    return s[top];
  }

  public String toString(){
    //PRE: any
    //POS: unchanged
    //TAS: return string of characters on stack, top to bottom
    String out = "";
    for(int i = top; i >= 0; i--){
      out += s[i];
    }
    return out;
  }

}

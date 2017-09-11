import java.util.Scanner;

public class postfix {
    static Scanner scan = new Scanner(System.in);
	static CharStack stack = new CharStack();
		
	static String line = scan.nextLine();
	static String out = "";
	
    public static void main(String [] args){
        for(int i=0; i<line.length(); i++){
			char current = line.charAt(i);
			
			if(current == '('){
                stack.push(current);
			}else if(current == ')'){
                handleParen();
			}else if(isOp(current)){
                handleOp(current);
			}else if(current != ' '){
                out += current;//Assume every character that isn't a operator or space is an operand
			}
		}
		System.out.println(stack.toString());
        while(!stack.isEmpty()){
            out += outOp(stack.pop());
        }
        out = out.replaceAll("[ ]{2,}", " ");
        System.out.println(out);
    }
    
    public static boolean isOp(char in){
        return in == '-' || in == '+' || in == '/' || in == '*';
    }
    
    public static boolean isGreaterOp(char a, char b){
        //PRE: a and b are operators
        //TAS: return if a is has more or equal precedence than b
        
        if(a == '(' || b == '('){
            return false;
        }
        if(b == '-' || b == '+'){
            return true;
        }
        if(a == '*' || a == '/'){
            return true;
        }
        return false;
    }
    
    public static String outOp(char op){
        return " " + op + " ";
    }
    
    public static void handleParen(){
        //POP & write until matching left paren is popped/removed.
        if(stack.toString().contains("(")){
            char popped = stack.pop();
            while (popped != '('){
                out += outOp(popped);
                popped = stack.pop();
            }
        }
    }
    
    public static void handleOp(char in){
        /*
            PUSH onto the stack. Write space character.
            However, first remove any operators already on 
            the stack that have higher or equal precedence 
            and write them out.
        */
        
        if(!stack.isEmpty()){
            char popped = stack.pop();
            while (isGreaterOp(popped, in)){
                out += outOp(popped);
                popped = stack.pop();
            }
            stack.push(popped);
        }
        stack.push(in);
        out += " ";
    }
}




























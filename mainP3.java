import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import javax.swing.text.MaskFormatter;



public class mainP3 {
	static LinkedQueue<String> newQueue = new LinkedQueue<>();
	static LinkedStack<String> newStack = new LinkedStack<>();
	// static BinaryTree<String> T = new BinaryTree<>();
	static char charAns;

	public static void main(String[] args) {
		
		int size = 0;
		/////// FILE READ //////

		try {
            FileInputStream fstream = new FileInputStream("/Users/Admin/Documents/workspace/project3/src/project3.txt");
            DataInputStream dis = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));

            String str;
            while ((str = br.readLine()) != null) {
               enterQueueStep1(str);              
            }
           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		// newQueue.display();
		

	}// Main

	            				//*********** enterQueueStep1 ***********// 
	private static void enterQueueStep1(String s) {
		int sizeCon = 0;
		
		
		
		//priority 1 low ----- 3high
int p0 =0;
int p1 =0;
int p2 =0;
int sp0 =0;
int sp1 =0;
int sp2 =0;

int i=0;

String charToString = null;
		for(i=0; i<s.length(); i++){
			charAns = s.charAt(i);
			 charToString = String.valueOf(charAns);
		
			switch (charToString) {
			case "(":
            case ")":
            	p0=0;
		    	//System.out.println("Setting p0 = 0");
                
            case "+":
            case "-":
            	p1=1;
		    	//System.out.println("Setting p1 = 1");
                
            case "*":
            case "/":
            	p2=2;
		    	//System.out.println("Setting p2 = 2");
			}
			
			
			if (Character.isLetterOrDigit(charAns)){
				System.out.print(charToString);
				newQueue.enqueue(charToString);
			}
			
			else if(s.charAt(i)=='+'){
				//System.out.println("checking for +");
				
				while(newStack.isEmpty() == false){
					//System.out.println("when into while loop");
					
						if(newStack.top().equals("(") || newStack.top().equals(")")){
							//System.out.println(" A1  sp0 =0");
							sp0 = 0;
							}
						
							else if(newStack.top().equals("+") || newStack.top().equals("-"))
							{
							//	System.out.println(" A1 sp1 =1");
								sp1 = 1;
							}
							else if(newStack.top().equals("*") || newStack.top().equals("/"))
							{
							//	System.out.println("  A1  sp2 = 2");
								sp2 = 2;
							}

						if(p1<=sp0 || p1<=sp1 || p1<=sp2){
						Object tempMin=newStack.pop();
						System.out.print(tempMin);
						newQueue.enqueue((String) tempMin);
						}

						else{
							newStack.push("+");	
					       }
			                        }///check stack null
			
		             	
		             		newStack.push("+");	
		             		
						///// here
							}
		
		
	
		
			else	if(s.charAt(i)=='-'){
				while(newStack.isEmpty() == false){
					if(newStack.top().equals("(") || newStack.top().equals(")")){
						//System.out.println("  A2.1  sp0 =0");
						sp0 = 0;
						}
					
						else if(newStack.top().equals("+") || newStack.top().equals("-"))
						{
						//	System.out.println(" A2.2 sp1 =1");
							sp1 = 1;
						}
						else if(newStack.top().equals("*") || newStack.top().equals("/"))
						{
						//	System.out.println(" A2.3  sp2 = 2");
							sp2 = 2;
						}
					
						if(p1<=sp0 || p1<=sp1 || p1<=sp2){
						Object tempMin=newStack.pop();
						System.out.print(tempMin);
						newQueue.enqueue((String) tempMin);
						}

						else{
							newStack.push("-");	
					       }
			                        }///check stack null
			
		             	
		             		newStack.push("-");	
		             		
						///// here
							}
		    
		    
			else	if(s.charAt(i)=='*'){
				while(newStack.isEmpty() == false){
					if(newStack.top().equals("(") || newStack.top().equals(")")){
						//System.out.println("  B1.1 sp0 =0");
						sp0 = 0;
						}
					
						else if(newStack.top().equals("+") || newStack.top().equals("-"))
						{
							//System.out.println("  B1.2 sp1 =1");
							sp1 = 1;
						}
						else if(newStack.top().equals("*") || newStack.top().equals("/"))
						{
							//System.out.println("  B1.3  sp2 = 2");
							sp2 = 2;
						}
					
						if(p2<=sp0 || p2<=sp1 || p2<=sp2){
							Object tempMin=newStack.pop();
							System.out.print(tempMin);
							newQueue.enqueue((String) tempMin);
						}

						else{
						newStack.push("*");	
					       }
			                        }///check stack null
			
			
				//newStack.push("*");	
			
			///// here				
			}
			else if(s.charAt(i)=='/'){
				while(newStack.isEmpty() == false){
					if(newStack.top().equals("(") || newStack.top().equals(")")){
					//	System.out.println(" B2 sp0 =0");
						sp0 = 0;
						}
					
						else if(newStack.top().equals("+") || newStack.top().equals("-"))
						{
						///	System.out.println(" B2 sp1 =1");
							sp1 = 1;
						}
						else if(newStack.top().equals("*") || newStack.top().equals("/"))
						{
						//	System.out.println(" B2 sp2 = 2");
							sp2 = 2;
						}
					
					if(p2<=sp0 || p2<=sp1 || p2<=sp2){
						Object tempMin=newStack.pop();
						System.out.print(tempMin);
						newQueue.enqueue((String) tempMin);
					}

						else{
							newStack.push("/");	
					       }
			                        }///check stack null
			
			
				newStack.push("/");	
			
			///// here			
			}
			else	if(s.charAt(i)=='('){
				while(newStack.isEmpty() == false){
					if(newStack.top().equals("(") || newStack.top().equals(")")){
						//System.out.println("C1  sp0 =0");
						sp0 = 0;
						}
					
						else if(newStack.top().equals("+") || newStack.top().equals("-"))
						{
						//	System.out.println(" C1  sp1 =1");
							sp1 = 1;
						}
						else if(newStack.top().equals("*") || newStack.top().equals("/"))
						{
						//	System.out.println(" C1 sp2 = 2");
							sp2 = 2;
						}
					
					if(p2<=sp0 || p2<=sp1 || p2<=sp2){
						Object tempMin=newStack.pop();
						System.out.print(tempMin);
						newQueue.enqueue((String) tempMin);
					}

						else{
							//newStack.push("(");	
					       }
			                        }///check stack null
			
			
				newStack.push(")");	
			
			///// here		
			}
		    
			else	if(s.charAt(i)==')'){
				while(newStack.isEmpty() == false){
					if(newStack.top().equals("(") || newStack.top().equals(")")){
					//	System.out.println(" C2 sp0 =0");
						sp0 = 0;
						}
					
						else if(newStack.top().equals("+") || newStack.top().equals("-"))
						{
					//		System.out.println("  C2  sp1 =1");
							sp1 = 1;
						}
						else if(newStack.top().equals("*") || newStack.top().equals("/"))
						{
					//		System.out.println("  C2  sp2 = 2");
							sp2 = 2;
						}
					
					if(p2<=sp0 || p2<=sp1 || p2<=sp2){
						Object tempMin=newStack.pop();
						System.out.print(tempMin);
						newQueue.enqueue((String) tempMin);
					}

						else{
							newStack.push(")");	
					       }
			                        }///check stack null
			
			
				///newStack.push(")");	
			
			///// here
			}
			
		/// for loop
		
//		enterQueueStep2(s);
		//newStack.display();

			
}       
		
		newStack.display();
		System.out.println();
		System.out.println("Above are the Values from the stack");
		System.out.print("\n");
		
	
		System.out.println("Below are Values from the stack to Queue");
		Object ff = newStack.top();
	      newQueue.enqueue((String) ff);
	      newQueue.display();
	   
	     	      
	
	}// Enter queue Step 1
	

	
	
	
}


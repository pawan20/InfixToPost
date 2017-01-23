import java.util.LinkedList;

public class LinkedStack<AnyType> implements Stack<AnyType>
{
  private LinkedList<AnyType> data;

  public LinkedStack() { 
	  data = new LinkedList<>(); 
	  }

  public int size() { 
	  return data.size(); 
	  }

  public boolean isEmpty() { 
	  return data.isEmpty();
	  }

  public void push(AnyType newValue) {
	  data.add(0, newValue); 
	 
	  }

  public AnyType top() {
	  return data.get(0); 
	  }

  public AnyType pop() { 
	  return data.remove(0); 
	  }
  
  public void display(){

      System.out.print(data.get(0));
  }
  
  
}

import java.util.LinkedList;

public class LinkedQueue<AnyType> implements Queue<AnyType>
{
	int mySize =-1;
  private LinkedList<AnyType> data;

  public LinkedQueue() { 
	  data = new LinkedList<>(); 
	  }

  public int size() { 
	  return data.size();
	  }

  public boolean isEmpty() {
	  return data.isEmpty(); 
	  }

  public void enqueue(AnyType newValue) {
	  mySize++;
	  data.add(newValue); 
	  
	  }

  public AnyType first() {
	  return data.get(0);
	  }

  public AnyType dequeue() {
	  mySize--;
	  return data.remove(0); 	
	  }
  public int mySize() { 
	  return mySize; 
	  }
  
  public void display(){

      for(int i=0;i<=mySize();i++){
        System.out.print(data.get(i));
      }
// System.out.println( data.get(0)+ " ");
  }
}


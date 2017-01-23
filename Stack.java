public interface Stack<AnyType>
{
  int size();
  boolean isEmpty();
  void push(AnyType newValue);
  AnyType top();
  AnyType pop();
}


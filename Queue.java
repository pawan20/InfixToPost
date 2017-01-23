public interface Queue<AnyType>
{
  int size();
  boolean isEmpty();
  void enqueue(AnyType newValue);
  AnyType first();
  AnyType dequeue();
}

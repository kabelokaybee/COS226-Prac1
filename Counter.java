public class Counter {
    public int value;
    public Peterson lock;
    public Counter(int i)
    {
        lock = new Peterson();
        value = i;
    }
    public int getAndIncrement()
    {
        lock.lock();
        try
        {
            return value++;

        }finally{lock.unlock();}
        
    }
}

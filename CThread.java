public class CThread extends Thread {
    
    public int [] array;
    public Counter counter;
    public Peterson lock;
    public CThread(int[] arr,Counter c,Peterson lock)
    {
        this.array = arr;
        this.counter =c;
        this.lock = lock;
    }
    public void run()
    {
        int i =0;
        int limit = array.length;
        while(i < limit)
        {
            i = counter.getAndIncrement();
            int j;
            if(i < limit)
            {
                for(j = 2;j < array[i];j++)
                {
                    if(array[i]%j == 0)
                        break;
                }
                if(j == array[i])
                {
                    lock.lock();
                    try
                    {
                        System.out.println(this.getName() + ":"+array[i]);
                    }finally{
                        lock.unlock();
                    }
                }    
            }
        } 
    }
}

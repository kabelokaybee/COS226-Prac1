
class Peterson implements Lock
{
    private boolean [] flag = new boolean[2];
    private int victim;
    @Override
    public void lock()
    {
        int i = Integer.parseInt(Thread.currentThread().getName().substring(7));
        int j = 1 - i;
        if(i < flag.length)
        {
            flag[i] = true; // I’m interested
            victim = i; // you go first
            while (flag[j] && victim == i) {}; // wait
        }
    }
    @Override
    public void unlock() {
        int i = Integer.parseInt(Thread.currentThread().getName().substring(7));
        flag[i] = false;
    }
    
}
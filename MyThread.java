class MyThread extends Thread {
    public int [] array;
    public int m,n;
    public MyThread(int [] arr,int n,int m)
    {
        this.array = new int[m - n];
        this.m = m;
        this.n = n;
        int j = 0;
        for(int i = n;i < m;i++)
        {
            array[j++] = arr[i];
        }
    }
    public void run()
    {
        for(int i = 0;i < array.length;i++)
        {
            int j;
            for(j = 2;j < array[i];j++)
            {
                if(array[i]%j == 0)
                {
                    break;
                }

            }
            if(j == array[i])
            {
                System.out.println(this.getName() + "["+n+"-"+m+"]:"+array[i]);
            }
        }
    }
        
}

public class Main {
    public static void main(String[] args){
        

        int [] arr = new int[10];
        System.out.println("Array: ");
        for(int i = 0; i < arr.length;i++)
        {
            arr[i] = i;
            System.out.print(arr[i] +" ");
        }
        System.out.println();
        Counter c = new Counter(0);
        Peterson lock = new Peterson();
        
        Thread[] threads = new CThread[2];
        

        threads[0] = new CThread(arr,c,lock);
        threads[1] = new CThread(arr,c,lock);
        

        System.out.println("Threads created by extending the Thread class:");

        for(Thread t : threads){        // Start running threads
            t.start();
        }

        for(Thread t : threads){        // Wait for all running threads to finish
            try {
                t.join();
            }catch(InterruptedException e){}
        }

    }
    
}

package hust.soict.globalict.aims.Aims;
public class MemoryDaemon implements java.lang.Runnable {
    public MemoryDaemon() {
        // TODO Auto-generated constructor stub
    }
    long memoryUsed=0;
    public void run()
    {
        Runtime rt = Runtime.getRuntime();
        long used;
        while(true)
        {
            used=rt.totalMemory()-rt.freeMemory();
            if(used!=memoryUsed)
            {
                System.out.println("\tMemory Used = "+used);
                memoryUsed=used;
            }
        }
    }
}


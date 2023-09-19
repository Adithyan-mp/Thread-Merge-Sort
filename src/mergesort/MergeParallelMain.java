
package mergesort;


public class MergeParallelMain {
    public static void main(String args[]) throws InterruptedException {
        long startTime=System.nanoTime();
        int value=Array.getNumberRange();//get the number range to sort the array
        Array obj = new Array(value);
        
        //take value of how many  thread to create 
        int num=Array.getNumber();
        
        //getting divison point
        int point=value/num;
        int end; 
        int start=0;
        SortingThread []t=new SortingThread[num];
        
        
        //array to hold the position
        int []startPos=new int[num];
        int []endPos=new int[num];
        
             
        //first part of sort
        for(int i=0;i<num;i++){
            
            //to get every number due to integer division take place
            if(i==num-1){
                end=start+point+value%num;
            }
            else{
                end=start+point;
            }
            
            startPos[i]=start;
            endPos[i]=end;
            
            //creating and running thread
            t[i]=new SortingThread(obj,start,end);
 
            //setting new start and end point
            start=end;
           
            //starting each thread
            t[i].start();
        } 
        
        //wait for the thread to end
        for(int i=0;i<num;i++){
            t[i].join();
        }
            
        //merging the sorted chunk of n array
        MergeNArray obj1=new MergeNArray(obj, endPos);
        obj1.merge();
        
        obj.display(value,0);
        long endTime=System.nanoTime();
        long totalTime=endTime-startTime;
        System.out.println("\n total time : "+ totalTime);
    }
}
        
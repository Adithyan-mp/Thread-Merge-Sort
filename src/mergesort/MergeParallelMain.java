
package mergesort;


public class MergeParallelMain {
    public static void main(String args[]) throws InterruptedException {
        int value=Array.getValue();
        Array obj = new Array(value);
        
        //take value of how many  thread to create 
        int num=Array.getNumber();
        
        //getting divison point
        int point=value/num;
        int end; 
        int start=0;
        SortingThread []t=new SortingThread[num];
        MergingThread t2;
        
        
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
        //create THREAD to merge the merge array
        MergingThread []mergeThread;
        int mergeArray=num-1;
        mergeThread=new MergingThread[mergeArray];
        
        //merging chunkz of sorted sub arrray
        for(int i=0;i<mergeArray;i++){
            int mid=(startPos[i]+endPos[i])/2;
//            System.out.println("mid : "+endPos[i]+" start :" +0+" end : "+endPos[i+1]);
            mergeThread[i]=new MergingThread(obj,0,endPos[i],endPos[i+1]);
            mergeThread[i].start();
        }
        
        
        for(int i=0;i<mergeArray;i++){
            mergeThread[i].join();
        }
        obj.display(value,0);
    }
}
        
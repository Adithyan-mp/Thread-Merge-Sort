package mergesort;



 class SortingThread extends Thread{
     Array obj;
     int end;
     int start;
     public SortingThread(Array obj,int start,int end){
         this.obj=obj;
         this.end=end;
         this.start=start;
     }
    @Override
    public void run(){
             MergeSort obj1=new MergeSort();
            obj1.mergesort(obj.arr, start, end-1);
    }  
}


package mergesort;


public class MergingThread extends Thread{
     Array obj;
     int start;
     int end;
     int mid;
     public MergingThread(Array obj,int start,int mid,int end){
         this.obj=obj;
         this.start=start;
         this.end=end;
         this.mid=mid;
     }
    @Override
    public void run(){
        synchronized (obj) {
            MergeSort obj1=new MergeSort();
            obj1.merge(obj.arr, start,mid-1, end-1);
        }
     


}
}

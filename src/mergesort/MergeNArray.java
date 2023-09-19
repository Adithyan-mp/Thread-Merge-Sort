
package mergesort;

 class MergeNArray {
     int p[];//pointer array 
     Array obj;//orginal array
     int checkp[];//to check pointer satisfied condition or not

    public MergeNArray(Array obj,int endPos[]) {
        this.checkp=endPos;
        this.p=new int[endPos.length+1]; //the valid position to merge sort
        this.obj=obj; //array
        p[0]=0;
        for(int i=0;i<endPos.length;i++){
            p[i+1]=endPos[i];
        }
    }
        public void merge(){
            int length=p.length;
            int length2=p.length;
            int newarr[]=new int[obj.length()];
            int k=0;
            int count=0;
            while(count<length2-2){
                
                //base condition
                for(int i=0;i<length-1;i++){
                   if(p[i]==checkp[i]){
                       count++;
                       for(int j=i;j<length-1;j++){
                           p[j]=p[j+1];
                           if(j<checkp.length-1){
                               checkp[j]=checkp[j+1];
                           }
                       }
                       length--;
                   }
                }
             
   
                //geting minimum value
                int min=obj.arr[p[0]];
                int min_idx=0;
                for(int i=1;i<length-1;i++){
                   if(min>obj.arr[p[i]]){
                       min=obj.arr[p[i]];
                       min_idx=i;
                   }
                }
                
                //adding value and updating index

                newarr[k]=min;
                p[min_idx]++;
                k++;
                
            }
            
            //copiying remaining to array
            while(p[0]<checkp[0]){
                newarr[k]=obj.arr[p[0]];
                p[0]++;
                k++;
            }
            
            //updating the orginal array
            obj.arr=newarr;
        }
     
}

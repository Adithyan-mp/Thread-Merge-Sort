
package mergesort;

import java.util.Scanner;

 class Array {
    public int arr[];
    int count;
    Array(){}
    
    
    Array(int num){
         arr=new int[num];
         count=num;
         for(int i=0;i<num;i++){
           arr[i]=count;
           count--;
        }
     }   

    void display(int num,int s){
            int n = num;
            for (int i = s; i < n; ++i){
              System.out.print(arr[i] + " ");
              if(n%1000==0){
                  System.out.println();
              }
            
            }
    }
    
    static int getNumber(){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the Number of Thread to create : ");
        int num=sc.nextInt();
        return num;
    }
    
    static int getValue(){
         Scanner sc =new Scanner(System.in);
        System.out.print("Enter the range of number to sort : ");
        int value=sc.nextInt();
        return value;
    } 
    public int length() {
        return arr.length;
    }
}

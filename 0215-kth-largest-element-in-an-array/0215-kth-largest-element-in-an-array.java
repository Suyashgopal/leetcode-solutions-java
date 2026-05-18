class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n= nums.length;
int[] max= new int[n];        
        //insetion
        for(int i=0;i<n;i++){
            max[i]= nums[i];
             upheap(max, i);
        }
  int size= n-1;

    // poping k-1 times
    for (int i=0;i<k-1;i++){
        swap(max, 0, size);
        size--;
        downheap(max, size);
    }

         return max[0];

    }

    public void upheap(int [] al, int idx){
      int i= idx;
      while(i>0){
        int parent=(i-1)/2;
        if(al[i]> al[parent] ){
            swap(al,i, parent);
        }
        i= parent;
      }
    }
    public void swap(int [] arr, int a , int b){
        int temp= arr[a];
        arr[a]= arr[b];
        arr[b]= temp;

    }
    
    public void downheap(int [] arr,int size){
        int n= size+1;
        int i=0;
        while(i<n/2){
            int min=i;
            int left = (2*i)+1;
            int right= (2*i) +2;
            if (left<= size && arr[min]<arr[left]){
                min= left;
            }
             if (right<= size && arr[min]<arr[right]){
                min= right;
            }
            if(min==i){
                break;
            }
            if(min!= i){
             swap(arr, i, min);
            }
            i= min;
          
        }
    }



}
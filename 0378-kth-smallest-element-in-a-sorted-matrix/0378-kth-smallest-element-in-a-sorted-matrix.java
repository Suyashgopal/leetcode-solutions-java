class Solution {
    public int kthSmallest(int[][] m, int k) {
        int n = m.length;
        int size = n * n ;

        int total = n*n;
        for(int i= (total/2)-1;i>=0;i--){
            downheap(m,i, total,n);
        }

        for (int i = 0; i < k - 1; i++) {
            swap(m, 0, size-1, n);
            size--;
            downheap(m, 0,size, n);


        }
        return m[0][0];
    }
    
    
    void downheap(int [][] m, int i ,int size , int n){
        int leaf= size/2;
        int lr= leaf/n;
        int lc= leaf%n;
        while(i<leaf){
            int min =i;
            int left= (i*2)+1;
            int right = (i*2)+2;

            int mr=min/n;
            int mc=min%n;
            int leftr= left/n;
            int leftc= left%n;
            int rightr= right/n;
            int rightc= right%n;

            if(left<size && m[mr][mc]>m[leftr][leftc]){
                min= left;
            }
            if(right< size){
                 mr=min/n;
             mc=min%n;
             if( m[mr][mc]> m[rightr][rightc]){
                 min= right;
              }
               
            }
            if(min!=i){
                swap(m,i,min, n);
            }
            else{break;}
            i=min;


        }

    }
        
void swap(int [][] m, int a, int b, int n){
    int ar= a/n;
    int ac= a%n;
    int br= b/n;
    int bc= b%n;

    int temp= m[ar][ac];
    m[ar][ac]= m[br][bc];
    m[br][bc]=temp;
}

}
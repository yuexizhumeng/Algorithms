import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Heapsort {
    protected int[] array;
    private Random r=new Random();
    public Heapsort(int n){
        array=new int[n];
        for(int i=0;i<array.length;i++)
            array[i]=r.nextInt(10);
    }
	
    public void Max_Heapify(int i,int heap_size){
            int l=2*i;
            int r=2*i+1;
            int largest,temp;
         
            if((l<=heap_size)&&(array[l-1]>array[i-1]))
                largest=l;
            else largest=i;
            if((r<=heap_size)&&(array[r-1]>array[largest-1]))
                largest=r;
            if(largest!=i)
            {
                temp=array[i-1];
                array[i-1]=array[largest-1];
                array[largest-1]=temp;
                Max_Heapify(largest,heap_size);
            }
        }
        
    public void Build_Max_Heap(int heap_size){
            for(int i=array.length/2;i>0;i--)
                Max_Heapify(i,array.length);
        }
        
    public void HeapSort(){
            int heap_size=array.length;
            int temp;
            Build_Max_Heap(heap_size);
            for(int i=array.length;i>1;i--){
                temp=array[0];
                array[0]=array[i-1];
                array[i-1]=temp;
                heap_size--;
                Max_Heapify(1,heap_size);
            }
        }

    public static void main(String[] args) throws IOException{
        Timer tt=new Timer();
        double[] timer=new double[5];
        Heapsort h;
        System.out.print("Please input the number of elements in array is: ");
	      BufferedReader br=null;
	      br=new BufferedReader(new InputStreamReader(System.in));
	      int n=Integer.parseInt(br.readLine());

        for(int i=0;i<5;i++){
            h=new Heapsort(n);
            System.out.println("\nThe original array is:");
            for(int j=0;j<15;j++)
                System.out.print(h.array[j]+" ");
            tt.start();
            h.HeapSort();
            tt.stop();
            timer[i]=tt.getTime();
            System.out.println("\nThe array after HeapSort(500-535):");
            for(int j=500;j<535;j++)
                System.out.print(h.array[j]+" ");
            System.out.println("\nThe running time is "+timer[i]+"s");
        }
        double sum = 0;
        for(int i=0;i<5;i++){
            sum+=timer[i];
        }
        System.out.println("\nThe average runtime of HeapSort is "+sum/5);
    }
}

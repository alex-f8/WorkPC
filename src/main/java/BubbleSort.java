public class BubbleSort {
    public static void main(String[] args) {
        long start;
        long stop;
        int tmp;


        // I variant
        int[] arr1 = {45, 25, 255, 78, 1, 22, 6525, 64, 37, 96, 11, 55};
        for(int k : arr1)
            System.out.printf("%d ", k);
        System.out.println();
        start = System.nanoTime();
       for(int i = 0; i < arr1.length - 1 ; /*i++*/ ){
            if(arr1[i] > arr1[i+1]){
                tmp = arr1[i+1];
                arr1[i+1] = arr1[i];
                arr1[i]  = tmp;
                i = 0;
            }
           else i++;
        }
       stop = System.nanoTime();
        System.out.println("code run time: " + (stop - start));
        for(int k : arr1)
            System.out.printf("%d ", k);
        System.out.println();


        tmp = 0;
        System.out.println();


        // II variant
        int[] arr2 = {45, 25, 255, 78, 1, 22, 6525, 64, 37, 96, 11, 55};
        for(int k : arr2)
            System.out.printf("%d ", k);
        start = System.nanoTime();
        for(int i = 0; i < arr2.length - 1 ; i++){
            for(int k = i + 1; k < arr2.length; k++){
                if(arr2[i] > arr2[k]){
                    tmp = arr2[i];
                    arr2[i] = arr2[k];
                    arr2[k] = tmp;
                }
            }
        }
        stop = System.nanoTime();
        System.out.println("\ncode run time: " + (stop - start));
        for(int k : arr2)
            System.out.printf("%d ", k);

    }
}

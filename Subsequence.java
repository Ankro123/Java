public class Subsequence {
    static int flag = 0;
    static int q = 0;

    public static int sub(int[] arr, int i, int j, int size, int gap) {

        if (j >= size && i < j - gap - 1) {
            while (true) {
                for (int l = i; l < j; l = l + gap + 1) {
                    if (gap > 1 && flag == 0 && j - i > gap * 2) {
                        System.out.print(Integer.toString(arr[l]) + Integer.toString(arr[l + gap]));
                        System.out.println();
                        flag = 1;
                    }
                    System.out.print(arr[l]);

                }
                flag = 0;
                if (j - i - 1 > gap + 1) {

                    System.out.println();
                    gap += 1;
                } else {
                    break;
                }
            }
            System.out.println();

        }

        for (int k = i; k < j; k++) {
            System.out.print(arr[k]);
        }

        if (i < size) {
            if (j < size) {
                
                if (q == i){
                    q++;
                }
                else{
                    System.out.println();
                }
                sub(arr, i, j + 1, size, 1);

            } else {

                sub(arr, i + 1, i, size, 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        
        int[] array = { 3, 1, 2, 8, 7, 3, 1, 5};    
        sub(array, 0, 0, 8, 1);

    }
}

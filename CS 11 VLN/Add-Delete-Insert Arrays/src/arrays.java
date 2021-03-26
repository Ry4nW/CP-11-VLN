import java.util.Arrays;

public class arrays {

   public static int[] addIntArr(int[] arr, int add) {
       arr = Arrays.copyOf(arr, arr.length + 1);
       arr[arr.length - 1] = add;
       return arr;
   }

   public static int[] popIntArr(int[] a) {
       return Arrays.copyOf(a, a.length - 1);
   }

   public static int[] insertIntArr(int[] arr, int value, int index) {
       int[] arr2 = Arrays.copyOf(arr, arr.length + 1);
       for (int i = 0; i < arr2.length; i++) {
           if (i == index) {
               for (int j = arr2.length - 2, t = 1; j >= i; j--, t++) {
                   arr2[arr2.length - t] = arr2[j];
               }
               arr2[i] = value;
               break;
           }
       }
       return arr2;
   }

    public static void main(String[] args) {
        int[] array = { 2, 4, 6 };
        System.out.println(Arrays.toString(addIntArr(array, 8)));
        System.out.println(Arrays.toString(popIntArr(array)));
        System.out.println(Arrays.toString(insertIntArr(array, 1, 0)));
    }
}

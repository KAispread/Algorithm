package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] test = new int[] {9,2,1,5,9,1,4,10,8,31,0};

        QuickSortComponent.quickSort(test);

        for (int number : test) {
            System.out.print(number + " ");
        }
    }

    static class QuickSortComponent {
        public static void quickSort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
        }

        private static void quickSort(int[] arr, int start, int end) {
            int partitionedIdx = partition(arr, start, end);

            if (start < partitionedIdx - 1) {
                quickSort(arr, start, partitionedIdx - 1);
            }
            if (end > partitionedIdx) {
                quickSort(arr, partitionedIdx, end);
            }
        }

        private static int partition(int[] arr, int start, int end) {
            int pivot = arr[(start + end) / 2];

            while (start <= end) {
                while (arr[start] < pivot) start++;
                while (arr[end] > pivot) end--;
                if (start <= end) {
                    swap(arr, start, end);
                    start++;
                    end--;
                }
            }

            return start;
        }

        private static void swap(int[] arr, int start, int end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
}

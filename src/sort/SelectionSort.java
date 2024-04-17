package sort;

import sort.MergeSort.MergeSortComponent;

public class SelectionSort {

    public static void main(String[] args) {
        int[] test = new int[] {9,2,1,5,9,1,4,10,8,31,0};

        SelectionSortComponent.selectionSort(test);

        for (int number : test) {
            System.out.print(number + " ");
        }
    }

    static class SelectionSortComponent {
        public static void selectionSort(int[] arr) {
            selectionSort(arr, 0);
        }

        private static void selectionSort(int[] arr, int start) {
            if (start >= arr.length) return;

            int minIndex = start;
            for (int i = start; i < arr.length; i++) {
                if (arr[i] < arr[minIndex]) minIndex = i;
            }

            swap(arr, start, minIndex);
            selectionSort(arr, start + 1);
        }

        private static void swap(int[] arr, int index1, int index2) {
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }
}

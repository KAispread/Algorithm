package sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] test = new int[] {9,2,1,5,9,1,4,10,8,31,0};

        MergeSortComponent.mergeSort(test);

        for (int number : test) {
            System.out.print(number + " ");
        }
    }

    static class MergeSortComponent {
        public static void mergeSort(int[] arr) {
            int[] tmp = new int[arr.length];
            mergeSort(arr, tmp, 0, arr.length - 1);
        }

        private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
            if (start < end) {
                int mid = (start + end) / 2;
                mergeSort(arr, tmp, start, mid);
                mergeSort(arr, tmp, mid+1, end);
                merge(arr, tmp, start, mid, end);
            }
        }

        private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
            for (int i = start; i < tmp.length; i++) {
                tmp[i] = arr[i];
            }

            int part1 = start;
            int part2 = mid + 1;
            int index = start;

            while (part1 <= mid && part2 <= end) {
                if (tmp[part1] <= tmp[part2]) {
                    arr[index] = tmp[part1];
                    part1++;
                } else {
                    arr[index] = tmp[part2];
                    part2++;
                }
                index++;
            }

            for (int i = 0; i <= mid - part1; i++) {
                arr[index+i] = tmp[part1+i];
            }
        }
    }
}

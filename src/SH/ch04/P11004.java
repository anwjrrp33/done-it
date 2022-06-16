package SH.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004 { // 퀵 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);
    }

    public static void quickSort(int[] A, int S, int E, int K) {
        if (S < E) {
            int pivot = partition(A, S, E);
            if(pivot == K) {
                return;
            } else if(K < pivot) {
                quickSort(A, S, pivot - 1, K);
            } else {
                quickSort(A, pivot + 1, E, K);
            }
        }
    }

    public static int partition(int[] A, int S, int E) {
        int M = (S + E) / 2;
        swap(A, S, M);
        int pivot = A[S];
        int i = S, j = E;
        while (i < j) {
            while (pivot < A[j]) {
                j--;
            }
            while (i < j && pivot >= A[i]) {
                i++;
            }
            swap(A, i, j);
        }
        A[S] = A[i];
        A[i] = pivot;
        return i;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /*public static void main(String[] args) {
        int[] arrs = { 69, 10, 30, 2, 16, 8, 31, 22 };
        quickSort(arrs, 0, arrs.length - 1);
        for (int i : arrs) {
            System.out.print(i + " ");
        }
    }
    public static int partition(int arr[], int left, int right) {

        int pivot = arr[(left + right) / 2];

        while (left < right) {
            while ((arr[left] < pivot) && (left < right))
                left++;
            while ((arr[right] > pivot) && (left < right))
                right--;

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        return left;
    }

    public static void quickSort(int arr[], int left, int right) {

        if (left < right) {
            int pivotNewIndex = partition(arr, left, right);

            quickSort(arr, left, pivotNewIndex - 1);
            quickSort(arr, pivotNewIndex + 1, right);
        }
    }*/
/*    public static void main(String[] args) {
        int[] A = { 4, 1, 2, 3, 5 };

        quickSort(A, 0, A.length - 1);

        for (int n: A) {
            System.out.print(n + " ");
        }
    }

    public static void quickSort(int[] A, int start, int end) {
        if(start >= end) return;

        int pivot = (start + end) / 2;
        int left = start;
        int right = end;

        while(left <= right) {
            while(A[left] < A[pivot]) left++;
            while(A[pivot] < A[right]) right--;

            if(left <= right) {
                swap(A, left, right);
                left++;
                right--;
            }
        }

        quickSort(A, start, right);
        quickSort(A, left, end);
    }

    public static void swap(int[] A, int left, int right) {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }*/

//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        int[] A = new int[N];
//
//        st = new StringTokenizer(bf.readLine());
//
//        for(int i = 0; i < N; i++) {
//            A[i] = Integer.parseInt(st.nextToken());
//        }
//
//        quickSort(A, 0, N - 1);
//
//        System.out.println(A[K - 1]);

/*        int[] A = { 4, 1, 2, 3, 5};
        quickSort(A, 0, A.length - 1);
        for (int n: A) {
            System.out.print(n + " ");
        }
    }

    public static void quickSort(int[] A, int start, int end) {
        if(start >= end) { return; }

        int pivot = (start + end) / 2;
        int left = start;
        int right = end;

        while(left <= right) {
            while(A[left] < A[pivot] && left < end) {
                left++;
            }
            while(A[right] > A[pivot] && right > start) {
                right--;
            }
            if(left > right) {
                int temp = A[right];
                A[right] = A[start];
                A[start] = temp;
            } else {
                int temp = A[right];
                A[right] = A[left];
                A[left] = temp;
            }
        }
        quickSort(A, start, left - 1);
        quickSort(A, left + 1, end);
    }*/
}

package SH.ch04;

import java.io.*;
import java.util.Scanner;

public class Quiz020 { // 병합 정렬
    // 백준 2751번 - 수 정렬하기2
    public static int[] A, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        tmp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        merget_sort(1, N); // 병합정렬 수행하기
        for (int i = 1; i <= N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void merget_sort(int s, int e) {
        if (e - s < 1)
            return;
        int m = s + (e - s) / 2;
        // 재귀함수 형태로 구현
        merget_sort(s, m);
        merget_sort(m + 1, e);
        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while (index1 <= m && index2 <= e) { // 두 그룹을 Merge 해주는 로직
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        // 한쪽 그룹이 모두 선택된 후 남아있는 값 정리하기
        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//        int[] A = new int[N];
//        int[] T = new int[N];
//
//        for(int i = 0; i < N; i++) {
//            A[i] = sc.nextInt();
//        }
//
//        mergeSort(A, 0, N - 1, T);
//
//        for(int i = 0; i < N; i++) {
//            System.out.println(A[i]);
//        }
//    }
//
//    private static void mergeSort(int[] A, int start, int end, int[] T) {
//        if(start == end) return;
//
//        int mid = (start + end) / 2;
//        mergeSort(A, 0, mid, T);
//        mergeSort(A, mid + 1, end, T);
//
//        int left = start;
//        int right = mid + 1;
//        int index = left;
//
//        while(left <= mid && right <= end) {
//            if(A[left] <= A[right]) {
//                T[index++] = A[left++];
//            } else {
//                T[index++] = A[right++];
//            }
//        }
//
//        if(left > mid) {
//            while(right <= end) {
//                T[index++] = A[right++];
//            }
//        } else {
//            while(left <= mid) {
//                T[index++] = A[left++];
//            }
//        }
//
//        for(int i = start; i <= end; i++) {
//            A[i] = T[i];
//        }
//    }

//    public static void main(String[] args) {
//        int[] arr = { 8, 2, 6, 4, 7, 3, 9, 5 };
//
//        mergeSort(arr, 0, arr.length - 1);
//
//        printArray(arr);
//    }
//
//    private static int[] tmp = new int[8];
//    private static void mergeSort(int[] arr, int start, int end) {
//        if(start == end) return;
//
//        int mid = (start + end) / 2;
//        mergeSort(arr, start, mid);
//        mergeSort(arr, mid + 1, end);
//
//        int left = start;
//        int right = mid + 1;
//        int index = left;
//
//        while(left <= mid && right <= end) {
//            if(arr[left] <= arr[right]) {
//                tmp[index++] = arr[left++];
//            } else {
//                tmp[index++] = arr[right++];
//            }
//        }
//
//        if(left > mid) {
//            while(right <= end) {
//                tmp[index++] = arr[right++];
//            }
//        } else {
//            while(left <= mid) {
//                tmp[index++] = arr[left++];
//            }
//        }
//
//        for(int i = start; i <= end; i++) {
//            arr[i] = tmp[i];
//        }
//    }
//    private static void printArray(int[] arr) {
//        for (int n: arr) {
//            System.out.print(n + " ");
//        }
//        System.out.println("");
//    }
}

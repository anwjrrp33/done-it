package SH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N - 1);

        System.out.println(A[K - 1]);
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
    }
}

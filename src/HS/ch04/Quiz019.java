package HS.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 11004 K번째 수 구하기
public class Quiz019 {
    public static void main(String[] args) throws IOException {
        // 5 2
        // 4 1 2 3 5
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int pivotIndex = k;

        sort(arr, pivotIndex);

        System.out.println(Arrays.toString(arr));

    }

    public static int sort(int[] arr, int pivotIndex) {

        if (arr.length <= 1) return 0;

        int startIndex = 0;
        int endIndex = arr.length - 1;
        int meetIndex = 0;

        for (int i = 0; i < pivotIndex - 1; i++) {
            boolean isBiggerStart = false;
            boolean isSmallerEnd = false;
            if (arr[startIndex] > arr[pivotIndex]) {
                // s < p이면 1칸 이동
                startIndex++;
                isBiggerStart = true;
            }
            if (arr[endIndex] > arr[pivotIndex]) {
                // e > p이면 1칸 이동
                endIndex--;
                isSmallerEnd = true;
            }
            if (!isBiggerStart
                    &&
                    !isSmallerEnd) {
                // swap
                // s > p이고, e < p이면 swap
                int temp = arr[endIndex];
                arr[endIndex] = arr[startIndex];
                arr[startIndex] = temp;
            }

            if (startIndex >= endIndex) {
                meetIndex = startIndex;
                break;
            }
        }

        if (arr[meetIndex] < arr[pivotIndex]) {
            // meetIndex 오른쪽에 pivot 삽입.
            arr[meetIndex + 1] = arr[pivotIndex];
            for (int i = pivotIndex; i > meetIndex + 1; i--) {
                arr[i] = arr[i-1];
            }

        } else {
            // meetIndex 왼쪽에 pivot 삽입.
            arr[meetIndex - 1] = arr[pivotIndex];
            for (int i = pivotIndex; i > meetIndex; i--) {
                arr[i] = arr[i-1];
            }
        }
        return 0;
    }

}

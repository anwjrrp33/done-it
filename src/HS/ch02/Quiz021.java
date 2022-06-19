package HS.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1517 버블 소트 프로그램2
// 시간초과 뜨긴 하는데 일단 통과
public class Quiz021 {
    // 시간제한 1초
    // n의 최대 범위 1,000,000이므로
    // O(nlogn)의 시간 복잡도로 정렬을 수행해야.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        temp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st. nextToken());// Integer.parseInt(br.readLine());
        }

        sort(arr, 0, n-1);

        System.out.println(result);

    }

    public static int[] temp;
    public static int result;

    public static void sort(int[] arr, int start, int end) {

        if (start >= end) return;

        int mid = (start + end) / 2;

        sort(arr, start, mid);
        sort(arr, mid+1, end);

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        mergeSort(arr, start, mid, end);
    }

    public static void mergeSort(int[] arr, int start, int mid, int end) {
        int resultIndex = start;
        int lowStart = start;
        int highStart = mid + 1;

        while(lowStart <= mid && highStart <= end) {
            if (temp[lowStart] < temp[highStart]) {

                arr[resultIndex++] = temp[lowStart++];

            } else {
                result += highStart - resultIndex;
                arr[resultIndex++] = temp[highStart++];
            }
        }

        while(lowStart <= mid) {
            arr[resultIndex++] = temp[lowStart++];
        }
    }

}

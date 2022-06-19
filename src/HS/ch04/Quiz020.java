package HS.ch04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 백준 2751 수 정렬하기2
// 맞았는데 아리까리함
public class Quiz020 {
    // 시간제한 2초
//    public static int[] A, tmp;
//    public static long result;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int N = Integer.parseInt(br.readLine());
//
//        A = new int[N + 1];
//        tmp = new int[N + 1];
//
//        for (int i = 1; i <= N; i++) {
//            A[i] = Integer.parseInt(br.readLine());
//        }
//
//        merget_sort(1, N); // 병합 정렬 수행하기
//
//        for (int i = 1; i <= N; i++) {
//            bw.write(A[i] + "\n");
//        }
//        bw.flush();
//        bw.close();
//    }
//
//    private static void merget_sort(int s, int e) {
//        if (e - s < 1) return;
//        int m = s + (e - s) / 2;
//        // 재귀 함수 형태로 구현
//        merget_sort(s, m);
//        merget_sort(m + 1, e);
//
//        for (int i = s; i <= e; i++) {
//            tmp[i] = A[i];
//        }
//
//        int k = s;
//        int index1 = s;
//        int index2 = m + 1;
//
//        while (index1 <= m && index2 <= e) {
//            // 두 그룹을 병합하는 로직
//            // 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고,
//            // 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동하기
//            if (tmp[index1] > tmp[index2]) {
//                A[k] = tmp[index2];
//                k++;
//                index2++;
//            } else {
//                A[k] = tmp[index1];
//                k++;
//                index1++;
//            }
//        }
//
//        while (index1 <= m) { // 한쪽 그룹이 모두 선택된 후 남아 있는 값 정리하기
//            A[k] = tmp[index1];
//            k++;
//            index1++;
//        }
//
//        while (index2 <= e) {
//            A[k] = tmp[index2];
//            k++;
//            index2++;
//        }
//    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt (br.readLine());
        }
        temp = new int[n];
        sort(arr, 0, n-1);

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int[] temp;

    public static void sort(int[] arr, int start, int end) {
        if (start < end) {

            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);

            for (int i = start; i <= end; i++) {
                temp[i] = arr[i];
            }

            mergeSort(arr, start, mid, end);

        }
    }

    public static void mergeSort(int[] arr, int start, int mid, int end) {

        int t = start, s = start, e = mid + 1;



        while (s <= mid && e <= end) {
            if (temp[s] < temp[e]) {
                arr[t++] = temp[s++];
            } else {
                arr[t++] = temp[e++];
            }

        }

        while(s <= mid) {
            arr[t++] = temp[s++];
        }

    }

}


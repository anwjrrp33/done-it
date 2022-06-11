package HS.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준 1377 버블 소트 프로그램1
// 정답보고함
// 이해안감
public class Quiz016 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        mData[] arr = new mData[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new mData(Integer.parseInt(reader.readLine()), i);
        }
        Arrays.sort(arr);
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < arr[i].index - i)
                // 정렬 전 index - 정렬 후 index 계산의 최댓값 저장하기
                max = arr[i].index - i;
        }
        System.out.println(max+1);
    }
}

class mData implements Comparable<mData> {
    int value;
    int index;

    public mData(int value, int index) {
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o) {
        return this.value - o.value;
    }
}

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        int[] arr = new int[n+1];
//
//        for (int i = 1; i <= n; i++) {
//            arr[i] = sc.nextInt();
//        }
//
//        boolean change;
//
//        for (int i = 1; i <= n+1; i++) {
//            change = false;
//            for (int j = 1; j <= n-i; j++) {
//                if (arr[j+1] > arr[j]) {
//                    change = true;
//                    int temp = arr[j+1];
//                    arr[j+1] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//            if (!change) {
//                System.out.println(i);
//                break;
//            }
//        }
//    }

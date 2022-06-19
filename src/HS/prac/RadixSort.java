package HS.prac;

import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {28, 93, 39, 81, 62, 72, 38, 26};

        radixSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void radixSort(int[] arr) {
        // 최대값 구하기
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }

        // Counting Sort를 사용하여 해당 자리를 정렬하기
        for (int digit = 1; digit <= max; digit *= 10) {
            countingSort(arr, digit);
        }
    }
    
    public static void countingSort(int[] arr, int digit) {
        int[] temp = new int[arr.length]; // 임시로 사용할 공간
        int[] counting = new int[10]; // 카운팅 배열

        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] / digit) % 10; // 해당 자리수의 숫자 추출
            counting[num]++;
        }
        
        // 누적합 배열로 만들기
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        // 뒤에서부터 시작 >> 값이 큰 것이 뒤로 가야하기 때문
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] / digit) % 10;
            int index = counting[num];

            temp[index - 1] = arr[i];
            counting[num]--;
        }

        // 복사
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        //??
    }
}

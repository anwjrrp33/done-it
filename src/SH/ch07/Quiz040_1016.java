package SH.ch07;

import java.util.Scanner;

public class Quiz040_1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long Min = sc.nextLong();
        long Max = sc.nextLong();
        boolean[] Check = new boolean[(int) (Max - Min + 1)];

        for (long i = 2; i * i <= Max; i++) {
            long pow = i * i; // 제곱수
            long start_index = Min / pow;

            if (Min % pow != 0) {
                start_index++; // 나머지가 있으면 1을 더해야 Min보다 큰 제곱수에서 시작된다.
            }
            for (long j = start_index; pow * j <= Max; j++) { // 제곱수를 true로 변경하기
                Check[(int) ((j * pow) - Min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i <= Max - Min; i++) {
            if (!Check[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}

package SH.ch02;

import java.io.BufferedReader;
import java.util.*;

public class Quiz014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);

            if (first == second) {
                return o1 > o2 ? 1 : -1;
            } else {
                return first - second;
            }
        });

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < N; i++) {
            int request = sc.nextInt();

            if (request == 0) {
                if (queue.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(queue.poll() + "\n");
                }
            } else {
                queue.add(request);
            }
        }

        System.out.println(sb.toString());
    }
}
    // 백준-11286-절대값 힙 구현하기
    // 시간 초과남
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//         int N = sc.nextInt();
//
//        StringBuffer sb = new StringBuffer();
//        List<Integer> list = new ArrayList<>();
//        for(int i = 0; i < N; i++) {
//            int M = sc.nextInt();
//
//            if(M == 0) {
//                Collections.sort(list, new Comparator<Integer>() {
//                    @Override
//                    public int compare(Integer o1, Integer o2) {
//                        if(Math.abs(o1) < Math.abs(o2)) {
//                            return -1;
//                        } else if(Math.abs(o1) > Math.abs(o2)) {
//                            return 1;
//                        } else if(Math.abs(o1) == Math.abs(o2)) {
//                            if(o1 < o2) {
//                                return -1;
//                            } else if(o1 > o2) {
//                                return 1;
//                            }
//                        }
//                        return 0;
//                    }
//                });
//                if(list.size() == 0) {
//                    sb.append("0\n");
//                } else {
//                    sb.append(list.get(0) + "\n");
//                    list.remove(0);
//                }
//            } else {
//                list.add(M);
//            }
//        }
//
//        System.out.println(sb.toString());
//    }
// }

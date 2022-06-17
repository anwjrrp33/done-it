package HS.prac;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort1 {

    public static void main(String[] args) {

    }

    public static List<Integer> quickSort(List<Integer> list) {
        if (list.size() <= 1) return list;
        int pivot = list.get(list.size() / 2);

        List<Integer> lesserArr = new LinkedList<>();
        List<Integer> equalArr = new LinkedList<>();
        List<Integer> greaterArr = new LinkedList<>();

        for (int num : list) {
            if (num < pivot) lesserArr.add(num);
            else if (num > pivot) greaterArr.add(num);
            else equalArr.add(num);
        }

        return Stream.of(quickSort(lesserArr), equalArr, quickSort(greaterArr))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
    // 위는 간결하고 이해하기 쉽지만 매번 재귀 호출될 때마다 새로운
    // 리스트를 생성하여 리턴이기 때문ㅇ ㅔ메모리 사용측면에서 비효율적.
    // 따라서 위 정렬보다는 추가 메모리 사용이 적은 in-place 정렬이 선호된다.



}

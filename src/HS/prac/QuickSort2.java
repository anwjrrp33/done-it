package HS.prac;

public class QuickSort2 {
    /**
     * 메인함수인 quickSort()는 크게
     * sort()와 partition() 2개의 내부 함수로 나눠진다.
     * */
    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * sort()는 재귀함수이며 정렬범위를 시작 인덱스와 끝 인덱스로
     * 인자로 받는다. (둘다 inclusive)
     * */
    private static void sort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = partition(arr, low, high);
        sort(arr, low, mid - 1);
        sort(arr, low, high);
    }

    /**
     * partition()은 정렬 범위를 인자로 받으며 다음 로직을 따라
     * 좌우측의 값들을 정렬하고 분할 기준점의 인덱스를 리턴한다.
     * 이 분할 기준점(mid)는 sort()를 재귀적으로 호출할 때
     * 우측 리스트의 시작 인덱스로 사용된다.
     * */
    private static int partition(int[] arr, int low, int high) {
        // 1. 리스트의 정 가운데 있는 값을 pivot값으로 선택
        int pivot = arr[(low+high) / 2];
        // 2. 시작 인덱스 low는 계속 증가시키고,
        //    끝 인덱스 high는 계속 감소시키기 위한
        //    while루프를 두 인덱스가 서로 교차해서 지나칠 떄까지
        //    반복시킨다.
        while (low <= high) {
            // 3. 시작 인덱스 low가 가리키는 값과 pivot 값을 비교해
            //    더 작은 경우 반복해서 시작인덱스 값을 증가시킴.
            //    (pivot값보다 큰데 좌측에 있는 값을 찾기 위해)
            while (arr[low] < pivot) low++;
            // 4. 끝 인덱스 high가 가리키는 값과 pivot 값을 비교해
            //    더 큰 경우 반복해서 끝 인덱스 값을 감소시킴.
            //    (pivot값보다 작은데 우측에 있는 값을 찾기 위해)
            while (arr[high] > pivot) high --;
            if (low <= high) {
                // 두 인덱스가 아직 서로 교차해서 지나치지 않았다면
                // 시작 인덱스 low가 가리키는 값과 끝 인덱스 high가
                // 가리키는 값을 상호 교대 swap 시킨다.
                // (잘못된 위치에 있는 두 값의 위치를 바꾸기 위해)
                swap(arr, low, high);
                // 상호 교대 후, 다음 값을 가리키기 위해 두 인덱스를
                // 각자 진행 방향으로 한 칸씩 이동시킴.
                low++;
                high--;
            }
        }
        // 두 인덱스가 서로 교차해서 지나치게 되어
        // while 루프를 빠져나왔다며 다음 재귀 호출의
        // 분할 기준점이 될 시작 인덱스를 리턴한다.
        return low;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

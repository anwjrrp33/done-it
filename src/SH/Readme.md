https://blog.chulgil.me/algorithm/ 참조

O(1) – 상수 시간 : 문제를 해결하는데 오직 한 단계만 처리함.
O(log n) – 로그 시간 : 문제를 해결하는데 필요한 단계들이 연산마다 특정 요인에 의해 줄어듬.
O(n) – 직선적 시간 : 문제를 해결하기 위한 단계의 수와 입력값 n이 1:1 관계를 가짐.
O(n log n) : 문제를 해결하기 위한 단계의 수가 N*(log2N) 번만큼의 수행시간을 가진다. (선형로그형)
O(n^2) – 2차 시간 : 문제를 해결하기 위한 단계의 수는 입력값 n의 제곱.
O(C^n) – 지수 시간 : 문제를 해결하기 위한 단계의 수는 주어진 상수값 C 의 n 제곱.

```
합 배열 공식
S[i] = S[i - 1] + A[i]

구간 합 공식
S[i] = S[j] - S[i]
```


```
2차원 합 배열 공식
D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j]

2차원 구간 합 공식 
D[i][j] = D[X2][Y1 - 1] + D[X1 - 1][Y2] - D[X1 - 1][Y1 - 1] + A[X2][Y2];
```

```
투 포인터 이동 원칙
sum > N: sum = sum - start_index; start_index++;
sum < N: sum = end_index++; sum = sum + end_index;
sum == N: end_index++; sum = sum + end_index; count++;
```
투 포인터의 핵심은 포인터 2영역 중 한가지를 고정 후 이동 특정 조건에
따라서 영역을 이동. 해당 알고리즘은 NlogN이하로 가능함.

### 03-5 스택과 큐
* 스택
    * 삽입과 삭제연산이 후입선출(LIFO: Last-in First-out)로 이뤄지는 자료구조
    * 깊이 우선 탐색(DFS: Depth First Search), 백트래킹 종류의 코딩 테스트에 효과적
    * 후입선출의 개념은 재귀 함수 알고리즘의 원리와 일맥상통
* 큐
    * 삽입과 삭제 연산이 선입선출(FIFO: First-in First-out)로 이뤄지는 자루구조
    * 너비 우선 탐색(BFS: Breadth First Search)에 자주 사용

## 04 정렬
* 버블
  * 데이터의 인접 요소끼리 비교하고, swap 연산을 수행하며 정렬하는 방식 
* 선택
  * 대상에서 가장 크거나 작은 데이터를 찾아가 선택을 반복하면서 정렬하는 방식 
* 삽입
  * 대상을 선택해 정렬된 영역에서 선택 데이터의 적절한 위치를 찾아 삽입하면서 정렬하는 방식
```
// 삽입 정렬 예제코드
int[] A = { 4, 5, 1, 3, 2 };

for(int i = 1; i < A.length; i++) {
    int n = A[i];
    int j = i - 1;
    while(j >= 0 && n < A[j]) {
        A[j + 1] = A[j];
        j--;
    }
    A[j + 1] = n;
}

for(int n: A) {
    System.out.print(n + " ");
}
```
* 퀵
  * pivot 값을 선정해 해당 값을 기준으로 정렬하는 방식
```
// 퀵 정렬(오른쪽 피벗) 예제코드
public static void main(String[] args) {
    int[] A = { 42, 32, 24, 60, 15, 5, 90, 45 };

    quickSort(A, 0, A.length - 1);

    for(int n: A) {
        System.out.print(n + " ");
    }
}

public static void quickSort(int[] A, int start, int end) {
    if(start >= end) { return; }

    int pivot = end;
    int left = start;
    int right = end - 1;

    while(left <= right) {
        while(A[left] <= A[pivot] && left < end) {
            left++;
        }
        while(A[right] >= A[pivot] && right > start) {
            right--;
        }
        if(left > right) {
            int temp = A[right];
            A[right] = A[start];
            A[start] = temp;
        } else {
            int temp = A[right];
            A[right] = A[left];
            A[left] = temp;
        }
    }
    quickSort(A, start, left - 1);
    quickSort(A, left + 1, end);
}
```
* 병합
  * 이미 정렬된 부분 집합들을 효율적으로 병합해 전체를 정렬하는 방식
* 기수
  * 데이터의 자릿수를 바탕으로 비교해 데이터를 정렬하는 방식

# 05 탐색

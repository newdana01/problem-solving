
## 이진 탐색으로 푸는 법 : O(log n)
- 이진 탐색: 중간값을 확인해 탐색 범위를 절반씩 줄여나감. 반드시 정렬된 데이터여야 하며, 매우 빠름 (O(logn)).

### 다른 탐색 방법 중 왜 이진 탐색인지?
- 해시 탐색은 O(1)로 빠르지만 추가 공간이 필요함
- 배열이 정렬되어 있는 상태임을 이용하지 않는 선형 탐색은 비효율적 

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // (low + high) / 2 시 발생할 수 있는 정수 오버플로우 방지
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid; // 타겟을 찾은 경우 해당 인덱스 반환
            } else if (nums[mid] < target) {
                low = mid + 1; // 타겟이 오른쪽에 있는 경우
            } else {
                high = mid - 1; // 타겟이 왼쪽에 있는 경우
            }
        }

        // 타겟을 찾지 못한 경우, low는 타겟이 삽입되어야 할 적절한 위치를 가리킴
        return low;
    }
}
```

## 정수 오버 플로우
`
mid = (low+high) / 2;
`

이진 탐색에서 `mid` 값을 구하는 방법은 위와 같다. 하지만 이렇게 하면 오버플로우가 생길 수 있다.
Java의 int 자료형은 가질 수 있는 최대값(약 21억)이 정해져 있는데, 배열이 커서 low와 high의 값이 커져버리면 이를 더하는 과정에서 오버플로우가 생기는 것이다.

따라서 이를 우회하는 방법으로 아래처럼 코드를 작성할 수 있다.

`
mid = low + (high - low) / 2;
`
1. high 와 low의 차를 구하고, 그 값을 2로 나눈다.
2. 그 값을 low와 더한다.

high에서 low를 먼저 빼 주기 때문에 오버플로우가 발생하지 않고 안전하게 중간 값을 구할 수 있다. 

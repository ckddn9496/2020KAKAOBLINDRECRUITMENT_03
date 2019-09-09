# 2020KAKAOBLINDRECRUITMENT_03

## 2020 KAKAO BLIND RECRUITMENT 자물쇠 열기
> 아직 문제가 공개되지 않아 문제의 설명이 부족할 수 있습니다.

### 1. 문제설명

input으로 M by M 의 key배열과 N by N lock배열이 들어온다. 값중에서 0은 오목한곳, 1은 볼록한 곳으로 key를 회전 또는 이동시켜 lock과 포갯을 때 모은 영역을 채울수 있다면 true를 return, 그렇지 않다면 false를 return하는 문제. 볼록한 곳과 볼록한 곳은 서로 닿으면 안된다는 조건이 있다.

### 2. 풀이

lock을 중앙에 둔 길이 **2M+N-2** map을 생성한다. 모든 map에 key를 끼워보며, 하나의 맵을 모두 검사했으면 key를 회전시켜 다시 검사한다. 3중 for문으로 구현하였으며 key와 lock을 맞춰보는 행위는 비트연산자 xor를 이용하여 구현하였다.

```java
for (int r = 0; r < 4; r++) {
  for (int i = 0; i < M+N-1; i++) {
      for (int j = 0; j < M+N-1; j++) {
        int[][] temp = new int[2*M+N-2][2*M+N-2];
        for (int a = 0; a < temp.length; a++) 
          for (int b = 0; b < temp.length; b++)
            temp[a][b] = map[a][b];

        for (int row = 0; row < M; row++) {
          for (int col = 0; col < M; col++) {
            temp[i+row][j+col] = temp[i+row][j+col] ^ key[row][col];
          }
        }
        if (checkUnlocked(temp, M, N))
          return true;

      }
    }
  key = rotate(key);
}
```


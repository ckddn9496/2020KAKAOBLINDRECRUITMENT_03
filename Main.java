/* KAKAO 2020 신입 개발자 블라인드 채용
 * 3번
 * */
public class Main {

	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}; // return true

		System.out.println(new Solution().solution(key, lock));
	}
}

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int M = key.length, N = lock.length;

        int[][] map = new int[2*M+N-2][2*M+N-2];
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
            	map[M-1+i][M-1+j] = lock[i][j];
            }
        }
        
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
        
        return answer;
    }
    
	private int[][] rotate(int[][] map) {
		int[][] rotatedMap = new int[map.length][map.length];
		
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map.length; col++) {
				rotatedMap[row][col] = map[col][map.length-row-1];
			}
		}
		return rotatedMap;
	}

	private boolean checkUnlocked(int[][] map, int M, int N) {
		for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
            	if (map[M-1+i][M-1+j] == 0)
            		return false;
            }
        }
		return true;
	}

//	private void printMap(int[][] map) {
//		for (int[] line : map) {
//			for (int i : line) {
//				System.out.print(i+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
//    
}
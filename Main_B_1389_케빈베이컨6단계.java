package restart0827;

import java.util.Scanner;

public class Main_B_1389_케빈베이컨6단계 {
	static int map[][] = new int[101][101];
	static int N, M, ans;
	static int Min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (i != j)
					map[i][j] = 999999;
		for (int j = 0; j < M; j++) {
			int row = sc.nextInt() - 1;
			int col = sc.nextInt() - 1;
			map[row][col] = 1;
			map[col][row] = 1;
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		for (int i = 0; i < N; i++) {
			int temp = 0;
			for (int j = 0; j < N; j++) {
				temp += map[i][j];
			}
			if (Min > temp) {
				Min = temp;
				ans = i;
			}
		}
		System.out.println(ans + 1);
	}
}

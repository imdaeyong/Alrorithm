import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_2206_벽부스고이동하기 {
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int[][] map;
	static int[][] sub_map;
	static int N;
	static int M;
	static Queue<int[]> q = new LinkedList<int[]>();  
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		sub_map = new int[N][M];
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				if(line.charAt(j)-48==1) {						
					map[i][j]=-1;
				}else {
					map[i][j]=0;
				}
			}
		}
		
		int min = 99999;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				//제2의 배열 초기화
				if(map[i][j]==-1) {
					clear();
					sub_map[i][j]=0; //벽 하나만 부수고 이동해봄.
					int nowcnt = move();
					if(nowcnt!=-1 && nowcnt<min){ 
						min=nowcnt;					
					}
				}				
			}
		}
		if(min==99999) System.out.println(-1);
		else System.out.println(min);
	}
	private static void clear() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sub_map[i][j]=map[i][j];				
			}
		}
	}
	private static int move() {
		int cnt=1;
		q.offer(new int[] {0,0});
		int size;
		while (!q.isEmpty()) {
			size = q.size();
			while (size-- > 0) {
				int[] start = q.poll();
				int y = start[0];
				int x = start[1];
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny >= 0 && nx >= 0 && ny < N && nx < M) {
						if (sub_map[ny][nx] == 0) {
							sub_map[ny][nx] = sub_map[y][x]+1;
							q.offer(new int[] { ny, nx });
						}
					}
				}
			}	
			cnt++;
		}
		
		if(sub_map[N-1][M-1]!=0) {			
			return sub_map[N-1][M-1]+1;
		}else {
			return -1;
		}
	}
}

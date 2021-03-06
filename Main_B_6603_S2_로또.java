import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_6603_S2_로또 {
		static int N;
		static int nums[];
		static boolean numcheck[];
		static int lotto[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
	
			nums = new int[N];
			numcheck = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			if(N>5) makeLotto(0,0);
			System.out.println();
			if(N == 0) break;
		}
	}

	private static void makeLotto(int index,int depth) {
		if(depth==6) {
			for(int i=0; i<N;i++){
				if(numcheck[i])	System.out.print(nums[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=index; i<N;i++) {
			numcheck[i] = true;
			makeLotto(i+1,depth+1);
			numcheck[i]=false;
			}
		}
}

package ex;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ex_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			for(int p = 1 ; p < N-i ; p++) {
				bw.write(" ");
			}
			for(int z = 0 ; z < i+1 ; z++) {
			bw.write("*");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

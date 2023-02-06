package Day2;

public class Ex3_연산자 {
	public static void main(String[] args) {

		int x = +10;
		int y = -10;
		System.out.println("x , y /" + x+ ","  + y);

		System.out.println("x++ : " + (x++));
		System.out.println("x : "+ x);
		System.out.println("++x : " + (++x));

		System.out.println("y-- : " + (y--));
		System.out.println("y : " + (y));
		System.out.println("--y : " + (--y));


		System.out.println("x+y=" + (x+y));
		System.out.println("x-y="+ (x-y));
		System.out.println("x*y="+ (x*y));
		System.out.println("5/3="+ (5/3));
		System.out.println("5%3=" + (5%3));

		System.out.println("x==y : "+(x==y));
		System.out.println("x!=y : "+(x!=y));
		System.out.println("x>y : " + (x>y));
		System.out.println("x<y : "+(x<y));
		System.out.println("x>=y : "+ (x>=y));
		System.out.println("x<=y : "+ (x<=y));

		byte b1 = 127;
		b1++;
		System.out.println(b1);
	}
}

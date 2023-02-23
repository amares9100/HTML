package Day17;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class Ex2 {
	public static void main(String[] args) {
		
		// 1. Date , SimpleDateFormat
		Date date = new Date(); // 현재 시스템[컴퓨터] 날짜
		System.out.println(date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM d H:m:s");
		System.out.println(sdf.format(date));
		
		
		Calendar calendar = Calendar.getInstance();
		
		
		
		System.out.println(calendar.get(calendar.YEAR));
		System.out.println(calendar.get(calendar.MONTH)+1); // 1월 : 0 / 2월 : 1 / 3월 :2 .... 때문에 +1
		System.out.println(calendar.get(calendar.DAY_OF_MONTH));
		System.out.println(calendar.get(calendar.DAY_OF_WEEK));
		
		int week = calendar.get(calendar.DAY_OF_WEEK);
		if(week ==calendar.SUNDAY){System.out.println("일");}
		if(week ==calendar.MONDAY){System.out.println("월");}
		if(week ==3){System.out.println("화");}
		if(week ==calendar.WEDNESDAY){System.out.println("수");}
		if(week ==5){System.out.println("목");}
		if(week ==calendar.FRIDAY){System.out.println("금");}
		if(week ==7){System.out.println("토");}
		
		
		int ampm = calendar.get(calendar.AM_PM);
		if(ampm==Calendar.AM) {
			System.out.println("오전");
		}else {System.out.println("오후");}
		
		
		for(String timeId : TimeZone.getAvailableIDs()) {
			System.out.println(timeId);
		}
		
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		
		System.out.println("1년후 : " + dateTime.plusYears(1));
		System.out.println("2개월 전 : "+ dateTime.minusMonths(2));
		System.out.println("7일 후 : "+dateTime.plusDays(7));
		
		
		LocalDateTime 시작일 = LocalDateTime.of(2021 , 1 , 1 , 0, 0, 0);
		LocalDateTime 종료일 = LocalDateTime.of(2021, 12 , 31 , 0 ,0 ,0);
		
		System.out.println("종료일이 시작일 이후 : " + 시작일.isBefore(종료일));
		System.out.println("종료일이 시작일 이전 : "+ 시작일.isAfter(종료일));
		System.out.println("종료일과 시작일이 같은 : " + 시작일.isEqual(종료일));
		System.out.println("같은 연도인지 : "+ (시작일.until(종료일, ChronoUnit.YEARS)));
		System.out.println("월 차 : "+ (시작일.until(종료일, ChronoUnit.MONTHS)));
		System.out.println("일 차 : "+ (시작일.until(종료일, ChronoUnit.DAYS)));
		System.out.println("시 차 : "+ (시작일.until(종료일, ChronoUnit.HOURS)));
		System.out.println("분 차 : "+ (시작일.until(종료일, ChronoUnit.MINUTES)));
		System.out.println("초 차 : "+ (시작일.until(종료일, ChronoUnit.SECONDS)));
		
		
		
		//
		double num = 1234567.89;
		DecimalFormat df;
		
		// 천단위 쉼표 만들기
		df = new DecimalFormat("#,###");
		System.out.println(df.format(num));
		
		// * 무조건 소수 첫째 자리 표기 [ 없으면 0 ]
			// 0 : 만일 숫자가 없는 자리면 0 채움
			// # : 만일 숫자가 없는 자리면 공백
		df = new DecimalFormat("#,###.0");
		System.out.println(df.format(123456.7));
		System.out.println(df.format(123456));
		
		// * 금액의 천단위 쉼표 : #,##0
		df = new DecimalFormat("#,##0원");
		System.out.println(df.format(1234567));
		System.out.println(df.format(1));
		
		//
		
		date = new Date();
		
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(date));
		
		sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(sdf.format(date));
		
		sdf = new SimpleDateFormat("yyyy.MM.dd a HH.mm.ss");
		System.out.println(sdf.format(date));
		
		sdf = new SimpleDateFormat("오늘은 E요일");
		System.out.println(sdf.format(date));
		
		sdf = new SimpleDateFormat("올해의 D번째날");
		System.out.println(sdf.format(date));
		
		sdf = new SimpleDateFormat("이달의 d번째날");
		System.out.println(sdf.format(date));
	}
}





















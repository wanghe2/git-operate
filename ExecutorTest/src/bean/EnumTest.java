package bean;

public class EnumTest {
	public static void main(String[] args) {
		Week w = Week.MONDAY;
		System.out.println(w);
	}
}


enum Week{
	MONDAY("星期一"),
	TUESDAY("星期二"),
	WEDNESDAY("星期三"),
	THURSDAY("星期四"),
	FRIDAY("星期五"),
	SATURDAY("星期六"),
	SUNDAY("星期日");
	private final String DESCRPTION;

	private Week(String dESCRPTION) {
		DESCRPTION = "hello,"+dESCRPTION;
	}
	public String toString(){
		return DESCRPTION;
	}
}

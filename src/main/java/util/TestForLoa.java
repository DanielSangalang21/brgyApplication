package util;

public class TestForLoa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String authDec = "jahit ani|^|kaja|daniel|pogi|123";
		if(authDec.contains("|^|")) authDec = authDec.replaceAll("\\|\\^\\|", "^*^");
		System.out.println(authDec);
	}

}

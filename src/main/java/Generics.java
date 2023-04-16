
public class Generics {

	private static <T> T identity4(T var){
		return var;
	}
	
	 public static void main(String [] args){

		 identity4("daniel");
	       identity4(4);
	    }//main
}

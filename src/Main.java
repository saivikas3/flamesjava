
public class Main {

	protected static String removeCommon(String oldFirst, String oldSecond, int oldX, int oldY) {
		int newY, newX;
		String newFirst, newSecond;
		char f,s;
		
		if(oldX == oldFirst.length()) {
			return oldFirst+oldSecond;
		}
		
		if(oldY == oldSecond.length())
			oldY = 0;
		
		f=oldFirst.charAt(oldX);
		s=oldSecond.charAt(oldY);
		
		if(f == s) {
			newFirst = oldFirst.replaceFirst(Character.toString(f),"");
			newSecond = oldSecond.replaceFirst(Character.toString(s),"");
			return removeCommon(newFirst, newSecond, oldX, oldY);
		}
		
		else {
			newX = oldX;
			newY = oldY + 1;
			if(newY == oldSecond.length()){
				newX = oldX + 1;
				newY = 0;
			}
			return removeCommon(oldFirst, oldSecond, newX, newY);
		}
		
		
	}
	
	protected static String flames(String nameA, String nameB) {
		int lengthA, lengthB;
		
		lengthA = nameA.length();
		lengthB = nameB.length();
		
		if(lengthA < lengthB) {
			
		} else {
			
		}
	}
	public static void main(String[] args) {
		
		System.out.println();
	}
}

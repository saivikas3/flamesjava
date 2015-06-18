import java.util.Scanner;


public class Main {
	
	protected static char[] delCharFromArray(char[] original, int location_to_remove)
	{
		char[] result = new char[original.length-1];
		int last_insert = 0;
		for (int i = 0; i < original.length; i++){
			if (i == location_to_remove)
				continue;

			result[last_insert++] = original[i];
		}
		return result;
	}

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
	
	protected static char[] flames(String nameA, String nameB) {
		int lengthA, lengthB;
		int n,i,m;
		int count=0;
		String tempA, tempB;
		String removed;
		char[] flamesArray = "flames".toCharArray();
		
		lengthA = nameA.length();
		lengthB = nameB.length();
		
		if(lengthA < lengthB) {
			tempA = nameA;
			tempB = nameB;
		} else {
			tempA = nameB;
			tempB = nameA;
		}
		// remove the common characters
		removed = removeCommon(tempA, tempB, 0, 0);
		//store the length in n
		n = removed.length()-1;
		//set starting pointer to 0
		i=0;
		//repeat five times
		for(count=0;count<5;count++) {
			
			if(n>=flamesArray.length)
				n%=flamesArray.length;
			
			m=n+i;
			if(m>=flamesArray.length)
				m%=flamesArray.length;
			
			flamesArray = delCharFromArray(flamesArray, m);
			i=m;
			
			
		}
		
		return flamesArray;
		
	}
	public static void main(String[] args) {
		
		String name1, name2;
		char[] answer;
		String resultToPrint;
		Scanner input = new Scanner(System.in);
		
		System.out.println("This utility checks relationship compatibility between two people.");
		
		System.out.println("Enter the first person's name:");
		name1 = input.nextLine();
		
		System.out.println("Enter the second person's name:");
		name2 = input.nextLine();
		
		answer = flames(name1, name2);
		
		switch(answer[0]) {
		case 'f': resultToPrint = "Friends"; 
		break;
		
		case 'l': resultToPrint = "Love"; 
		break;
		
		case 'a': resultToPrint = "Affection"; 
		break;
		
		case 'm': resultToPrint = "Marriage"; 
		break;
		
		case 'e': resultToPrint = "Enemies"; 
		break;
		
		case 's': resultToPrint = "Siblings"; 
		break;
		
		default: resultToPrint = "invalid input";
		break;
		
		}
		
		System.out.println(resultToPrint);
	}
}

package edu.osu.cs362;

import java.util.Random;

public class ValuesGenerator {
	private final static int MAX_VALUE=10;
	//private final static final int MIN_VALUE=-10;

	private final static float SET_TO_NULL = 0.05f;
	
	public static int RandInt(Random random){
    	int n = random.nextInt(MAX_VALUE);// get a random number between 0 (inclusive) and  MAX_VALUE=10 (exclusive)
        return (int) n;
        }

    	
	/**
	 * This generates a coin flip with a probability <tt>probability</tt> of
	 * returning true, else returning false.
	 */
	public static boolean getBoolean(float probability, Random random){
		return random.nextFloat() < probability;
	}
	

	private static final char[] BASE_CHARACTERS = {
		' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	};

	public static char getCharacter(Random random) {
			return BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
	}
	public static String getString(Random random) {

	    if (ValuesGenerator.getBoolean(SET_TO_NULL,random))	return null;

	    final int randNum;
	    
	    if(ValuesGenerator.getBoolean(.75f,random)) randNum = random.nextInt(10);
		else if(ValuesGenerator.getBoolean(.75f,random)) randNum = random.nextInt(50);
		else randNum = random.nextInt(100);

		char str[] = new char[randNum];

		for(int i = 0; i < randNum; i++)
			str[i] = getCharacter(random);

		return new java.lang.String(str);
	}
	
	
	/**
	 * 
	 * @param random, min , max
	 * @return get a random number between MIN_VALUE (inclusive) and  MAX_VALUE (inclusive)    
	 */
	public static int getRandomIntBetween(Random random, int min, int max) {
		
		long range       = (long)max - (long)min + 1;
		long fraction    = (long)(range * random.nextDouble());
	    int randomNumber = (int)(fraction + min); 
		return randomNumber;
	}
	
	
}

package container;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.HashSet;
import java.util.Random;

public class ContainerRandom2Test {
	private static final int MAX_VALUE=10;
	private static final int NUM_TESTS=10;
    public static int RandInt(Random random){
    	int n = random.nextInt(MAX_VALUE);// get a random number between 0 (inclusive) and  MAX_VALUE=10 (exclusive)
        return (int) n;
        }
    public static String RandMethod(Random random){
        String[] methodArray = new String[] {"put","get","remove","size"};//

    	int n = random.nextInt(4);// get a random number between 0 (inclusive) and  4 (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	@Test 
	public void test() {
		System.out.println("Start testing...");
		for (int k = 0; k < 1000000; k++) {

			Container c = new Container();
			HashSet<Integer> ref=new HashSet<Integer>();

			long randomseed = System.currentTimeMillis();
			Random random = new Random(randomseed);

			for (int i = 0; i < NUM_TESTS; i++) {
				String methodName = ContainerRandom2Test.RandMethod(random);
		
					int n = ContainerRandom2Test.RandInt(random);

				   if (methodName.equals("put")){
						int r1=c.put(n);
						int r2= ref.add(n)?1:0;
						assertEquals(r2, r1); 
						
					}
					else if (methodName.equals("get")){
						int r1=c.get(n);
						int r2= ref.contains(n)?1:0;
						 assertEquals(r2, r1);
					}
					else if (methodName.equals("remove")){
					//	c.printContainer();
						int r1=c.remove(n);
						int r2= ref.remove(n)?1:0;
						 assertEquals(r2, r1);
					}
					else if (methodName.equals("size")){
						int r1=c.size();
						int r2= ref.size();
						 assertEquals(r2, r1);
						
					}
		//				c.printContainer();
			}
		} //for k
		
		System.out.println("done!");
		
		
	}
	

}


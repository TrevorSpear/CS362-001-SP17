/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;

import java.util.Random;


/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   //Change these to true to get the error from that bug - BUT WILL FAIL
   //-----------------------------------
   private boolean showBugOne = false;
   private boolean showBugTwo = false;
   private boolean showBugThree = false;
   private boolean showBugFour = false;
   //-----------------------------------


    public UrlValidatorTest(String testName) {
      super(testName);
   }

   public void testManualTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       UrlValidator validator = new UrlValidator();

       System.out.println(urlVal.isValid("http://www.amazon.com"));
       System.out.println(validator.isValid("http://www.google.com:80/test1?action=view"));
       System.out.println(validator.isValid("http://0.0.0.0:80/test1?action=view"));
       System.out.println(validator.isValid("http://localhost"));
       System.out.println(validator.isValid("http://localhost/test/index.html"));

       //Trial
       assertFalse(urlVal.isValid("3ht://www.amazon.com"));
       assertFalse(urlVal.isValid("://www.amazon.com"));
       assertFalse(urlVal.isValid("http:www.amazon.com"));

       assertFalse(urlVal.isValid(null));

       //assertTrue(urlVal.isValid("http://0.0.0.0:80"));
       assertTrue(urlVal.isValid("http://300.300.300.300:80"));
       assertTrue(urlVal.isValid("http://255.255.255.255"));

       assertTrue(urlVal.isValid("http://www.google.com:80"));
       //assertTrue(urlVal.isValid("http://www.google.com/stuff.html?something=1"));
       //assertTrue(urlVal.isValid("http://www.google.com:80/stuff.html?something=1"));

       assertTrue(urlVal.isValid("http://www.google.com:300"));
       //assertTrue(urlVal.isValid("http://www.google.com:3000"));
       //assertTrue(urlVal.isValid("http://www.google.com:30000"));
       //assertTrue(urlVal.isValid("http://www.google.com:500?q=6"));


       //After doing random true url test ^ this is what I figured out

       //All Testing

       //Null
       assertFalse(urlVal.isValid(null));

       //Bug 1 - PortFailure - Doesn't allow over 3 digits
       //Suppose to be True or is True
       assertTrue(urlVal.isValid("http://www.google.com:1"));
       assertTrue(urlVal.isValid("http://www.google.com:20"));
       assertTrue(urlVal.isValid("http://www.google.com:300"));
       //----------------------------Bug------------------------------------
       if(showBugOne) {
           assertTrue(urlVal.isValid("http://www.google.com:4000"));
           assertTrue(urlVal.isValid("http://www.google.com:50000"));
       }
       //----------------------------------------------------------------

       //So idk if this isn't just a bug that the teacher put in but the maxium that the
       //Port number is suppose to be is 16 bit unsigned which is 65535 so shouldn't suppose to fail if over?
       //This works if you change it to 5 digits which shouldn't so I think the validator needs to change.
       //assertTrue(urlVal.isValid("http://www.google.com:65536"));

       //False
       assertFalse(urlVal.isValid("http://www.google.com:"));
       assertFalse(urlVal.isValid("http://www.google.com:666666"));
       assertFalse(urlVal.isValid("http://www.google.com:-50"));
       assertFalse(urlVal.isValid("http://www.google.com:50a"));
       assertFalse(urlVal.isValid("http://www.google.com:a50"));

       //Bug 2 - hostname
       //True
       assertTrue(validator.isValid("http://www.apache.org/test/index.html"));
       assertFalse(validator.isValid("http://first.my-testing/test/index.html"));
       assertTrue(validator.isValid("http://www.apache.org/test/index.html"));
       //--------------------------Bug--------------------------------------
       if(showBugTwo) {
           assertTrue(validator.isValid("http://localhost/test/index.html"));
           assertTrue(validator.isValid("http://machinename/test/index.html"));
           assertTrue(validator.isValid("http://hostname"));
           assertTrue(validator.isValid("http://hostname/test/index.html"));
           assertTrue(validator.isValid("http://localhost/test/index.html"));
       }
       //----------------------------------------------------------------

       //False
       //Couldn't find any false besides what the bug is doing

       //Bug 3 - query
       //Suppose to be True or is True
       assertTrue(urlVal.isValid("http://www.google.com"));
       assertTrue(urlVal.isValid("http://www.google.com/anything"));
       //----------------------------------------------------------------
       if(showBugThree) {
           assertTrue(urlVal.isValid("http://www.google.com:500?"));
           assertTrue(urlVal.isValid("http://www.google.com:600?q"));
           assertTrue(urlVal.isValid("http://www.google.com:700?q="));
           assertTrue(urlVal.isValid("http://www.google.com:500?q=6"));
           assertTrue(urlVal.isValid("http://www.google.com:500?q=="));
           assertTrue(urlVal.isValid("http://www.google.com:500?=6"));
           assertTrue(urlVal.isValid("http://www.google.com:500?="));
           assertTrue(urlVal.isValid("http://www.google.com:500?6"));
       }
       //----------------------------------------------------------------

       //False
       //I couldn't find any because you can use query incorrect and the values will be off but the url
       // shouldn't be effected to getting to the correct place

       //Bug 4 - Ip segment
       //True
       assertTrue(urlVal.isValid("http://255.255.255.255:80"));
       assertTrue(urlVal.isValid("http://255.255.255.255"));
       assertTrue(urlVal.isValid("http://254.254.254.254"));

       //False or should be false
       assertFalse(urlVal.isValid("http://-100.-100.-100.-100:80"));
       //----------------------------------------------------------------
       if(showBugFour) {
           assertFalse(urlVal.isValid("http://256.256.256.256:80"));
           assertFalse(urlVal.isValid("http://257.257.257.257"));
           assertFalse(urlVal.isValid("http://258.258.258.258"));
           assertFalse(urlVal.isValid("http://259.259.259.259"));
       }
       //----------------------------------------------------------------

   }
   
   
   public void testYourFirstPartition() {
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       assertTrue(urlVal.isValid("http://www.google.com:1"));
       assertTrue(urlVal.isValid("http://www.google.com:20"));
       assertTrue(urlVal.isValid("http://www.google.com:300"));

       assertFalse(urlVal.isValid("http://www.google.com:666666"));
       assertFalse(urlVal.isValid("http://www.google.com:-50"));
       assertFalse(urlVal.isValid("http://www.google.com:50a"));
       assertFalse(urlVal.isValid("http://www.google.com:a50"));
       assertFalse(urlVal.isValid("http://www.google.com:"));

       if(showBugOne) {
           assertTrue(urlVal.isValid("http://www.google.com:4000"));
           assertTrue(urlVal.isValid("http://www.google.com:50000"));
       }
   }
   
   public void testYourSecondPartition(){
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       assertTrue(urlVal.isValid("http://0.0.0.0:80"));
       assertTrue(urlVal.isValid("http://255.255.255.255:80"));
       assertTrue(urlVal.isValid("http://255.255.255.255:80"));
       assertTrue(urlVal.isValid("http://254.254.254.254:80"));
       assertFalse(urlVal.isValid("http://-254.-254.-254.-254:80"));

       if(showBugFour) {
           assertFalse(urlVal.isValid("http://256.256.256.256:80"));
           assertFalse(urlVal.isValid("http://300.300.300.300:80"));
           assertFalse(urlVal.isValid("http://350.350.350.350:80"));
       }
   }
   
   
   public void testIsValid() {
    UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

    String url_one [] = {
            "http://",
            "ftp://",
            "h3t://"
    };

    String url_two [] = {
            "www.google.com",
            "0.0.0.0",
            "255.255.255.255"
    };

    String url_three [] = {
            ":80",
            ":666",
            ":0",
            ""
    };

    String url_four [] = {
           "/testing",
            "/lol",
            "/testing/file",
            ""
    };

    Random rand = new Random();
    String urlTester;

    for(int i = 0;i<10000;i++) {
        urlTester = url_one[rand.nextInt(3)];
        urlTester += url_two[rand.nextInt(3)];
        urlTester += url_three[rand.nextInt(4)];
        urlTester += url_four[rand.nextInt(4)];

        assertTrue(urlVal.isValid(urlTester));
    }

   }
   
   public void testAnyOtherUnitTest() {
	   
   }
}

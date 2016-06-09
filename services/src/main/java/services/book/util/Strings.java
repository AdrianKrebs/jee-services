package services.book.util;

/**
 * Created by Adrian on 5/30/2016.
 */
public class Strings {


    public static void main(String[] args) {


        final String FPATH = "/home/user/index.html";
        Filename myHomePage = new Filename(FPATH, '/', '.');
        System.out.println("Extension = " + myHomePage.extension());
        System.out.println("Filename = " + myHomePage.filename());
        System.out.println("Path = " + myHomePage.path());


        String s = "MINIMUM";
        System.out.println(s.substring(4, 7)); //1 ---> first  index is including second index is excluding
        System.out.println(s.substring(5)); //2  ---> including 5th index till end
        System.out.println(s.substring(s.indexOf('I', 3))); //3 --> returns true
//        System.out.println(s.substring(s.indexOf('I', 4))); //4 --> exception because  no I cant be found when u start at 4th index


        String result = "AniMaL ".trim().toLowerCase().replace('a', 'A');


        StringBuilder sb = new StringBuilder("animals");
        String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al"));
        int len = sb.length();
        char ch = sb.charAt(6);
        System.out.println(sub + " " + len + " " + ch);


        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        StringBuilder three = one.append("a");
        System.out.println(one == two); // false
        System.out.println(one == three); // true


        "My name is ".concat("Rumplestiltskin");

        System.out.printf("The value of the float " +
                        "variable is %f, while " +
                        "the value of the " +
                        "integer variable is %d, " +
                        "and the string is %s",
                4.2f, 42, "42");


        // creates empty builder, capacity 16
        StringBuilder sb2 = new StringBuilder();
// adds 9 character string at beginning
        sb2.append("Greetings");





    }


    private void reversing() {

        String palindrome = "Dot saw I was Tod";

        StringBuilder sb = new StringBuilder(palindrome);

        sb.reverse();  // reverse it

        System.out.println(sb);
    }

    private void substringing() {

       // The following code gets from the Niagara palindrome the substring that extends from index 11 up to, but not including, index 15, which is the word "roar":

        String anotherPalindrome = "Niagara. O roar again!";
        String roar = anotherPalindrome.substring(11, 15);

    }



    // The program steps through the string referred to by searchMe one character at a time. For each character,
    // the program calls the regionMatches method to determine whether the substring beginning with the current character matches the string the program is looking for.
    public static boolean findStringInString(String searchMe, String findMe) {

        int searchMeLength = searchMe.length();
        int findMeLength = findMe.length();
        boolean foundIt = false;

        // subtract because as soon as i < findMeLength we never ever find the string
        for (int i = 0;
             i <= (searchMeLength - findMeLength);
             i++) {
            if (searchMe.regionMatches(i, findMe, 0, findMeLength)) {
                foundIt = true;
                System.out.println(searchMe.substring(i, i + findMeLength));
                return foundIt;
            }
        }

            System.out.println("No match found.");
            return false;


}



    public static class Filename {
        private String fullPath;
        private char pathSeparator,
                extensionSeparator;

        public Filename(String str, char sep, char ext) {
            fullPath = str;
            pathSeparator = sep;
            extensionSeparator = ext;
        }

        public String extension() {
            int dot = fullPath.lastIndexOf(extensionSeparator);
            // skip dot + 1 -_> from dot + 1 till end
            return fullPath.substring(dot + 1);
        }

        // gets filename without extension
        public String filename() {
            int dot = fullPath.lastIndexOf(extensionSeparator);
            int sep = fullPath.lastIndexOf(pathSeparator);
            return fullPath.substring(sep + 1, dot);
        }

        public String path() {
            int sep = fullPath.lastIndexOf(pathSeparator);
            // from 0 till sep
            return fullPath.substring(0,sep);
        }
    }



    /*

    --------------------------------String methods -------------------------------------------

    .intern()
    -------------
     String.equals() is quite the same as String.intern() <--- when u need speed s.intern() == t.intern() is true if and only if s.equals(t) is true.
     String.equalsIgnoreCase



    .substring()
    --------------
    String substring(int beginIndex)
          Returns a new string that is a substring of this string.
String substring(int beginIndex, int endIndex)
          Returns a new string that is a substring of this string.


    int indexOf(int ch)
          Returns the index within this string of the first occurrence of the specified character.
    int indexOf(int ch, int fromIndex)
          Returns the index within this string of the first occurrence of the specified character, starting the search at the specified index.
    int indexOf(String str)
          Returns the index within this string of the first occurrence of the specified substring.
    int indexOf(String str, int fromIndex)
          Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.


      which ones are final?
      --------------------
      String, StringBuilder, and StringBuffer - all are final classes.

    1. Remember that wrapper classes (java.lang.Boolean, java.lang.Integer, java.lang.Long, java.lang.Short etc.) are also final and so they cannot be extended.

    2. java.lang.Number, however, is not final. Integer, Long, Double etc. extend Number.

    3. java.lang.System is final as well.




    .concat() ---> IMMUTABILITY!!!
    ------------------

    Strings are immutable so doing abc.concat("abc") will create a new string "abc" but will not affect the original string "".




    a few more
    ----------------------


    tring();
    replace();
    contains();
    startsWith();
    charAt();


    Method chaining
    -----------------------------------
    Strings are immutable so doing abc.concat("abc") will create a new string "abc" but will not affect the original string "".





     */


}

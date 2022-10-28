import java.io.*;
import java.util.Scanner;

/**
 * Implements a function that returns the maximum of free urinals as an integer
 *
 * @author  Satvik Chemudupati
 */

public class urinals {

    public static boolean goodString( String str ) {
            return (str.matches("[0-1]+"));
    }

    static int count_method(String str1){

        int str_length = str1.length();
        char[] chars = str1.toCharArray();
        int count = 0;
        int i;
        for (i = 0; i < str_length - 1; i++){
        // checks for adjacent 1's in the string
            if (chars[i] == '1') {
                if (i >= 1) {
                    if (chars[i + 1] == '1' || chars[i - 1] == '1') {
                        return -1;
                    }
                }
                else {
                    if (chars[i + 1] == '1') {
                        return -1;
                    }
                }
            }
            else if (chars [i] == '0')
            {
                if ( i == 0 && chars[i + 1] == '1')
                {
                    continue;
                }
                else if (i == 0){
                    chars[i] = '1';
                    count += 1;
                }
                if (i >= 1) {
                    if (!(chars[i + 1] == '1' || chars[i - 1] == '1'))
                    {
                        chars[i] = '1';
                        count += 1;
                    }

                }
            }
        }
        // check the last element in the string
        if (i+1 == str_length && chars[i-1] == '1'){
            return count;
        }
        else if (i+1 == str_length && chars[i-1] == '0'){
            if (chars[i] != '1')
            {
                chars[i] = '1';
                count += 1;
            }


        }
        return count;

    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String str1;
        System.out.println("Welcome!");
        System.out.println("Please select the mode of input:");
        System.out.println("1. Input text from keyboard \n2. Input text fom file \n");
        int selection = sc.nextInt();
        if (selection == 1)
        {
            // input from the keyboard
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter the string:");
            str1 = reader.readLine();
            boolean result = str1.matches("[0-1]+");
            if (result)
            {
                int counter = count_method(str1);
                System.out.println("The number of options are: " + counter);
            }
            else
            {
                System.out.println("Input contains values other than 0 and 1");
            }
        }
        else if (selection == 2) {
            // file input
            File resourceFile = new File("input.dat");
            if (resourceFile.exists() && !resourceFile.isDirectory()) {
                System.out.println("Input File exists");
                BufferedReader reader1 = new BufferedReader(new FileReader(resourceFile));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                String ls = System.getProperty("line.separator");
                while ((line = reader1.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                reader1.close();
                String sbString = stringBuilder.toString();
                String error_string = "-1";
                // checks the file for -1/EOF/null
                if (sbString.substring(0, sbString.length() - 1).equals(error_string))
                {
                    System.out.println("Input file is null/-1/EOF");
                    return;
                }
                String[] ary = sbString.split("\n");
                String[] counter = new String[ary.length];
                for(int i = 0; i < ary.length; i++){
                    str1 = ary[i];
                    str1 = str1.substring(0, str1.length() - 1);
                    //check if the string is a good string
                    if (goodString(str1)) {
                        boolean result = str1.matches("[0-1]+");
                        if (result) {
                            counter[i] = String.valueOf(count_method(str1));
                        } else {
                            System.out.println("Input contains values other than 0 and 1");
                        }
                    }
                    else {
                        System.out.println("Failed good string");
                    }
                }
                File f = new File("rule.txt");
                int count_value = 1;
                if (f.exists())
                {
                    System.out.println("File rule.txt exists. Checking next file");
                    while (true) {
                        File f1 = new File("rule" + count_value + ".txt");
                        if (f1.exists() && !f1.isDirectory()) {
                            System.out.println("File rule" + count_value + ".txt exists. Checking next file");
                            count_value += 1;
                        } else {
                            System.out.println("File rule" + count_value + ".txt doesn't exist");
                            break;
                        }

                    }
                    System.out.println("Writing on " + "rule " + count_value + ".txt");
                    FileWriter writer = new FileWriter("rule" + count_value + ".txt");
                    for(String str2: counter) {
                        writer.write(str2 + System.lineSeparator());
                    }
                    writer.close();
                    System.out.println("Writing done..");
                }
                else
                {
                    FileWriter writer = new FileWriter("rule.txt");
                    for(String str2: counter) {
                        writer.write(str2 + System.lineSeparator());
                    }
                    writer.close();
                    System.out.println("Writing done..");
                }

            } else {
                System.out.println("File is not there");
            }
        }
        else
        {
            System.out.println("-1");
        }
    }
}

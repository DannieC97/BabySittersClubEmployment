package babysitterClub;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Creating two scanners to read two data files simultaneously
        Scanner s1 = new Scanner(new FileReader("Personnel.txt"));
        Scanner s2 = new Scanner(new FileReader("Payroll.txt"));
        //To store the temporary variables before creating an object
        String emp_id,f_name,l_name,address,city,state,zipcode,chart,a;
        String[] temp;

        //To store the days and index of Babysitter in babysitter array
        int i = 0,days;


        ArrayList<BabySitter> bsitter = new ArrayList<>();

//Reading through the files and extracting the values and creating the babysitter objects
        while(s1.hasNext())
        {
            emp_id = s1.nextLine();
          //  temp = s1.nextLine().split(",");
            a= s1.nextLine();
            temp = a.split(", ");
            f_name = temp[0];
            l_name = temp[1];
            address = s1.nextLine();
            temp = s1.nextLine().split(" ");
            //To exclude the comma that comes after city
            city = temp[0].substring(0, temp[0].length() - 1);
            state = temp[1];
            zipcode = temp[2];
            chart = s1.nextLine();
            if(s1.hasNext()) {
                s1.nextLine();
            }
            //Ignoring the first line of the second file as they are same in the first file
          // s2.nextLine();

            //adding objects to arraylist
            BabySitter b = new BabySitter(emp_id,l_name,f_name,address,city,state,zipcode,chart);
            bsitter.add(b);


        }
        i = 0;
        while (s2.hasNext()) {


                BabySitter babySitter = bsitter.get(i);

                s2.nextLine();
                days = Integer.parseInt(s2.nextLine());
                babySitter.setDays(days);
                temp = new String[days];
                for (int k = 0; k < days; k++) {
                    temp[k] = s2.nextLine();
                }
                babySitter.setHours(temp);
                if (s2.hasNext()) {
                    s2.nextLine();
                }
                i++;


            }


        Collections.sort(bsitter, new Comparator<BabySitter>() {
            public int compare(BabySitter v1, BabySitter v2) {
                return v1.getLastName().compareTo(v2.getLastName());

            }
        });




        for (int j = 0; j < bsitter.size(); j++) {
            BabySitter babySitter =  bsitter.get(j);
            //babySitter.computeFees();
            System.out.println(babySitter.toString());

        }
        try {
            File file = new File("output.txt");
            if(!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            for (int j = 0; j < bsitter.size(); j++) {
                BabySitter babySitter = bsitter.get(j);
                pw.println(babySitter.toString());

            }
            pw.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        }

    }


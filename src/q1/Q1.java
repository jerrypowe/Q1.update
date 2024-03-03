/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Q1 {

    //Change the name of input and output file based on practical paper
    String inputFile = "input.txt";
    String outputFile = "output.txt";

    //--VARIABLES - @STUDENT: DECLARE YOUR VARIABLES HERE:
   private ArrayList<String> S1 = new ArrayList<>();
   private ArrayList<Point> S4 = new ArrayList<>();
   private ArrayList<Straightline> S5 = new ArrayList<>();
   private ArrayList<String> S6 = new ArrayList<>();
   private ArrayList<String> S7 = new ArrayList<>();
    int m = 0;
    //--FIXED PART - DO NOT EDIT ANY THINGS HERE--
    //--START FIXED PART--------------------------    
    String fi, fo;

    /**
     * Set input and output file for automatic rating
     *
     * @param args path of input file and path of output file
     */
    public void setFile(String[] args) {
        fi = args.length >= 2 ? args[0] : inputFile;
        fo = args.length >= 2 ? args[1] : outputFile;
    }

    /**
     * Reads data from input file
     */
    public void read() {
        try (Scanner sc = new Scanner(new File(fi))) {
            //--END FIXED PART----------------------------

            //INPUT - @STUDENT: ADD YOUR CODE FOR INPUT HERE:
            while (sc.hasNextLine()) {
                int value = Integer.parseInt(sc.nextLine());
//                System.out.println( value);
                // Read and store data based on the value
                ArrayList<String> data = new ArrayList<>();
                data.add(Integer.toString(value));
                for (int i = 0; i < value; i++) {
                    if (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        data.add(line);
                    }
                }
                // Add data to S1
                S1.addAll(data);
            }

            //lưu vào array1 các lựa chọn
            //array2 dùng tách chuỗi và xử lý yêu cầu
            // dùng split và equals nhằm tách và xử lý yêu cầu
            //--FIXED PART - DO NOT EDIT ANY THINGS HERE--
            //--START FIXED PART--------------------------    
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Input Exception # " + ex);
        }
    }
    //--END FIXED PART----------------------------

    //ALGORITHM - @STUDENT: ADD YOUROWN METHODS HERE (IF NEED):
    //--FIXED PART - DO NOT EDIT ANY THINGS HERE--
    //--START FIXED PART--------------------------    
    /**
     * Main algorithm
     */
    public void solve() {
        //--END FIXED PART----------------------------

        //ALGORITHM - @STUDENT: ADD YOUR CODE HERE:
        for (String line : S1) {
            String[] S2 = line.split(" ");

            if (S2.length > 0) {
                if (S2[0].equals("Point")) {
                    if (S2.length >= 3) {
                        Point point1 = new Point(Integer.parseInt(S2[1]), Integer.parseInt(S2[2]), "black");
                        point1.inputData();
                        S4.add(point1);
                        S7.add(point1.getInfo());
                        point1.draw();
                        S6.add(point1.getInfo());
                    } else {
                        System.out.println("Invalid format for Point: " + line);
                    }
                } else if (S2[0].equals("Line")) {
                    if (S2.length >= 5) {

                        Point p1 = new Point(Integer.parseInt(S2[1]), Integer.parseInt(S2[2]), "black");
                        Point p2 = new Point(Integer.parseInt(S2[3]), Integer.parseInt(S2[4]), "black");
                        Straightline straighline1 = new Straightline(p1, p2, "black");
                         straighline1.inputData();
                         S5.add(straighline1);
                          S7.add(straighline1.getInfo());
                         straighline1.draw();
                         S6.add(straighline1.getInfo());
                       
                    } else {
                        System.out.println("Invalid format for Line: " + line);
                    }
                } else if (S2[0].equals("Draw")) {
                    S7.add("---Draw---\n");
//                  
                    for(String ss : S6){
                        S7.add(ss);
                    }
                    
                    S7.add("----------\n");
                } else if (S2[0].equals("Clear")) {
                    S4.clear();
                    S5.clear();
                    S6.clear();
                    S7.add("* Remove all shape\n");
                } else if (Integer.parseInt(S2[0])>0) {
                    int n = Integer.parseInt(S2[0]);
                    if (n > 0 && n < 100) {
//                         S7.add(S2[0]+"\n");
                    }
                }

            } else {
                System.out.println("Invalid input: " + line);
            }
        }

        //--FIXED PART - DO NOT EDIT ANY THINGS HERE--
        //--START FIXED PART-------------------------- 
    }

    /**
     * Write result into output file
     */
    public void printResult() {
        try {
            FileWriter fw = new FileWriter(fo);
            //--END FIXED PART----------------------------

            //OUTPUT - @STUDENT: ADD YOUR CODE FOR OUTPUT HERE:
            // Ghi thông tin từ S4 vào tập tin
//            for (Point p : S4) {
//                fw.write("Point: " + p.getX() + ", " + p.getY()  + "\n");
//            }
           
            // Ghi thông tin từ S5 vào tập tin
            for (String sl : S7) {
              fw.write(sl);
            }

            fw.write("\n");
//            fw.append();
            //--FIXED PART - DO NOT EDIT ANY THINGS HERE--
            //--START FIXED PART-------------------------- 
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            System.out.println("Output Exception # " + ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Q1 q = new Q1();
        q.setFile(args);
        q.read();
        q.solve();
        q.printResult();
    }
    //--END FIXED PART----------------------------    
}

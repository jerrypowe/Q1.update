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
    ArrayList<String> S1 = new ArrayList<String>();
    ArrayList<Point> S4 = new ArrayList<Point>();
    ArrayList<StraighLine> S5 = new ArrayList<StraighLine>();
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
            String n;
            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                S1.add(line);

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
        
        for (int i = 0; i < S1.size(); i++) {
            int n = 0;
            
            String[] S2;
            S2 = S1.get(i).split(" ");

            if (S2.length > 1) {
                if (S2[0].equals("Point")) {
                    System.out.printf("Add point(%d,%d)",S2[1],S2[2]);
                    
                    String color = S2[3];
                    Point point1 = new Point(Integer.parseInt(S2[1]), Integer.parseInt(S2[2]),S2[3]);
                    S4.add(point1);
                   
                } else if (S2[0].equals("Line")) {
                    System.out.printf("Add line(%d,%d)->(%d,%d)",S2[1],S2[2],S2[3],S2[4]);
                    String color = S2[5];
                    Point p1 = new Point(Integer.parseInt(S2[1]), Integer.parseInt(S2[2]), color);
                    Point p2 = new Point(Integer.parseInt(S2[3]), Integer.parseInt(S2[4]), color);
                    StraighLine straighline1 = new StraighLine(p1, p2, color);
                    S5.add(straighline1);
                }
            } else if (S2.length == 1) {
                n = Integer.parseInt(S2[0]);
                if (n >= 1 && n <= 100) {
                    m = n;
                } else if (n == 0) {
                    if (S2[0].equals("Draw")) {
                        System.out.println("---Draw---");
                        S4.get(i).draw();
                        S5.get(i).draw();

                    } else if (S2[0].equals("Clear")) {
                        S4.clear();
                        S5.clear();
                        System.out.println("* Remove all shape");
                    }
                }

            }

            //--FIXED PART - DO NOT EDIT ANY THINGS HERE--
            //--START FIXED PART-------------------------- 
        }}
        /**
         * Write result into output file
         */
    public void printResult() {
        try {
            FileWriter fw = new FileWriter(fo);
            //--END FIXED PART----------------------------

            //OUTPUT - @STUDENT: ADD YOUR CODE FOR OUTPUT HERE:
            fw.write(outputFile);
            for (int i = 0; i < S1.size(); i++) {
                
                this.S4.get(i).inputData();
                StraighLine straighline = this.S5.get(i).;
                
            }

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

/**
 * Vedamsh Ganta
 * 115004229
 * Recitation 01
 */

import java.util.Scanner;

/**
 * The NeoViewer class is the main class for the NEO Viewer application.
 */
public class NeoViewer {
    static Scanner sc = new Scanner(System.in);

    /**
     * The main method starts the NEO Viewer application and initializes the database.
     * It provides a menu to allow users to interact with the NearEarthObject Database.
     * @param args command line arguments
     */
    public static void main(String[] args){
        System.out.println("  Welcome to NEO Viewer!");

        NeoDatabase neoDatabase = new NeoDatabase();

        lp: while(true){
            System.out.println();
            System.out.println("  Option Menu:\n" +
                    "    A) Add a page to the database\n" +
                    "    S) Sort the database \n" +
                    "    P) Print the database as a table.\n" +
                    "    Q) Quit");
            System.out.println();
            System.out.print("  Select a menu option: ");
            String option = sc.nextLine();
            System.out.println();
            switch(option){
                case "A":
                    System.out.print("  Enter the page to load: ");
                    int pageNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    try{
                        String queryURL = neoDatabase.buildQueryURL(pageNumber);
                        neoDatabase.addAll(queryURL);
                        System.out.println("  Page loaded successfully!");
                    }
                    catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "S":
                    System.out.println("  R) Sort by referenceID\n" +
                            "  D) Sort by diameter\n" +
                            "  A) Sort by approach date\n" +
                            "  M) Sort by miss distance");
                    System.out.println();
                    System.out.print("  Select a menu option: ");
                    String sortOption = sc.nextLine();
                    System.out.println();
                    if(sortOption.equals("R")){
                        neoDatabase.sort(new ReferenceIDComparator());
                        System.out.println("  Table sorted on reference ID.");
                    }
                    else if(sortOption.equals("D")){
                        neoDatabase.sort(new DiameterComparator());
                        System.out.println("  Table sorted on diameter.");
                    }
                    else if(sortOption.equals("A")){
                        neoDatabase.sort(new ApproachDateComparator());
                        System.out.println("  Table sorted on approach date.");
                    }
                    else if(sortOption.equals("M")){
                        neoDatabase.sort(new MissDistanceComparator());
                        System.out.println("  Table sorted on miss distance.");
                    }
                    else{
                        System.out.println("Invalid sort option.");
                    }
                    break;
                case "P":
                    neoDatabase.printTable();
                    break;
                case "Q":
                    System.out.println("Program terminating normally...");
                    break lp;
            }
        }
    }
}

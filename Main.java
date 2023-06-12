// Name: Pallav Regmi
// Class: 2251: A02
// Assignment:  To Read in the data,
//              organize the data with a dedicated object and an ArrayList to hold instances of those objects,
//              calculate maximum difference in AverageTravelTime,
//              and finally Display results on command prompt and also output the results to a text file,
// Purpose: Working on file reading, creating and also OOP
// Filename: TravelTimeData.java

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        ArrayList<TravelTimeData> data = new ArrayList<>();
        try
        {
            File f = new File("TravelDataPartial.csv");
            Scanner s = new Scanner(f);

            //Strip first line
            s.nextLine();


            while(s.hasNext())
            {
                String row = s.nextLine();
                String nextRow = s.nextLine();
                String[] values = row.split(",");
                String[] nextRowValues = nextRow.split(",");
                int cogId = Integer.parseInt(values[0]);
                int travelTime = Integer.parseInt(values[14]);
                String direction = values[1];
                int cogId1 = Integer.parseInt(nextRowValues[0]);
                int travelTime1 = Integer.parseInt(nextRowValues[14]);
                String direction1 = nextRowValues[1];

                TravelTimeData sc = new TravelTimeData(cogId, travelTime, direction, travelTime1, direction1 );
                data.add(sc);
            }
            s.close();
        }
        catch(Exception e)
        {
            System.out.println("ERROR!");
            e.printStackTrace();
        }
        TravelTimeData lrgdiffdata = getLargestDifferential(data);
        int res= lrgdiffdata.getTravelTimeDifference();

        //write output file
		try
		{
			//You will need to change and fill in
			//the following.
			
			FileWriter fw = new FileWriter("output.txt");
			fw.write("The route with the biggest time differential is\n"+ lrgdiffdata +
                    "\nwith a time difference of " + res +" minutes. ");
			fw.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
        System.out.println("The route with the biggest time differential is");
        System.out.println(lrgdiffdata);
        System.out.println("with a time difference of "+res+" minutes.");

    }
    public static TravelTimeData getLargestDifferential(ArrayList<TravelTimeData> data)
    {
        TravelTimeData largestDifferential = null;

        for (TravelTimeData travelData : data) {
            if (largestDifferential == null || travelData.getTravelTimeDifference() > largestDifferential.getTravelTimeDifference()) {
                largestDifferential = travelData;
            }
        }

        return largestDifferential;
    }

}

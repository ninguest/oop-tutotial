import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BankDataCorrection {

    public static void main(String[] args) {
        String inputFile = "bank_data.csv";
        String outputFile = "corrected_bank_data.csv";

        try {
            long startTime = System.currentTimeMillis();

            // Process the bank data and write corrected data to a new file
            processBankData(inputFile, outputFile);

            long endTime = System.currentTimeMillis();
            System.out.println("Total execution time: " + (endTime - startTime) + " milliseconds");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processBankData(String inputFile, String outputFile) throws IOException {

        // try-with-resources statement, which was introduced in Java 7. 
        // It's a convenient way to ensure that resources like file streams are closed 
        // properly after being used, even if an exception occurs.
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        ) {
            
            boolean firstLineChecker = true;

            String line;
            while ((line = reader.readLine()) != null) {


                if(firstLineChecker == true){
                    firstLineChecker = false;
                    writer.write(line);
                }else{
                    writer.newLine();
                    // Perform corrections on each line
                    String correctedLine = correctData(line);
                    // Write the corrected line to the output file
                    writer.write(correctedLine);
                }
                
            }
        }
    }

    private static String monthConverter(String month) {
        switch (month) {
            case "Jan":
                return "01";
            case "Feb":
                return "02";
            case "Mar":
                return "03";
            case "Apr":
                return "04";
            case "May":
                return "05";
            case "Jun":
                return "06";
            case "Jul":
                return "07";
            case "Aug":
                return "08";
            case "Sep":
                return "09";
            case "Oct":
                return "10";
            case "Nov":
                return "11";
            case "Dec":
                return "12";
            default:
                return month;
        }
    }

    private static String correctData(String line) {

        // a. Remove the extra symbol "'" at the end of the account number
        line = line.replaceAll("',", ",");
        line = line.replaceAll(",,", ",");

        // c. Replace "FDRL/INTERNAL FUND TRANSFE" with "FDRL/EXTERNAL FUND TRANSFE"
        line = line.replaceAll("FDRL/INTERNAL FUND TRANSFE", "FDRL/EXTERNAL FUND TRANSFE");

        // b. Change the date format from DD-MTH-YY to YYYY/MM/DD
        String[] parts = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        String[] dateParts = parts[1].split("-");
        String day = dateParts[0];
        String month = monthConverter(dateParts[1]);
        String year = "20" + dateParts[2];
        parts[1] = year + "/" + month + "/" + day;
        
        String [] dateParts2 = parts[3].split("-");
        
        if(dateParts2.length == 3){
            String day2 = dateParts2[0];
            String month2 = monthConverter(dateParts2[1]);
            String year2 = "20" + dateParts2[2];
            parts[3] = year2 + "/" + month2 + "/" + day2;

            parts[4] = parts[4].replaceAll(",", "");
            parts[5] = parts[5].replaceAll(",", "");

        }else{
            dateParts2 = parts[4].split("-");
            String day2 = dateParts2[0];
            String month2 = monthConverter(dateParts2[1]);
            String year2 = "20" + dateParts2[2];
            parts[4] = year2 + "/" + month2 + "/" + day2;

            parts[5] = parts[5].replaceAll(",", "");
            parts[6] = parts[6].replaceAll(",", "");
        }
    
        return String.join(",", parts);
        // return line;
    }
}

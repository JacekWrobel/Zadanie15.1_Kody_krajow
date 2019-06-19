import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountryApp {
    public static void main(String[] args) throws FileNotFoundException {

        Map<String, Country> temp = countriesFromFile("countryData.csv");
        System.out.println("Podaj kod kraju");
        Scanner scan = new Scanner(System.in);
        String askedCode = scan.nextLine();
        System.out.println(temp.get(askedCode));
    }

    public static HashMap<String, Country> countriesFromFile(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        Map<String, Country> countriesMap = new HashMap<>();

        while (sc.hasNextLine()) {
            String temporary = sc.nextLine();
            String[] split = temporary.split(";");
            Country cust = new Country(split[0], split[1], Integer.valueOf(split[2]));
            countriesMap.put(split[0], cust);
        }
        return (HashMap<String, Country>) countriesMap;
    }
}
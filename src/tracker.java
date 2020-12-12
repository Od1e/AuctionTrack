// TODO: Fix JSoup dependency, might've messed it up
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author Odie
 * @version 0.0.1
 * Odie#1008 on Discord
 * Od1e on GitHub
 */

public class tracker {
    // -- PRIVATE INSTANCE VARIABLES --
    private String url; // Primary URL for bidding website with item information
    private String site; // Website being used
    private String name; // Name of item
    private double price; // Current price of item
    private String endTime; // Time until bidding is over
    private boolean isOver; // True if auction is over

    DateFormat timeF = new SimpleDateFormat("yyyy-MM-dd");

    // -- CONSTRUCTORS --
    // Default constructor for an auction object
    public tracker()
    {

    }

    // -- ACCESSORS --
    // Returns site
    public String getSite () {
        return site;
    }
    // Return unformatted endTime
    public String getUfendTime () {
        return endTime;
    }

    // -- MUTATORS --
    // Reads input url and fills in instance variables
    public void readSite (String link) throws IOException {
        String urlAsString = link.toLowerCase();
        String endTime;
        // Assign whatever site is input to site string
        // TODO: Potentially combine this with the if-statement underneath
        if (urlAsString.contains("ebay")){
            site = "ebay";
        }
        else if (urlAsString.contains("shopgoodwill"))
        {
            site = "shopgoodwill";
        }
        else {
            // TODO
            site = "None";
        }

        // Query input url and download html
        Document doc = Jsoup.connect(link).get();

        // Splitting up different sites in an if-statement since they're all written differently
        // - Ebay
        if (site.equals("ebay")){
            // TODO: Create JSoup read template for Ebay
            endTime = "";
        }
        // - Shopgoodwill
        else if (site.equals("shopgoodwill")){
            // Get input element with ID "end-time"
            Element input = doc.getElementById("end-time");
            // Read value of end-time and put this value in endTime string
            endTime = input.attr("value");
        }
        // - Unknown site
        else{
            // TODO: Create some sort of fallback
            endTime = "None";
        }

        this.endTime = endTime;
    }
}

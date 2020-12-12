// TODO: Fix JSoup dependency, might've messed it up

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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
    private ZonedDateTime fEndTime; // Time until bidding is over as ZonedDateTime object
    private Duration secUntil;
    private boolean isOver; // True if auction is over

    DateTimeFormatter gwTimeFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a z");

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

    // Returns product name
    public String getName () {
        return name;
    }

    // Return unformatted endTime
    public String getUfendTime () {
        return endTime;
    }

    // Return formatted time as object
    public ZonedDateTime getfEndTime () {
        return fEndTime;
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
            // Get h1 element with class "product-title"
            Elements title = doc.getElementsByClass("product-title");
            name = title.first().text();

            // Get input element with ID "end-time"
            Element input = doc.getElementById("end-time");
            // Read value of end-time and put this value in endTime string
            endTime = input.attr("value") + " PST";
            fEndTime = ZonedDateTime.parse(endTime, gwTimeFormat);
        }
        // - Unknown site
        else{
            // TODO: Create some sort of fallback
            endTime = "None";
        }

        this.endTime = endTime;
    }

    // Sets countdown timer using ZonedDateTime filled in readSite
    public void setTimer () {

    }
}

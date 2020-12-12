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
    private ZonedDateTime endTime; // Time until bidding is over
    private boolean isOver; // True if auction is over

    DateFormat timeF = new SimpleDateFormat("yyyy-MM-dd");

    // -- CONSTRUCTORS --
    // Default constructor for an auction object
    public tracker()
    {

    }

    // -- ACCESSORS --

    // -- MUTATORS --
    // Reads input url and fills in instance variables
    public void readSite (String link) throws IOException {
        String urlAsString = link.toLowerCase();
        String endTime;
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

        Document doc = Jsoup.connect(link).get();

        if (site.equals("ebay")){
            // TODO
            endTime = "";
        }
        else if (site.equals("shopgoodwill")){
            Element input = doc.getElementById("end-time");
            endTime = input.attr("value");
        }
        else{
            // TODO
            endTime = "None";
        }

        this.endTime = ZonedDateTime.parse(endTime);
        System.out.println(this.endTime);
    }
}

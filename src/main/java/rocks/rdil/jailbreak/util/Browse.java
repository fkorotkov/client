package rocks.rdil.jailbreak.util;
import java.lang.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Browse {
    public Browse() {}
    private static Desktop d = Desktop.getDesktop();
    public static void BrowseURI(String theURL) {
        if(theURL != null && d != null && !theURL.equals("") && !theURL.isEmpty()) {
            try {
                d.browse(new URI(theURL));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}

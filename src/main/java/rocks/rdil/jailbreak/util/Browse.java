package rocks.rdil.jailbreak.util;
import java.lang.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Browse {
    public Browse() {}
    public void BrowseURI(String theURL) {
        if(theURL != null && !theURL.equals("") && !theURL.isEmpty()) {
            try {
                Desktop.getDesktop().browse(new URI(theURL));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}

package rocks.rdil.jailbreak.util;
import java.lang.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Commons {
    public void BrowseURI(String theURL) {
        final int len = blacklisted.length;
        for(int b = 0; b < len;) {
            if(theURL != null && !theURL.equals("") && !theURL.contains(blacklisted[b])) {
                try {
                    Desktop.getDesktop().browse(new URI(theURL));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            } else b++;
        }
    }
}

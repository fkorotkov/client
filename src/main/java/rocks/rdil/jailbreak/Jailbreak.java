package rocks.rdil.jailbreak;

import cc.hyperium.Hyperium;
import rocks.rdil.jailbreak.util.Browse;

public class Jailbreak {
    public Jailbreak() {}

    private static Browse browseUtilInstance = new Browse();

    public void debug() {
        Hyperium.LOGGER.debug("----------------");
        Hyperium.LOGGER.warn("This project is NOT RUN BY THE HYPERIUM TEAM");
        Hyperium.LOGGER.warn("Please report bugs by DMing jumbocakeyumyum#0001 on Discord");
        Hyperium.LOGGER.warn("or by emailing me@rdil.rocks");
        Hyperium.LOGGER.warn("Thanks!");
        Hyperium.LOGGER.debug("----------------");
    }

    public static Browse getBrowseUtil() {
        return browseUtilInstance;
    }
}

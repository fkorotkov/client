package cc.hyperium.commands.defaults;

import cc.hyperium.commands.BaseCommand;
import cc.hyperium.commands.CommandException;
import cc.hyperium.gui.CustomLevelheadConfigurer;

public class CustomLevelheadCommand implements BaseCommand {
    @Override
    public String getName() {
        return "customlevelhead";
    }

    @Override
    public String getUsage() {
        return "/" + getName();
    }

    @Override
    public void onExecute(String[] args) throws CommandException {
        new CustomLevelheadConfigurer().show();
    }
}

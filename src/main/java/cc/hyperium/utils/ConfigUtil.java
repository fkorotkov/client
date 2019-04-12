package cc.hyperium.utils;

import cc.hyperium.Hyperium;
import com.google.gson.JsonObject;

public class ConfigUtil {
    public static boolean getOptionWithDefault(String settingName, String classPath, boolean defaultObject) {
        JsonObject generalJsonObject = Hyperium.CONFIG.getConfig().get(classPath).getAsJsonObject();
        if (!generalJsonObject.has(settingName)) {
            generalJsonObject.addProperty(settingName, defaultObject);
            saveConfig();
        }
        return generalJsonObject.get(settingName).getAsBoolean();
    }

    public static double getOptionWithDefault(String settingName, String classPath, Number defaultObject) {
        JsonObject generalJsonObject = Hyperium.CONFIG.getConfig().get(classPath).getAsJsonObject();
        if (!generalJsonObject.has(settingName)) {
            generalJsonObject.addProperty(settingName, defaultObject);
            saveConfig();
        }
        return generalJsonObject.get(settingName).getAsDouble();
    }

    public static String getOptionWithDefault(String settingName, String classPath, String defaultObject) {
        JsonObject generalJsonObject = Hyperium.CONFIG.getConfig().get(classPath).getAsJsonObject();
        if (!generalJsonObject.has(settingName)) {
            generalJsonObject.addProperty(settingName, defaultObject);
            saveConfig();
        }
        return generalJsonObject.get(settingName).getAsString();
    }

    public static char getOptionWithDefault(String settingName, String classPath, char defaultObject) {
        JsonObject generalJsonObject = Hyperium.CONFIG.getConfig().get(classPath).getAsJsonObject();
        if (!generalJsonObject.has(settingName)) {
            generalJsonObject.addProperty(settingName, defaultObject);
            saveConfig();
        }
        return generalJsonObject.get(settingName).getAsCharacter();
    }

    public static void saveConfig() {
        Hyperium.CONFIG.save();
    }

    public static void register(Object obj) {
        Hyperium.CONFIG.register(obj);
    }
}

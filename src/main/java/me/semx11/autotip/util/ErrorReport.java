package me.semx11.autotip.util;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import me.semx11.autotip.Autotip;
import me.semx11.autotip.event.impl.EventClientConnection;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class ErrorReport {

    private static Autotip autotip;

    public static void setAutotip(Autotip autotip) {
        ErrorReport.autotip = autotip;
    }

    public static void reportException(Throwable t) {}

    private static class JsonObjectBuilder {

        private final JsonObject obj;

        private JsonObjectBuilder(JsonObject obj) {
            this.obj = obj;
        }

        static JsonObjectBuilder newBuilder() {
            return new JsonObjectBuilder(new JsonObject());
        }

        JsonObjectBuilder addString(String property, Object value) {
            obj.addProperty(property, String.valueOf(value));
            return this;
        }

        JsonObjectBuilder addNumber(String property, Number value) {
            obj.addProperty(property, value);
            return this;
        }

        JsonObject build() {
            return obj;
        }

    }

}

package me.semx11.autotip.api.request.impl;

import java.util.Locale;
import java.util.Optional;
import me.semx11.autotip.Autotip;
import me.semx11.autotip.api.GetBuilder;
import me.semx11.autotip.api.RequestHandler;
import me.semx11.autotip.api.RequestType;
import me.semx11.autotip.api.reply.Reply;
import me.semx11.autotip.api.reply.impl.LocaleReply;
import me.semx11.autotip.api.request.Request;
import org.apache.http.client.methods.HttpUriRequest;

public class LocaleRequest implements Request<LocaleReply> {
    private final Locale locale;

    private LocaleRequest(Autotip autotip) {
        this.locale = autotip.getConfig().getLocale();
    }

    public static LocaleRequest of(Autotip autotip) {
        return new LocaleRequest(autotip);
    }

    @Override
    public LocaleReply execute() {
        HttpUriRequest request = GetBuilder.of(this)
                .addParameter("lang", this.locale.toLanguageTag())
                .addParameter("v", "v3.0")
                .build();

        Optional<Reply> optional = RequestHandler.getReply(this, request.getURI());
        return optional
                .map(reply -> (LocaleReply) reply)
                .orElseGet(() -> new LocaleReply(false));
    }

    @Override
    public RequestType getType() {
        return RequestType.LOCALE;
    }

}

package com.xyz.tennistrack.config;

import java.util.*;

public class UserAgents {

    private static Set<String> userAgents;

    private UserAgents() {}
    private static Set<String> initAgents() {
        if (userAgents == null) {
            userAgents = new HashSet<>();

            userAgents.addAll(Set.of(
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36",
                        "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36 Edg/123.0.2420.97",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36 Edg/123.0.2420.97",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:125.0) Gecko/20100101 Firefox/125.0",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 14.4; rv:125.0) Gecko/20100101 Firefox/125.0",
                        "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:125.0) Gecko/20100101 Firefox/125.0"
            ));
        }

        return userAgents;
    }

    //thread safe singleton
    public static synchronized String getAgent() {
        if (userAgents == null)
            userAgents = initAgents();

        return userAgents.stream().findFirst().get();
    }
}

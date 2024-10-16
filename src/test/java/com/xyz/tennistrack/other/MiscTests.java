package com.xyz.tennistrack.other;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MiscTests {

    @Test
    public void testTwoUrlStrings() {
        String[] url1 = new String[]{"https://searchserverapi.com/getresults?api_key=1T0U8M9s3R&facets=true&maxResults=250&queryBy%5Bcollections%5D=Tennis%20Racquets&q=ALLDEALS&restrictBy%5Bdiscount%5D=0,100&startIndex=0"};
        String[] url2 = new String[]{"https://searchserverapi.com/getresults?api_key=1T0U8M9s3R&facets=true&maxResults=250&queryBy%5Bcollections%5D=Tennis%20Racquets&q=ALLDEALS&restrictBy%5Bdiscount%5D=0,100&startIndex=0"};

        String s1 = "https://searchserverapi.com/getresults?api_key=1T0U8M9s3R&facets=true&maxResults=250&queryBy%5Bcollections%5D=Tennis%20Racquets&q=ALLDEALS&restrictBy%5Bdiscount%5D=5,100&startIndex=0";
        String s2 = "https://searchserverapi.com/getresults?api_key=1T0U8M9s3R&facets=true&maxResults=250&queryBy%255Bcollections%255D=Tennis%2520Racquets&q=ALLDEALS&restrictBy%255Bdiscount%255D=5,100&startIndex=0";
        Assertions.assertThat(url1).isEqualTo(url2);
    }
}

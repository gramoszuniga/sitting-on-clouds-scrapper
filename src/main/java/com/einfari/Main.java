package com.einfari;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author : Gonzalo Ramos Zúñiga
 * @since : 2025-02-27
 **/
@Slf4j
public class Main {

    private static final int INTERVAL_MS = 500;
    private static final int LAST_INDEX = 123;
    private static final String BASE_URL = "https://www.sittingonclouds.com/last-added/";
    private static final String KEYWORD = "009";

    public static void main(String[] args) throws InterruptedException, IOException {
        for (int index = 1; index <= LAST_INDEX; index++) {
            String url = BASE_URL + index;
            Document document = Jsoup.connect(url).get();
            if (document.text().contains(KEYWORD)) {
                log.info("Keyword found on: " + BASE_URL + "{}", index);
            }
            Thread.sleep(INTERVAL_MS);
        }
    }

}

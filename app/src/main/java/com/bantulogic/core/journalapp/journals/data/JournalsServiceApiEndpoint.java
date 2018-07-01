package com.bantulogic.core.journalapp.journals.data;

import android.support.v4.util.ArrayMap;

/**
 * This is the endpoint for the data source. Typically, it would be a SQLite db and/or a server
 * API. In this example, we fake this by creating the data on the fly.
 */
public final class JournalsServiceApiEndpoint {

    static {
        DATA = new ArrayMap(2);
        addJournal("Oh yes!", "I demand trial by Unit testing", null);
        addJournal("Espresso", "UI Testing for Android", null);
    }

    private final static ArrayMap<String, Journal> DATA;

    private static void addJournal(String title, String description, String imageUrl) {
        Journal newJournal = new Journal(title, description, imageUrl);
        DATA.put(newJournal.getId(), newJournal);
    }

    /**
     * @return the Journals to show when starting the app.
     */
    public static ArrayMap<String, Journal> loadPersistedJournals() {
        return DATA;
    }
}

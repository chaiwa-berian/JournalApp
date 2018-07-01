package com.bantulogic.core.journalapp.journals.data;

import android.os.Handler;
import android.support.v4.util.ArrayMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Journal Service API that adds a latency simulating network.
 */
public class JournalsServiceApiImpl implements JournalsServiceApi {

    private static final int SERVICE_LATENCY_IN_MILLIS = 2000;
    private static final ArrayMap<String, Journal> JOURNALS_SERVICE_DATA =
            JournalsServiceApiEndpoint.loadPersistedJournals();

    @Override
    public void getAllJournals(final JournalsServiceCallback callback) {
        // Simulate network by delaying the execution.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Journal> journals = new ArrayList<>(JOURNALS_SERVICE_DATA.values());
                callback.onLoaded(journals);
            }
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    @Override
    public void getJournal(final String journalId, final JournalsServiceCallback callback) {
        //TODO: Add network latency here too.
        Journal journal = JOURNALS_SERVICE_DATA.get(journalId);
        callback.onLoaded(journal);
    }

    @Override
    public void saveJournal(Journal journal) {
        JOURNALS_SERVICE_DATA.put(journal.getId(), journal);
    }

}

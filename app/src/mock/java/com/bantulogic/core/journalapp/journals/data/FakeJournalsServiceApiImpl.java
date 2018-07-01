package com.bantulogic.core.journalapp.journals.data;

import android.support.annotation.VisibleForTesting;
import android.support.v4.util.ArrayMap;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Fake implementation of {@link JournalsServiceApi} to inject a fake service in a hermetic test.
 */
public class FakeJournalsServiceApiImpl implements JournalsServiceApi {

    // TODO replace this with a new test specific data set.
    private static final ArrayMap<String, Journal> JOURNALS_SERVICE_DATA = new ArrayMap();

    @Override
    public void getAllJournal(JournalsServiceCallback<List<Journal>> callback) {
        callback.onLoaded(Lists.newArrayList(JOURNALS_SERVICE_DATA.values()));
    }

    @Override
    public void getJournal(String journalId, NotesServiceCallback<Journal> callback) {
        Journal journal = JOURNALS_SERVICE_DATA.get(journalId);
        callback.onLoaded(journal);
    }

    @Override
    public void saveJournal(Journal journal) {
        JOURNALS_SERVICE_DATA.put(journal.getId(), journal);
    }

    @VisibleForTesting
    public static void addNotes(Journal... journals) {
        for (Journal journal : journals) {
            JOURNALS_SERVICE_DATA.put(journal.getId(), journal);
        }
    }
}

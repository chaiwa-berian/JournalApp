package com.bantulogic.core.journalapp.journals.data;

import java.util.List;

/**
 * Defines an interface to the service API that is used by this application. All data request should
 * be piped through this interface.
 */
public interface JournalsServiceApi {

    interface JournalsServiceCallback<T> {

        void onLoaded(T journals);
    }

    void getAllJournals(JournalsServiceCallback<List<Journal>> callback);

    void getJournal(String journalId, JournalsServiceCallback<Journal> callback);

    void saveJournal(Journal journal);
}

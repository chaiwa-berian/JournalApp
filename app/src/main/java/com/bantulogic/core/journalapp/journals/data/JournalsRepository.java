package com.bantulogic.core.journalapp.journals.data;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Main entry point for accessing Journal data.
 */
public interface JournalsRepository {

    interface LoadJournalsCallback {

        void onJournalsLoaded(List<Journal> journals);
    }

    interface GetJournalCallback {

        void onJournalLoaded(Journal journal);
    }

    void getJournals(@NonNull LoadJournalsCallback callback);

    void getJournal(@NonNull String journalId, @NonNull GetJournalCallback callback);

    void saveJournal(@NonNull Journal journal);

    void refreshData();

}

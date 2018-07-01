package com.bantulogic.core.journalapp.journals.data;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

public class JournalRepositories {

    private JournalRepositories() {
        // no instance
    }

    private static JournalsRepository repository = null;

    public synchronized static JournalsRepository getInMemoryRepoInstance(@NonNull JournalsServiceApi journalsServiceApi) {
        checkNotNull(journalsServiceApi);
        if (null == repository) {
            repository = new InMemoryJournalsRepository(journalsServiceApi);
        }
        return repository;
    }
}
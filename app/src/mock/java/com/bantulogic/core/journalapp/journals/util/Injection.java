package com.bantulogic.core.journalapp.journals.util;

import com.bantulogic.core.journalapp.journals.data.FakeJournalsServiceApiImpl;
import com.bantulogic.core.journalapp.journals.data.JournalRepositories;
import com.bantulogic.core.journalapp.journals.data.JournalsRepository;

/**
 * Enables injection of mock implementations for {@link ImageFile} and
 * {@link JournalsRepository} at compile time. This is useful for testing, since it allows us to use
 * a fake instance of the class to isolate the dependencies and run a test hermetically.
 */
public class Injection {

    public static ImageFile provideImageFile() {
        return new FakeImageFileImpl();
    }

    public static JournalsRepository provideJournalsRepository() {
        return JournalRepositories.getInMemoryRepoInstance(new FakeJournalsServiceApiImpl());
    }
}
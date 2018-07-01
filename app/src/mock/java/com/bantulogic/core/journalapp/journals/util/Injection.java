package com.bantulogic.core.journalapp.journals.util;
/**
 * Enables injection of mock implementations for {@link ImageFile} and
 * {@link JournalssRepository} at compile time. This is useful for testing, since it allows us to use
 * a fake instance of the class to isolate the dependencies and run a test hermetically.
 */
public class Injection {

    public static ImageFile provideImageFile() {
        return new FakeImageFileImpl();
    }

    public static JournalsRepository provideJournalsRepository() {
        return JournalsRepositories.getInMemoryRepoInstance(new FakeJournalsServiceApiImpl());
    }
}
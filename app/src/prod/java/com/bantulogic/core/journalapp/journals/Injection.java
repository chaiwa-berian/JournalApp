package com.bantulogic.core.journalapp.journals;

import com.bantulogic.core.journalapp.journals.data.JournalRepositories;
import com.bantulogic.core.journalapp.journals.data.JournalsRepository;
import com.bantulogic.core.journalapp.journals.data.JournalsServiceApiImpl;
import com.bantulogic.core.journalapp.journals.util.ImageFile;
import com.bantulogic.core.journalapp.journals.util.ImageFileImpl;

/**
 * Enables injection of production implementations for {@link ImageFile} and
 * {@link JournalsRepository} at compile time.
 */
public class Injection {
    public static ImageFile provideImageFile() {
        return new ImageFileImpl();
    }

    public static JournalsRepository provideJournalsRepository() {
        return JournalRepositories.getInMemoryRepoInstance(new JournalsServiceApiImpl());
    }
}

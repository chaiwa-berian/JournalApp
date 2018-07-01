package com.bantulogic.core.journalapp.journals;
/**
 * Enables injection of production implementations for {@link ImageFile} and
 * {@link NotesRepository} at compile time.
 */
public class Injection {
    public static ImageFile provideImageFile() {
        return new ImageFileImpl();
    }

    public static NotesRepository provideNotesRepository() {
        return NoteRepositories.getInMemoryRepoInstance(new NotesServiceApiImpl());
    }
}

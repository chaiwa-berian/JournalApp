package com.bantulogic.core.journalapp.journals.data;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.google.common.collect.ImmutableList;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Concrete implementation to load journals from the a data source.
 */
public class InMemoryJournalsRepository implements JournalsRepository {

    private final JournalsServiceApi mJournalsServiceApi;

    /**
     * This method has reduced visibility for testing and is only visible to tests in the same
     * package.
     */
    @VisibleForTesting
    List<Journal> mCachedJournals;

    public InMemoryJournalsRepository(@NonNull JournalsServiceApi journalsServiceApi) {
        mJournalsServiceApi = checkNotNull(journalsServiceApi);
    }

    @Override
    public void getJournals(@NonNull final LoadJournalsCallback callback) {
        checkNotNull(callback);
        // Load from API only if needed.
        if (mCachedJournals == null) {
            mJournalsServiceApi.getAllJournals(new JournalsServiceApi.JournalsServiceCallback<List<Journal>>() {
                @Override
                public void onLoaded(List<Journal> journals) {
                    mCachedJournals = ImmutableList.copyOf(journals);
                    callback.onJournalsLoaded(mCachedJournals);
                }
            });
        } else {
            callback.onJournalsLoaded(mCachedJournals);
        }
    }

    @Override
    public void saveJournal(@NonNull Journal journal) {
        checkNotNull(journal);
        mJournalsServiceApi.saveJournal(journal);
        refreshData();
    }

    @Override
    public void getJournal(@NonNull final String journalId, @NonNull final GetJournalCallback callback) {
        checkNotNull(journalId);
        checkNotNull(callback);
        // Load journals matching the id always directly from the API.
        mJournalsServiceApi.getJournal(journalId, new JournalsServiceApi.JournalsServiceCallback<Journal>() {
            @Override
            public void onLoaded(Journal journal) {
                callback.onJournalLoaded(journal);
            }
        });
    }

    @Override
    public void refreshData() {
        mCachedJournals = null;
    }

}
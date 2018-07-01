package com.bantulogic.core.journalapp.journals.journals;


import android.support.annotation.NonNull;

import com.bantulogic.core.journalapp.journals.data.Journal;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface JournalsContract {

    interface View {

        void setProgressIndicator(boolean active);

        void showJournals(List<Journal> journals);

        void showAddJournal();

        void showJournalDetailUi(String journalId);
    }

    interface UserActionsListener {

        void loadJournals(boolean forceUpdate);

        void addNewJournal();

        void openJournalDetails(@NonNull Journal requestedJournal);
    }
}

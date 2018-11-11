package alayacare.testapp.ui.addnote

import alayacare.testapp.R
import alayacare.testapp.data.model.Note
import alayacare.testapp.data.repository.NoteRepository
import io.reactivex.disposables.CompositeDisposable
import java.util.Date

class AddNotePresenter(private val noteRepository: NoteRepository) : IAddNote.Presenter {

    private var mView: IAddNote.View? = null
    private var mCompositeDisposable: CompositeDisposable? = null

    override fun attachView(view: IAddNote.View) {
        mCompositeDisposable = CompositeDisposable()
        mView = view
    }

    override fun detachView() {
        mCompositeDisposable?.clear()
        mView = null
    }

    override fun addNote(note: String) {
        if (note.isNotEmpty()) {
            noteRepository.addNote(Note(note, Date().time))
            mView?.closeActivity()
        } else {
            mView?.showErrorMessage(R.string.error_note_empty)
        }
    }
}

package alayacare.testapp.ui.addnote

import alayacare.testapp.R
import alayacare.testapp.data.model.Note
import alayacare.testapp.data.repository.NoteRepository
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
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
                    .subscribeOn(Schedulers.newThread())
                    .unsubscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : Observer<Long> {
                        override fun onComplete() {
                            mView?.hideProgressBar()
                        }

                        override fun onSubscribe(disposable: Disposable) {
                            mCompositeDisposable?.add(disposable)
                            mView?.showProgressBar()
                        }

                        override fun onNext(notes: Long) {
                            // IMPROVEMENTS
                            // Here we could proceed to some check to know if the insertion went fine
                            // Then decided to go on or not
                            mView?.closeActivity()
                        }

                        override fun onError(e: Throwable) {
                            mView?.showErrorMessage(R.string.error_unexpected)
                            mView?.hideProgressBar()
                        }
                    })
        } else {
            mView?.showErrorMessage(R.string.error_note_empty)
        }
    }
}

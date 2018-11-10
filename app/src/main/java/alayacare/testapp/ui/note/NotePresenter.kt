package alayacare.testapp.ui.note

import alayacare.testapp.data.model.Note
import alayacare.testapp.data.repository.NoteRepository
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class NotePresenter(private val noteRepository: NoteRepository) : INote.Presenter {

    private var mView: INote.View? = null
    private var mCompositeDisposable: CompositeDisposable? = null

    override fun attachView(view: INote.View) {
        mCompositeDisposable = CompositeDisposable()
        mView = view
    }

    override fun detachView() {
        mCompositeDisposable?.clear()
        mView = null
    }

    override fun loadNotes() {
        noteRepository.getNotes()
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ArrayList<Note>> {
                    override fun onComplete() {
                        mView?.hideProgressBar()
                    }

                    override fun onSubscribe(disposable: Disposable) {
                        mCompositeDisposable?.add(disposable)
                        mView?.showProgressBar()
                    }

                    override fun onNext(notes: ArrayList<Note>) {
                        mView?.showNotes(notes)
                    }

                    override fun onError(e: Throwable) {
                        mView?.hideProgressBar()
                    }
                })
    }

    override fun addNote(note: Note) {
        noteRepository.addNote(note)
    }

}
package alayacare.testapp.ui.note

import alayacare.testapp.R
import alayacare.testapp.data.model.Note
import alayacare.testapp.data.repository.NoteRepository
import alayacare.testapp.ui.base.BaseActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_note.*

class NoteActivity : BaseActivity(), INote.View {

    private val mPresenter = NotePresenter(NoteRepository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        activityProgressBar = progress_bar_notes
        mPresenter.attachView(this)
        mPresenter.loadNotes()
    }

    override fun showNotes(notes: ArrayList<Note>) {
        // Temporary log the notes until task 2 to make sure we get them from the mock API
        notes.forEach { Log.d(NoteActivity::class.java.simpleName, it.note) }
    }

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }
}
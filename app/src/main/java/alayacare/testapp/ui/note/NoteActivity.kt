package alayacare.testapp.ui.note

import alayacare.testapp.R
import alayacare.testapp.data.model.Note
import alayacare.testapp.data.repository.NoteRepository
import alayacare.testapp.ui.base.BaseActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_note.*
import java.util.*

class NoteActivity : BaseActivity(), INote.View {

    private val mPresenter = NotePresenter(NoteRepository)
    private val mAdapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        activityProgressBar = progress_bar_notes

        recycler_view_notes.layoutManager = LinearLayoutManager(this)
        recycler_view_notes.adapter = mAdapter

        mPresenter.attachView(this)

        // Temporary faking the insertion of notes
        repeat(10) { mPresenter.addNote(Note("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec gravida, metus in pellentesque ullamcorper, quam est venenatis massa, sed tincidunt turpis dui sed nibh. Curabitur varius ante felis, non lacinia mi porta et. ", Date().time)) }

        mPresenter.loadNotes()
    }

    override fun showNotes(notes: ArrayList<Note>) {
        mAdapter.setData(notes)
    }

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }
}
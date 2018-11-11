package alayacare.testapp.ui.note

import alayacare.testapp.R
import alayacare.testapp.data.model.Note
import alayacare.testapp.data.repository.NoteRepository
import alayacare.testapp.ui.addnote.AddNoteActivity
import alayacare.testapp.ui.base.BaseActivity
import android.content.Intent
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

        fab_add_note.setOnClickListener { addNote() }

        mPresenter.attachView(this)
    }

    override fun onResume() {
        super.onResume()
        mPresenter.loadNotes()
    }

    private fun addNote() {
        startActivity(Intent(this, AddNoteActivity::class.java))
    }

    override fun showNotes(notes: ArrayList<Note>) {
        mAdapter.setData(notes)
    }

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }
}
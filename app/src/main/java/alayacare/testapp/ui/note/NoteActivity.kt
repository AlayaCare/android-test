package alayacare.testapp.ui.note

import alayacare.testapp.R
import alayacare.testapp.data.model.Note
import alayacare.testapp.data.repository.NoteRepository
import alayacare.testapp.ui.addnote.AddNoteActivity
import alayacare.testapp.ui.base.BaseActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_note.*
import java.util.*
import java.util.concurrent.TimeUnit

class NoteActivity : BaseActivity(), INote.View {

    private lateinit var mPresenter: NotePresenter
    private val mAdapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        activityProgressBar = progress_bar_notes

        mPresenter = NotePresenter(NoteRepository(application))
        mPresenter.attachView(this)


        recycler_view_notes.layoutManager = LinearLayoutManager(this)
        recycler_view_notes.adapter = mAdapter

        fab_add_note.setOnClickListener { addNote() }
    }

    override fun onResume() {
        super.onResume()
        setupSearchNote()
    }

    private fun addNote() {
        startActivity(Intent(this, AddNoteActivity::class.java))
    }

    override fun showNotes(notes: ArrayList<Note>) {
        recycler_view_notes.visibility = View.VISIBLE
        empty_note_list.visibility = View.GONE
        empty_search_result.visibility = View.GONE
        mAdapter.setData(notes)
    }

    override fun showSearchNoResult() {
        recycler_view_notes.visibility = View.GONE
        empty_note_list.visibility = View.GONE
        empty_search_result.visibility = View.VISIBLE
    }

    override fun showNoNotes() {
        recycler_view_notes.visibility = View.GONE
        empty_note_list.visibility = View.VISIBLE
        empty_search_result.visibility = View.GONE
    }

    @SuppressLint("CheckResult")
    private fun setupSearchNote() {
        RxTextView.textChanges(edit_text_search_bar_note)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.isEmpty()) {
                        mPresenter.loadNotes()
                    } else {
                        mPresenter.searchNote(it.toString())
                    }
                }
    }

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }
}
package alayacare.testapp.home

import alayacare.testapp.R
import alayacare.testapp.data.model.Note
import alayacare.testapp.home.vm.HomeViewModel
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_note.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity(), AddNewNoteDialog.AddNewNoteCallback {

    private lateinit var binding: alayacare.testapp.databinding.ActivityNoteBinding
    private val viewModel: HomeViewModel by viewModel()
    private val adapter: NoteListAdapter = NoteListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_note)

        binding.noteList.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        viewModel.notes.observe(this, Observer { onNewData(it) })
        adapter.setItemClickListener { note -> viewModel.removeNote(note) }

        note_list.adapter = adapter

        fab.setOnClickListener {
            AddNewNoteDialog(this@HomeActivity).show(supportFragmentManager, "addNew")
        }

        searchText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.search(s.toString())
            }
        })
    }

    override fun onStart() {
        super.onStart()
        loadNotes()
    }

    private fun onNewData(items: List<Note>?) {
        items ?: return
        adapter.updateNoteList(items)
        progress.visibility = GONE
    }

    private fun loadNotes() {
        progress.visibility = VISIBLE
        viewModel.loadNotes()
    }

    override fun onNewNote(text: String) {
        viewModel.addNote(Note(text = text))
    }

}
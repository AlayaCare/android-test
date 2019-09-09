package alayacare.testapp.home

import alayacare.testapp.R
import alayacare.testapp.data.model.Note
import alayacare.testapp.home.vm.HomeViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_note.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity: AppCompatActivity(){
    private lateinit var binding: alayacare.testapp.databinding.ActivityNoteBinding
    private val viewModel: HomeViewModel by viewModel()
    private val adapter: NoteListAdapter = NoteListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState )
        binding = DataBindingUtil.setContentView(this, R.layout.activity_note)

        binding.noteList.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel.notes.observe(this, Observer {onLoaded(it)})

        note_list.adapter = adapter

        binding.noteList.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager : LinearLayoutManager = binding.noteList.layoutManager as LinearLayoutManager
                if(layoutManager.findLastVisibleItemPosition() == layoutManager.itemCount-2){
                    loadNotes()
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    private fun onLoaded(items: List<Note>) {
        adapter.updateNoteList(items)
    }

    private fun loadNotes(){
        viewModel.getNotesAsync()
    }
}
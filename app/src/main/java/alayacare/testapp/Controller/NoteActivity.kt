package alayacare.testapp.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.HandlerThread
import alayacare.testapp.R
import alayacare.testapp.viewModel.NotesViewModel
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Handler


class NoteActivity : AppCompatActivity() {

    private var notesViewModel : NotesViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
        loadData()
    }

    fun loadData() {
        var handler = HandlerThread(" ")
        handler.start()
        val h = Handler(handler.looper)

        h.post {
            notesViewModel?.getNotesList()?.observe( this, Observer {
                notes -> notes.let {
                    //TODO: display the list
                }
            })
        }


    }
}

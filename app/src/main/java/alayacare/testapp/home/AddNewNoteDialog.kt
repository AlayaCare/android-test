package alayacare.testapp.home

import alayacare.testapp.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_add_item.*

class AddNewNoteDialog(val callback: AddNewNoteCallback): DialogFragment(){


    // private var txt: EditText? = null

    interface AddNewNoteCallback{
        fun onNewNote(text: String)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAdd.setOnClickListener{onAddClicked()}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_add_item, container);
    }

    private fun onAddClicked() {
        callback.onNewNote(txt?.text.toString())
        dismiss()
    }
}
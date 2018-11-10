package alayacare.testapp.ui.note

import alayacare.testapp.R
import alayacare.testapp.data.model.Note
import alayacare.testapp.ui.base.BaseRecyclerViewAdapter
import alayacare.testapp.ui.base.BaseViewHolder
import alayacare.testapp.utils.DATE_FORMAT
import alayacare.testapp.utils.getFormattedDate
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdapter : BaseRecyclerViewAdapter<Note, BaseViewHolder>() {

    override fun createMyViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
            BaseViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_note, parent, false))

    override fun bindMyViewHolder(holder: BaseViewHolder, position: Int) {
        getItem(position)?.let { note ->
            holder.itemView.note_preview_text.text = note.note
            holder.itemView.note_date.text = getFormattedDate(note.time, DATE_FORMAT)
        }
    }
}
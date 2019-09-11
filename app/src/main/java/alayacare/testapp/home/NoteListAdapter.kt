package alayacare.testapp.home

import alayacare.testapp.R
import alayacare.testapp.data.model.Note
import alayacare.testapp.databinding.ItemNoteBinding
import alayacare.testapp.home.vm.NoteViewModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class NoteListAdapter: RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {
    private val noteList: MutableList<Note> = mutableListOf()
    var onItemClickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemNoteBinding =
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_note, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = noteList.size

    fun setItemClickListener(onclick: View.OnClickListener) {
        onItemClickListener = onclick
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(noteList[position])
    }

    fun updateNoteList(newNotes: List<Note>) {
        val diffCallback = NoteDiffCallback(noteList, newNotes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        noteList.clear()
        noteList.addAll(newNotes)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = NoteViewModel()

        fun bind(video: Note) {
            viewModel.noteLive.value = video
            binding.viewModel = viewModel
            binding.root.tag = video
            binding.root.setOnClickListener(onItemClickListener)
        }
    }

    internal class NoteDiffCallback(private val oldList: List<Note>,
                                    private val newList: List<Note>): DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].id == newList[newItemPosition].id

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].id == newList[newItemPosition].id
    }
}
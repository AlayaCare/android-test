package alayacare.testapp.ui.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Base typed RecyclerView adapter
 */
abstract class BaseRecyclerViewAdapter<Item, ViewHolder : BaseViewHolder> : RecyclerView.Adapter<ViewHolder>() {

    protected var mContext: Context? = null
    protected var mItems: List<Item> = ArrayList()
    private var mOnItemClickListener: OnItemClickListener<Item>? = null

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<Item>?) {
        mOnItemClickListener = onItemClickListener
    }

    open fun setData(items: List<Item>) {
        mItems = items
        notifyDataSetChanged()
    }

    @JvmName("setDataVararg")
    fun setData(vararg items: Item) {
        setData(items.toList())
    }

    fun setData(items: Array<Item>) {
        setData(items.toList())
    }

    override fun getItemCount(): Int = mItems.size

    fun getItem(position: Int): Item? = if (position >= 0 && position < mItems.size) mItems[position] else null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (mContext == null) {
            mContext = parent.context
        }
        return createMyViewHolder(parent, viewType)
    }

    abstract fun createMyViewHolder(parent: ViewGroup, viewType: Int): ViewHolder

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindMyViewHolder(holder, position)
        mOnItemClickListener?.let { listener -> holder.itemView.setOnClickListener { listener.onItemClick(mItems[position], holder.adapterPosition) } }
    }

    abstract fun bindMyViewHolder(holder: BaseViewHolder, position: Int)

    interface OnItemClickListener<in Item> {

        fun onItemClick(item: Item, position: Int)
    }

}
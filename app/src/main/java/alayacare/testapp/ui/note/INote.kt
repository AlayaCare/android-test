package alayacare.testapp.ui.note

import alayacare.testapp.data.model.Note
import alayacare.testapp.ui.base.IPresenter
import alayacare.testapp.ui.base.IView

interface INote {

    interface View : IView {
        fun showNotes(notes: ArrayList<Note>)
        fun showNoNotes()
        fun showSearchNoResult()
    }

    interface Presenter : IPresenter<View> {
        fun loadNotes()
    }
}
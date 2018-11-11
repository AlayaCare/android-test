package alayacare.testapp.ui.addnote

import alayacare.testapp.ui.base.IPresenter
import alayacare.testapp.ui.base.IView

interface IAddNote {

    interface View : IView {
        fun closeActivity()
    }

    interface Presenter : IPresenter<View> {
        fun addNote(note: String)
    }
}
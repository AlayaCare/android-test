package alayacare.testapp.home.vm

import alayacare.testapp.base.BaseViewModel
import alayacare.testapp.data.model.Note
import androidx.lifecycle.MutableLiveData

class NoteViewModel: BaseViewModel(){
    val noteLive = MutableLiveData<Note>()
}
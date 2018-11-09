package alayacare.testapp.ui.base

import alayacare.testapp.utils.hide
import alayacare.testapp.utils.show
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar

open class BaseActivity: AppCompatActivity(), IView {

    var activityProgressBar: ProgressBar? = null

    override fun showProgressBar() {
        activityProgressBar?.show()
    }

    override fun hideProgressBar() {
        activityProgressBar?.hide()
    }

}
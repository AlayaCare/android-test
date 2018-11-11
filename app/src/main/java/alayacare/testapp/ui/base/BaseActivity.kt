package alayacare.testapp.ui.base

import alayacare.testapp.utils.hide
import alayacare.testapp.utils.show
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import android.widget.Toast

open class BaseActivity : AppCompatActivity(), IView {

    var activityProgressBar: ProgressBar? = null

    override fun showProgressBar() {
        activityProgressBar?.show()
    }

    override fun hideProgressBar() {
        activityProgressBar?.hide()
    }

    override fun showErrorMessage(errorMessage: String?) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }

    override fun showErrorMessage(resId: Int) {
        showErrorMessage(getString(resId))
    }

}
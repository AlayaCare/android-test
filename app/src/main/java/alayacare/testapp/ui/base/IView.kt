package alayacare.testapp.ui.base

/**
 * The base interface for a View. All Views should implement it.
 */
interface IView {

    fun showProgressBar()

    fun hideProgressBar()

    fun showErrorMessage(errorMessage: String?)

    fun showErrorMessage(resId: Int)
}
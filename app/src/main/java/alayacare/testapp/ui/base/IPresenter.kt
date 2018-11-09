package alayacare.testapp.ui.base

/**
 * The base interface for a Presenter. All Presenters should implement it.
 */
interface IPresenter<in T> {

    fun attachView(view: T)

    fun detachView()

}
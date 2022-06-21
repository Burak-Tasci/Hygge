package mobi.appcent.apptern.ui.base

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import mobi.appcent.apptern.R
import mobi.appcent.apptern.utils.views.ProgressDialog

open class BaseFragment : Fragment() {
    private var progressDialog: Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val window: Window? = activity?.window
        window?.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.opac_blue)

        progressDialog = context?.let {
            ProgressDialog(it)
        }
    }

    fun showProgress() {
        progressDialog?.let {
            it.show()
        }
    }

    fun hideProgress() {
        progressDialog?.let {
            it.hide()
        }
    }
}
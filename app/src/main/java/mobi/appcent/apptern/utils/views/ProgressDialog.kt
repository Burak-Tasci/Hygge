package mobi.appcent.apptern.utils.views

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import mobi.appcent.apptern.R

class ProgressDialog(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.progress_dialog)
        this.window?.setBackgroundDrawableResource(R.color.transparent)
        this.setCancelable(false)
    }
}
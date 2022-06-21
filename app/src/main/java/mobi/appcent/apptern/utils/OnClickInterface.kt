package mobi.appcent.apptern.utils

import android.view.View
import mobi.appcent.apptern.data.model.remote.response.ProductItem

interface OnClickInterface {
    fun onItemClicked(item: ProductItem)
}
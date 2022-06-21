package mobi.appcent.apptern.data.model.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Store(
    val storeName: String? = null,
    val lat: String? = null,
    val longitude: String? = null
) : Parcelable
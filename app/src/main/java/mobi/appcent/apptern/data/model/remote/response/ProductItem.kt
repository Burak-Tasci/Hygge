package mobi.appcent.apptern.data.model.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductItem(
    val currentStore: Store? = null,
    val id: Int? = null,
    val newPrice: Double? = null,
    val oldPrice: Double? = null,
    val productImage: String? = null,
    val productName: String? = null,
    val quantity: Int? = null,
    val type: String? = null
): Parcelable
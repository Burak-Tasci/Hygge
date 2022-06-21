package mobi.appcent.apptern.data.model.remote.response

data class ProductItem(
    val currentStore: Store? = null,
    val id: Int? = null,
    val newPrice: Double? = null,
    val oldPrice: Double? = null,
    val productImage: String? = null,
    val productName: String? = null,
    val quantity: Int? = null,
    val type: String? = null
)

data class Store(
    val storeName: String? = null,
    val lat: String? = null,
    val longitude: String? = null
)
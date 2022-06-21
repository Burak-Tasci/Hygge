package mobi.appcent.apptern.data.model.remote.response

data class BasketResponse(
    val id: Int? = null,
    val token: String? = null,
    val products: MutableList<ProductItem>? = mutableListOf()
)

package mobi.appcent.apptern.data.model.remote.response

data class BaseResponse<T>(
    val message: String? = null,
    val result: T? = null,
    val status: String? = null,
    val statusCode: Int? = null
)
package mobi.appcent.apptern.data.network.service

import mobi.appcent.apptern.data.model.remote.response.BaseResponse
import mobi.appcent.apptern.data.model.remote.response.BasketResponse
import mobi.appcent.apptern.data.model.remote.response.ProductItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductService {
    @GET("/products")
    fun getProductList(): Call<BaseResponse<MutableList<ProductItem>>>

    @GET("/products/{id}")
    fun getProductDetail(@Path("id") productID: Int): Call<BaseResponse<ProductItem>>

    @POST("/addtocart/{id}/{prodId}")
    fun addToCard(
        @Path("id") basketID: Int,
        @Path("prodId") productID: Int
    ): Call<BaseResponse<BasketResponse>>

    @GET("/clearcart/{id}")
    fun clearCard(
        @Path("id") basketID: Int
    ): Call<BaseResponse<BasketResponse>>

    @GET("/removeproduct/{id}/{productId}")
    fun removeProductFromCard(
        @Path("id") basketID: Int,
        @Path("productId") productID: Int
    ): Call<BaseResponse<BasketResponse>>

    @GET("/cart/{id}")
    fun getCard(
        @Path("id") basketID: Int
    ): Call<BaseResponse<BasketResponse>>
}
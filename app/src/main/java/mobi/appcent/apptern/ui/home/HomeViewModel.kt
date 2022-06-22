package mobi.appcent.apptern.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mobi.appcent.apptern.data.model.remote.response.BaseResponse
import mobi.appcent.apptern.data.model.remote.response.ProductItem
import mobi.appcent.apptern.data.network.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.text.Typography.dagger

class HomeViewModel(): ViewModel() {
    val productList = MutableLiveData<StatusModel<MutableList<ProductItem>>>()

    fun getProductList() {
        productList.postValue(OnLoading)
        NetworkHelper().productService?.getProductList()
            ?.enqueue(object : Callback<BaseResponse<MutableList<ProductItem>>> {
                override fun onResponse(
                    call: Call<BaseResponse<MutableList<ProductItem>>>,
                    response: Response<BaseResponse<MutableList<ProductItem>>>
                ) {
                    productList.postValue(OnSuccess(response.body()?.result))
                }

                override fun onFailure(
                    call: Call<BaseResponse<MutableList<ProductItem>>>,
                    t: Throwable
                ) {
                    productList.postValue(OnError<String>("Error"))
                }
            })
    }
}
package mobi.appcent.apptern.data.network

import mobi.appcent.apptern.BuildConfig
import mobi.appcent.apptern.data.network.service.ProductService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkHelper {
    var productService: ProductService? = null

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_ADDRESS)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        productService = retrofit.create(ProductService::class.java)
    }

    private fun getClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
        httpClient.readTimeout(60, TimeUnit.SECONDS)
        httpClient.writeTimeout(60, TimeUnit.SECONDS)
        httpClient.addInterceptor(createHttpLoggingInterceptor(BuildConfig.DEBUG))
        return httpClient.build()
    }

    private fun createHttpLoggingInterceptor(debugMode: Boolean): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (debugMode) httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        else httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        return httpLoggingInterceptor
    }
}
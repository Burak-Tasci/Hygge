package mobi.appcent.apptern.utils.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import mobi.appcent.apptern.R
import mobi.appcent.apptern.databinding.HorizontalCounterBinding

class HorizontalCounter @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): LinearLayout(context, attrs,defStyleAttr){

    var count = MutableLiveData(0)
    private val binding = HorizontalCounterBinding.inflate(
        LayoutInflater.from(context)
    )

    init {
        setButtons()
    }

    private fun setButtons() {
        with(binding){
            tvAdd.setOnClickListener{
                count.value?.plus(1)
                tvCount.text = count.toString()
            }
            tvMinus.setOnClickListener {
                count.value?.minus(1)
                tvCount.text = count.toString()
            }
        }
    }


}
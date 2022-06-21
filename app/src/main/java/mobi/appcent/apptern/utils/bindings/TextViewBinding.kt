package mobi.appcent.apptern.utils.bindings

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter

@BindingAdapter("setPrice")
fun setPrice(view: AppCompatTextView, price: Double) {
    view.text = "₺$price"
}

package mobi.appcent.apptern.utils.bindings

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("setImageView")
fun setImageView(view: AppCompatImageView, url: String) {
    Picasso.get().load(url).into(view)
}

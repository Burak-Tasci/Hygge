package mobi.appcent.apptern.utils.extension

import androidx.appcompat.widget.AppCompatImageView
import com.squareup.picasso.Picasso

fun String.uploadImageView(imageView: AppCompatImageView) {
    Picasso.get().load(this).into(imageView)
}
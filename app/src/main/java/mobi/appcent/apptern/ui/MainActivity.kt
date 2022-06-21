package mobi.appcent.apptern.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import mobi.appcent.apptern.databinding.ActivityMainBinding


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun isEnabledBackButton(isEnabled: Boolean) {
        binding.toolbar.ivBack.visibility =
            if (isEnabled) View.VISIBLE else View.GONE
    }
}
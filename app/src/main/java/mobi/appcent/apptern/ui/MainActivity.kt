package mobi.appcent.apptern.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import mobi.appcent.apptern.databinding.ActivityMainBinding
import mobi.appcent.apptern.manager.NavigationManager


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        NavigationManager().startHomeFragment(supportFragmentManager, true)
    }

    fun isEnabledBackButton(isEnabled: Boolean) {
        if (isEnabled) binding.toolbar.ivBack.visibility = View.VISIBLE
        else binding.toolbar.ivBack.visibility = View.GONE
    }
}
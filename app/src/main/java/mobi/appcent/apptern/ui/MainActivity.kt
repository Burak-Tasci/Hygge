package mobi.appcent.apptern.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import mobi.appcent.apptern.R
import mobi.appcent.apptern.databinding.ActivityMainBinding


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBackButton()
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
    }

    fun isEnabledBackButton(isEnabled: Boolean) {
        binding.toolbar.ivBack.visibility =
            if (isEnabled) View.VISIBLE else View.GONE
    }
    fun setBackButton(){
        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}
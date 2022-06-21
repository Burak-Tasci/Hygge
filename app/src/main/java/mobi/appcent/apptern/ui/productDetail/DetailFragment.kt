package mobi.appcent.apptern.ui.productDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import mobi.appcent.apptern.databinding.FragmentDetailBinding
import mobi.appcent.apptern.databinding.FragmentHomeBinding
import mobi.appcent.apptern.ui.base.BaseFragment
import mobi.appcent.apptern.ui.home.HomeViewModel

@AndroidEntryPoint
class DetailFragment: BaseFragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel by activityViewModels<DetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }
}
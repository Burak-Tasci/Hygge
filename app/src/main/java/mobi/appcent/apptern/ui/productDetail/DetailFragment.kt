package mobi.appcent.apptern.ui.productDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import mobi.appcent.apptern.databinding.FragmentDetailBinding
import mobi.appcent.apptern.databinding.FragmentHomeBinding
import mobi.appcent.apptern.ui.MainActivity
import mobi.appcent.apptern.ui.base.BaseFragment
import mobi.appcent.apptern.ui.home.HomeViewModel

@AndroidEntryPoint
class DetailFragment: BaseFragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel by activityViewModels<DetailViewModel>()
    val args: DetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as MainActivity).isEnabledBackButton(true)
        binding = FragmentDetailBinding.inflate(layoutInflater)
        binding.productItem = args.item
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHorizontalCounter()
    }

    private fun setHorizontalCounter(){
        with(binding.horizontalCounter){

            tvCount.text = "1"
            tvAdd.setOnClickListener{
                val quantity = args.item.quantity
                if (tvCount.text.toString().toInt() <= (quantity ?: 10)){
                    tvCount.text = tvCount.text.toString().toInt().plus(1).toString()
                }
            }
            tvMinus.setOnClickListener {
                if (tvCount.text.toString().toInt() > 1){
                    tvCount.text = tvCount.text.toString().toInt().minus(1).toString()
                }
            }
        }
    }
}
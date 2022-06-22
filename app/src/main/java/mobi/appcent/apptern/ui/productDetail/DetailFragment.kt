package mobi.appcent.apptern.ui.productDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import mobi.appcent.apptern.data.model.remote.response.Store
import mobi.appcent.apptern.databinding.FragmentDetailBinding
import mobi.appcent.apptern.ui.MainActivity
import mobi.appcent.apptern.ui.base.BaseFragment

class DetailFragment: BaseFragment() {

    private lateinit var binding: FragmentDetailBinding
    val args: DetailFragmentArgs by navArgs()
    private lateinit var store: Store

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as MainActivity).isEnabledBackButton(true)
        binding = FragmentDetailBinding.inflate(layoutInflater)
        binding.productItem = args.item
        store = args.item.currentStore ?: Store()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHorizontalCounter()
        binding.tvWhichStore.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToMapsFragment(
                store
            )
            findNavController().navigate(action)
        }
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
package mobi.appcent.apptern.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import mobi.appcent.apptern.R
import mobi.appcent.apptern.data.model.remote.response.ProductItem
import mobi.appcent.apptern.data.network.OnError
import mobi.appcent.apptern.data.network.OnLoading
import mobi.appcent.apptern.data.network.OnSuccess
import mobi.appcent.apptern.databinding.FragmentHomeBinding
import mobi.appcent.apptern.ui.MainActivity
import mobi.appcent.apptern.ui.base.BaseFragment
import mobi.appcent.apptern.ui.home.adapter.ProductListAdapter
import mobi.appcent.apptern.utils.OnClickInterface
import mobi.appcent.apptern.utils.extension.showToast

@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by activityViewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        setToolbar()
        initObserver()
        initRecycler()
        viewModel.getProductList()
        return binding.root
    }

    private fun setToolbar() {
        (activity as MainActivity).isEnabledBackButton(false)
    }

    private fun initObserver() {
        viewModel.productList.observe(viewLifecycleOwner) { status ->
            when (status) {
                is OnLoading -> {
                    showProgress()
                }
                is OnSuccess -> {
                    hideProgress()
                    status.data?.let { productList ->
                        (binding.rvProductList.adapter as ProductListAdapter).submitList(
                            productList
                        )
                    }
                }
                is OnError<*> -> {
                    hideProgress()
                    status.msg?.let { context?.showToast(it) }
                }
            }
        }
    }

    private fun initRecycler() {
        binding.rvProductList.adapter = ProductListAdapter(object : OnClickInterface {
            override fun onItemClicked(item: ProductItem) {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                    item
                )
                findNavController().navigate(action)
            }
        })

    }
}
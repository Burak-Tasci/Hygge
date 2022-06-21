package mobi.appcent.apptern.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mobi.appcent.apptern.data.model.remote.response.ProductItem
import mobi.appcent.apptern.databinding.ItemProductListBinding
import mobi.appcent.apptern.utils.OnClickInterface

class ProductListAdapter(var clickInterface: OnClickInterface) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {
    var productList: MutableList<ProductItem> = mutableListOf()

    fun submitList(productList: MutableList<ProductItem>) {
        this.productList = productList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            ItemProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount() = productList.size

    inner class ViewHolder(val binding: ItemProductListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(productItem: ProductItem) {
            binding.productItem = productItem
            binding.root.setOnClickListener {
                clickInterface.onItemClicked(it, adapterPosition)
            }
        }
    }
}
package com.xpynx.assignment_a.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.xpynx.assignment_a.ProductDetailsActivity
import com.xpynx.assignment_a.R
import com.xpynx.assignment_a.model.Product

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_products, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val IVProduct: ImageView = itemView.findViewById(R.id.IVProduct)
        private val ll_view: View = itemView.findViewById(R.id.ll_view)
        private val TVProductName: TextView = itemView.findViewById(R.id.TVProductName)
        private val tVProductDescription: TextView = itemView.findViewById(R.id.tVProductDescription)

fun bind(product: Product) {
    val context: Context = itemView.context

    TVProductName.text = product.title
            tVProductDescription.text = product.description
        Picasso.get().load(product.thumbnail).into(IVProduct)

            ll_view.setOnClickListener {
         val intent = Intent(context, ProductDetailsActivity::class.java)
                intent.putExtra("product", product)
                context.startActivity(intent)
            }
        }
    }
}

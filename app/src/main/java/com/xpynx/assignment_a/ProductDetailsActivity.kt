package com.xpynx.assignment_a

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.xpynx.assignment_a.model.Product

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var product_title: TextView
    private lateinit var product_price: TextView
    private lateinit var product_description: TextView
    private lateinit var product_category: TextView
    private lateinit var product_rating: TextView
    private lateinit var product_stock: TextView
    private lateinit var product_brand: TextView
    private lateinit var product_dimensions: TextView
    private lateinit var product_warranty: TextView
    private lateinit var product_shipping: TextView
    private lateinit var product_availability: TextView
    private lateinit var product_return_policy: TextView
    private lateinit var product_minimum_order_quantity: TextView
    private lateinit var product_meta: TextView
    private lateinit var product_image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        init()

        val product = intent.getParcelableExtra<Product>("product")

        product?.let {
            Picasso.get()
                .load(it.thumbnail)
                .into(product_image)

            product_title.text = it.title
            product_price.text = "$${it.price}"
            product_description.text = it.description
            product_category.text = "Category: ${it.category}"
            product_rating.text = "Rating: ${it.rating}"
            product_stock.text = "Stock: ${it.stock}"
            product_brand.text = "Brand: ${it.brand}"
            product_dimensions.text = "Dimensions: ${it.dimensions.width} x ${it.dimensions.height} x ${it.dimensions.depth}"
            product_warranty.text = "Warranty: ${it.warrantyInformation}"
            product_shipping.text = "Shipping: ${it.shippingInformation}"
            product_availability.text = "Availability: ${it.availabilityStatus}"
            product_return_policy.text = "Return Policy: ${it.returnPolicy}"
            product_minimum_order_quantity.text = "Minimum Order Quantity: ${it.minimumOrderQuantity}"
            product_meta.text = "Created At: ${it.meta.createdAt}\nUpdated At: ${it.meta.updatedAt}\nBarcode: ${it.meta.barcode}\nQR Code: ${it.meta.qrCode}"
        }
    }

    private fun init() {
        product_image = findViewById(R.id.product_image)
        product_title = findViewById(R.id.product_title)
        product_price = findViewById(R.id.product_price)
        product_description = findViewById(R.id.product_description)
        product_category = findViewById(R.id.product_category)
        product_rating = findViewById(R.id.product_rating)
        product_stock = findViewById(R.id.product_stock)
        product_brand = findViewById(R.id.product_brand)
        product_dimensions = findViewById(R.id.product_dimensions)
        product_warranty = findViewById(R.id.product_warranty)
        product_shipping = findViewById(R.id.product_shipping)
        product_availability = findViewById(R.id.product_availability)
        product_return_policy = findViewById(R.id.product_return_policy)
        product_minimum_order_quantity = findViewById(R.id.product_minimum_order_quantity)
        product_meta = findViewById(R.id.product_meta)
    }
}

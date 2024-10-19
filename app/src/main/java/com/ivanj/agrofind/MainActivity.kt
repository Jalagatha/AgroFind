package com.ivanj.agrofind

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var productViewModel: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val etProductName: EditText = findViewById(R.id.etProductName)
        val etProductDescription: EditText = findViewById(R.id.etProductDescription)
        val btnGenerateQr: Button = findViewById(R.id.btnGenerateQr)
        val ivQrCode: ImageView = findViewById(R.id.ivQrCode)
        val rvProducts: RecyclerView = findViewById(R.id.rvProducts)

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        btnGenerateQr.setOnClickListener {
            val productName = etProductName.text.toString()
            val productDescription = etProductDescription.text.toString()

            // Create the QR code for the product
            val qrCodeBitmap = generateQRCode(productName)
            ivQrCode.setImageBitmap(qrCodeBitmap)

            // Save the product with QR code
            val product = Product(name = productName, description = productDescription, qrCode = productName)
            productViewModel.addProduct(product)
        }

        // Set up RecyclerView to display products
        val productAdapter = ProductAdapter()
        rvProducts.adapter = productAdapter
        rvProducts.layoutManager = LinearLayoutManager(this)

        productViewModel.allProducts.observe(this@MainActivity, Observer { products ->
            products?.let {
                productAdapter.setProducts(it)
            }
        })


    }
}
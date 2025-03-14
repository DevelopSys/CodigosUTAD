package com.example.inicio.data

import com.example.inicio.model.Product

class DataSet {

    companion object{
        val lista: ArrayList<Product> = arrayListOf(
            Product("Producto 1",123.5,"descripcion del producto","https://images.pexels.com/photos/90946/pexels-photo-90946.jpeg?cs=srgb&dl=pexels-madebymath-90946.jpg&fm=jpg"),
            Product("Producto 2",23.5,"descripcion del producto","https://cdn.shopify.com/s/files/1/2303/2711/files/2_e822dae0-14df-4cb8-b145-ea4dc0966b34.jpg?v=1617059123"),
            Product("Producto 3",11234.5,"descripcion del producto","https://cdn3.pixelcut.app/7/10/ai_background_1_5b79cd8ea3_1ea97b2c5a.jpg"),
            Product("Producto 4",4535.5,"descripcion del producto","https://d2v5dzhdg4zhx3.cloudfront.net/web-assets/images/storypages/primary/ProductShowcasesampleimages/JPEG/Product+Showcase-1.jpg"),
            Product("Producto 5",12.5,"descripcion del producto","https://b2861582.smushcdn.com/2861582/wp-content/uploads/2023/02/splash-01-605-v1.png?lossy=2&strip=1&webp=1"),
        )
    }

}
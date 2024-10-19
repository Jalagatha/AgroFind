package com.ivanj.agrofind

import android.graphics.Bitmap
import android.graphics.Color
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter

fun generateQRCode(productData: String): Bitmap {
    val width = 500
    val height = 500
    val bitMatrix = MultiFormatWriter().encode(productData, BarcodeFormat.QR_CODE, width, height)
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)

    for (x in 0 until width) {
        for (y in 0 until height) {
            bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
        }
    }
    return bitmap
}
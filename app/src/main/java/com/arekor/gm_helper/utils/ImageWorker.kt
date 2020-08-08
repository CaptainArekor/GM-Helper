package com.arekor.gm_helper.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.sql.SQLException


class ImageWorker {
    companion object {
        fun urlToBytes(url: String): ByteArray? {
            return try {
                Files.readAllBytes(Paths.get(url))
            } catch (e: IOException) {
                null
            }
        }

        fun bytesToBitmap(array: ByteArray): Bitmap? {
            try {
                val options = BitmapFactory.Options()
                return BitmapFactory.decodeByteArray(
                    array,
                    0,
                    array.size,
                    options
                )
            } catch (e: SQLException) {}
            return null
        }

        fun urlToBitMap(url: String): Bitmap?{
            return urlToBytes(url)?.let { bytesToBitmap(it) }
        }
    }
}
package com.zakaria.repositories.ui.bindingAdapters

import android.databinding.BindingAdapter
import android.support.v7.widget.AppCompatTextView
import android.widget.ImageView

/**
 * Created by Zakaria on 05/02/2018.
 */

        @BindingAdapter("imageUrl")
        fun setImageUrl(imageView :ImageView, imageUrl : String ){

        }
        @BindingAdapter("textStars")
        fun setTextStars(textView: AppCompatTextView, nbStars: Long) {
            textView.text = if (nbStars < 1000) {
                "${nbStars}"
            }else {
                val exp = (Math.log(nbStars.toDouble()) / Math.log(1000.0)).toInt()
                String.format("%.1f %c",
                        nbStars / Math.pow(1000.0, exp.toDouble()),
                        "kmGTPE"[exp - 1])
            }

        }




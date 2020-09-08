package com.alawiyaa.instagramprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail_post.*
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow


class DetailPostFragment : Fragment() {

    var imageProfile:String?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageProfile = arguments?.getString(MainActivity.EXTRA_TEXT)

        activity?.let { Glide.with(it).load(imageProfile).into(imgPostDetail) }

        tvDetailUsername.text = arguments?.getString(MainActivity.EXTRA_USERNAME)
        tvDetailLocation.text = arguments?.getString(MainActivity.EXTRA_LOCATION)
        tvDetailLike.text = arguments?.getInt(MainActivity.EXTRA_LIKE,0)?.let { prettyCount(it) }
        tvDetailComment.text = arguments?.getInt(MainActivity.EXTRA_COMMENT,0)?.let {
            prettyCount(
                it
            )
        }

    }

    fun prettyCount(number: Number): String? {
        val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
        val numValue: Long = number.toLong()
        val value = floor(log10(numValue.toDouble())).toInt()
        val base = value / 3
        return if (value >= 3 && base < suffix.size) {
            DecimalFormat("#0.00").format(
                numValue / 10.0.pow(base * 3.toDouble())
            ) + suffix[base]
        } else {
            DecimalFormat().format(numValue)
        }
    }
}
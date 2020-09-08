package com.alawiyaa.instagramprofile.ui

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.alawiyaa.instagramprofile.DetailPostFragment
import com.alawiyaa.instagramprofile.MainActivity
import com.alawiyaa.instagramprofile.R
import com.alawiyaa.instagramprofile.data.remote.ApiService
import com.alawiyaa.instagramprofile.data.remote.NetworkProvider
import com.alawiyaa.instagramprofile.data.remote.response.EdgesItem
import com.alawiyaa.instagramprofile.data.remote.response.Responsew
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment(), AdapterGallery.GalleryListener {
    // TODO: Rename and change types of parameters

    private lateinit var adapterGallery:AdapterGallery
    private val list=ArrayList<EdgesItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_search, container, false)


    }



    private fun showData(data: String) {
        val ds = NetworkProvider.providesHttpAdapter().create(ApiService::class.java)
        ds.getUsername(data,1).enqueue(object: Callback<Responsew> {
            override fun onFailure(call: Call<Responsew>, t: Throwable) {
                pbLoading.visibility = View.GONE
                Toast.makeText(activity,"Periksa Koneksi Anda", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Responsew>, response: Response<Responsew>) {
                pbLoading.visibility = View.GONE
                val result = response.body()?.graphql?.user
                val folllow = response.body()?.graphql?.user?.edgeFollowedBy?.count

                tvFullName.text = result?.fullName

                tvBio.text = result?.biography
                tvPostNum.text = result?.edgeOwnerToTimelineMedia?.count.toString()
                tvFollowersNum.text = folllow?.let { prettyCount(it) }
                tvFollowingNum.text = result?.edgeFollow?.count.toString()
                tvUsername.text = result?.username




                context?.let {
                    Glide.with(it).load(result?.profilePicUrlHd)
                        .placeholder(R.drawable.profile)
                        .into(imgProfile)
                }

                showGallery(response.body()?.graphql?.user?.edgeOwnerToTimelineMedia?.edges)

            }

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getString(MainActivity.EXTRA_TEXT)
        Toast.makeText(activity,"ini search $data",Toast.LENGTH_SHORT).show()
        if (data != null) {
            showData(data)
        }
        adapterGallery = AdapterGallery(list)


        imgBack.setOnClickListener{
            activity?.onBackPressed()
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


    private fun showGallery(edges: ArrayList<EdgesItem>?) {
        rvGallery.layoutManager = GridLayoutManager(activity,3)
        val list = edges?.let { AdapterGallery(it) }
        rvGallery.adapter = list
        rvGallery.setHasFixedSize(true)
        list?.setOnItemClickCallback(this)
    }

    override fun onItemClick(gallery: EdgesItem) {

       val bundle = Bundle()
        bundle.putString(MainActivity.EXTRA_TEXT,gallery.node?.displayUrl)
        bundle.putString(MainActivity.EXTRA_USERNAME,gallery.node?.owner?.username)
        bundle.putString(MainActivity.EXTRA_LOCATION,gallery.node?.location?.name)
        gallery.node?.edgeLikedBy?.count?.let { bundle.putInt(MainActivity.EXTRA_LIKE, it) }
        gallery.node?.edgeMediaToComment?.count?.let {
            bundle.putInt(MainActivity.EXTRA_COMMENT,
                it
            )
        }
        bundle.putString(MainActivity.EXTRA_PROFILE,gallery.node?.displayUrl)

        val fragment= DetailPostFragment()
        fragment.arguments = bundle

        val ffmManager = fragmentManager
        ffmManager?.beginTransaction()?.replace(R.id.fmContainer,fragment,DetailPostFragment::class.java.simpleName)
            ?.addToBackStack(null)
            ?.commit()
    }
}
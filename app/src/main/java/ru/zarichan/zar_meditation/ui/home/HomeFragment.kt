package ru.zarichan.zar_meditation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.zarichan.zar_meditation.R
import ru.zarichan.zar_meditation.adapters.FeelRecycler
import ru.zarichan.zar_meditation.adapters.PostRecycler
import ru.zarichan.zar_meditation.net.Api
import ru.zarichan.zar_meditation.net.MRetrofit
import ru.zarichan.zar_meditation.net.feelings
import ru.zarichan.zar_meditation.net.quotes

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val feelRecycler: RecyclerView = root.findViewById(R.id.feel_rec)
        val postRecycler: RecyclerView = root.findViewById(R.id.post_rec)

//        feelRecycler.adapter = FeelRecycler(requireContext(), Feels().list)
//        postRecycler.adapter = PostRecycler(requireContext(), Posts().list)

        val netApi = MRetrofit().get().create(Api::class.java)

        netApi.getFeels().enqueue(object : Callback<feelings> {
            override fun onResponse(call: Call<feelings>, response: Response<feelings>) {
                if (response.isSuccessful) feelRecycler.adapter =
                    response.body()?.let { FeelRecycler(requireContext(), it) }
            }

            override fun onFailure(call: Call<feelings>, t: Throwable) {}
        })

        netApi.getQuotes().enqueue(object : Callback<quotes> {
            override fun onResponse(call: Call<quotes>, response: Response<quotes>) {
                if (response.isSuccessful) postRecycler.adapter =
                    response.body()?.let { PostRecycler(requireContext(), it) }
            }

            override fun onFailure(call: Call<quotes>, t: Throwable) {}
        })

        return root
    }
}
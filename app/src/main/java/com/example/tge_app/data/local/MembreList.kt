package com.example.tge_app.data.local

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tge_app.R
import com.example.tge_app.data.local.Common.Common
import com.example.tge_app.data.local.Common.ItemOffDecoration
import com.example.tge_app.domain.adapter.MembreListAdapter
import com.example.tge_app.domain.retrofit.IMembreList
import com.example.tge_app.domain.retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_membre_list.*


class MembreList : Fragment() {

    internal var compositeDisposable = CompositeDisposable()
    internal var iMemberList:IMembreList
    internal lateinit var recycler_view: RecyclerView

    init {
        val retrofit=RetrofitClient.instance
        iMemberList = retrofit.create(IMembreList::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val itemView = inflater.inflate(R.layout.fragment_membre_list, container, false)

        recycler_view = itemView.findViewById(R.id.member_recyclerview) as RecyclerView
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = GridLayoutManager(activity,2)
        val itemDecoration = ItemOffDecoration(requireActivity(),R.dimen.spacing)
        recycler_view.addItemDecoration(itemDecoration)

        fetchData()

        return itemView
    }

    private fun fetchData() {
        compositeDisposable.add(iMemberList.listMember.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ memberDex ->
                Common.membreList = memberDex.membre!!
                val adapter = MembreListAdapter(requireActivity(),Common.membreList)

                recycler_view.adapter = adapter
            }
        )
    }

}
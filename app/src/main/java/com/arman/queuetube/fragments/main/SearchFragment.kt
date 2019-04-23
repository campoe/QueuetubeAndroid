package com.arman.queuetube.fragments.main

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import com.arman.queuetube.R
import com.arman.queuetube.fragments.AsyncVideoListFragment
import com.arman.queuetube.model.Video
import com.arman.queuetube.modules.search.YouTubeService

class SearchFragment : AsyncVideoListFragment() {

    override var loadOnStart: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        val item = menu.findItem(R.id.action_search)
        val view = item.actionView as SearchView
        this.addSearchListeners(view)
    }

    private fun addSearchListeners(view: SearchView) {
        view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                load(s)
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                return false
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun doInBackground(params: Array<out String>): MutableList<Video> {
        return YouTubeService.get().search(params[0])
    }

    companion object {

        const val TAG = "SearchFragment"

    }

}
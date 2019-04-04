package com.arman.queuetube.fragments.main

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arman.queuetube.R
import com.arman.queuetube.fragments.VideoListFragment
import com.arman.queuetube.model.VideoData
import com.arman.queuetube.modules.search.YouTubeSearcher

class HomeFragment : VideoListFragment() {

    private val regionCode: String?
        get() = PreferenceManager.getDefaultSharedPreferences(context).getString(getString(R.string.select_region_key), "US")

    override fun doInBackground(vararg params: String): MutableList<VideoData> {
        return YouTubeSearcher.topMusicCharts(regionCode!!)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {

        const val TAG = "HomeFragment"

    }

}
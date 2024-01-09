package com.google.maps.android.compose

import android.app.Application
import android.content.Context
import coil3.ImageLoader
import coil3.SingletonImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.fetch.NetworkFetcher
import coil3.util.DebugLogger

class App: Application(), SingletonImageLoader.Factory {
    @OptIn(ExperimentalCoilApi::class)
    override fun newImageLoader(context: Context): ImageLoader {
        return ImageLoader.Builder(context)
            .logger(DebugLogger())
            .components {
                add(NetworkFetcher.Factory())
            }
            .build()
    }

}
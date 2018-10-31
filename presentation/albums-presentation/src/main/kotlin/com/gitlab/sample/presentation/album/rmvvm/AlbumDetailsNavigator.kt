/***
 * Copyright 2018 Hadi Lashkari Ghouchani
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * */
package com.gitlab.sample.presentation.album.rmvvm

import android.annotation.SuppressLint
import android.os.Bundle
import com.gitlab.sample.presentation.common.*
import javax.inject.Inject

class AlbumDetailsNavigator @Inject constructor() : Navigator {
    @Inject
    lateinit var factory: BaseFragmentFactory

    var albumId: Long = 0

    @SuppressLint("CommitTransaction")
    override fun launchFragment(fragment: BaseFragment) {
        val details = factory.create(FragmentType.ALBUM_DETAILS)

        val bundle = Bundle()
        bundle.putLong(BundleKey.ALBUM_ID, albumId)
        details.arguments = bundle

        fragment.fragmentManager?.let {
            factory.commitFragment(it.beginTransaction().addToBackStack(null), details)
        }
    }
}
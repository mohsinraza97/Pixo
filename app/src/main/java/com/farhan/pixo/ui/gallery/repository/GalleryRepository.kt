/**Designed and developed by 2021 Muhammad Farhan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/
package com.farhan.pixo.ui.gallery.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.farhan.pixo.arch.api.PixabayApi
import com.farhan.pixo.ui.gallery.paging.PixabayPagingSource
import javax.inject.Inject

class GalleryRepository @Inject constructor(private val pixabayApi: PixabayApi) {
    fun getImages(query: String) =
            Pager(
                    config = PagingConfig(
                            pageSize = 20,
                            enablePlaceholders = false,
                            prefetchDistance = 5
                    ),
                    pagingSourceFactory = { PixabayPagingSource(pixabayApi, query) }
            ).liveData
}
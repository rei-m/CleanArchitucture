/**
 * Copyright (C) 2018 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gitlab.sample.cleanarchitecture.di.navigator

import com.gitlab.sample.cleanarchitecture.MainNavigator
import com.gitlab.sample.presentation.album.rmvvm.AlbumDetailsNavigator
import com.gitlab.sample.presentation.common.Navigator
import com.gitlab.sample.presentation.common.di.NavigatorFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NavigatorModule {
    @Binds
    internal abstract fun bindNavigatorFactory(factory: NavigatorFactoryImpl): NavigatorFactory

    @Binds
    @IntoMap
    @NavigatorKey(MainNavigator::class)
    abstract fun bindsMainNavigator(navigator: MainNavigator): Navigator

    @Binds
    @IntoMap
    @NavigatorKey(AlbumDetailsNavigator::class)
    abstract fun bindsAlbumDetailsNavigator(navigator: AlbumDetailsNavigator): Navigator
}
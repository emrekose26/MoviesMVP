# MoviesMVP
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)]()
[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=102)](https://opensource.org/licenses/Apache-2.0)

Sample Android app built with an MVP approach uses [TheMovieDB API](https://www.themoviedb.org/documentation/api) .

# What is MVP?
<img src="http://cdn.macoscope.com/blog/wp-content/uploads/2015/12/diagram_2.png"/>

- **View** is a layer that displays data and reacts to user actions. On Android, this could be an Activity, a Fragment, an android.view.View or a Dialog.
- **Model** is a data access layer such as database API or remote server API.
- **Presenter** is a layer that provides View with data from Model. Presenter also handles background tasks.

# ScreenShots
#### Popular and Top Rated Movies
<img src="https://raw.githubusercontent.com/emrekose26/MoviesMVP/master/screenshots/main.png" height="750"/>

#### Movie Detail
<img src="https://github.com/emrekose26/MoviesMVP/blob/master/screenshots/detail.png?raw=true" height="750"/>

# Libraries Used

- [Dagger2](https://github.com/google/dagger)
- [RxJava and RxAndroid](https://github.com/ReactiveX/RxJava)
- [Retrofit](https://github.com/square/retrofit)
- [GSON](https://github.com/google/gson)
- [OkHttp](https://github.com/square/okhttp)
- [ButterKnife](https://github.com/JakeWharton/butterknife)
- [RetroLambda](https://github.com/evant/gradle-retrolambda)
- [Glide](https://github.com/bumptech/glide)
- [Timber](https://github.com/JakeWharton/timber)

# Setup

Add your API KEY in `gradle.properties` file

    APIKEY="YOUR_API_KEY"

License
--------


    Copyright 2017 Emre Köse.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


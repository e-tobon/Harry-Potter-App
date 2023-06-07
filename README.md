# Harry Potter App

Aplicación para visualizar a los alumnos y profesores de la saga de películas Harry Potter.

min SDK: 23

##En esta app se implento:
--Patron de arquitectura MVVM
--Uso de API https://hp-api.onrender.com/ con Retrofit
--Navigation Component
--Patrones de diseño (Creacionales)
--Autenticación con correo con FIREBASE

##Se utlizaron las siguientes librerias

    //MARK:- VIEWMODEL
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1'
    //MARK:- LIVE DATA
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.6.1'
    //MARK:-NAVIGATION
    implementation 'androidx.navigation:navigation-ui-ktx:2.5.3'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.5.3'
    //MARK:-RETROFIT
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.google.code.gson:gson:2.10.1'
    //MARK:-GLIDE
    implementation 'com.github.bumptech.glide:glide:4.15.1'
    //MARK:- FIREBASE
    implementation platform('com.google.firebase:firebase-bom:32.1.0')
    implementation 'com.google.firebase:firebase-analytics-ktx'
    implementation 'com.google.firebase:firebase-auth-ktx:21.0.3'

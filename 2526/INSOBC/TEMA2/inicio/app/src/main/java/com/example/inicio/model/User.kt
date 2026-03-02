package com.example.inicio.model

import java.io.Serializable

class User(
    var mail: String,
    var pass: String,
    var profile: String,
    var remeber: Boolean
) : Serializable
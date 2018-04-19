package com.zakaria.repositories.utils

import com.zakaria.repositories.data.model.Repository
import java.text.SimpleDateFormat
import java.util.*

fun JoinDate(dateString:String):String{
    var dateParser = SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss'Z'")
    var date = dateParser.parse(dateString)
    var pretty = PrettyDate(date)
    return pretty.toString()

}

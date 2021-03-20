package com.example.mydemoapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserEntity {

    @PrimaryKey
    var id:Int=1

    @ColumnInfo (name ="Email")
    var userEmail:  String =""

    @ColumnInfo (name ="Password")
    var userPassword:  String =""

}
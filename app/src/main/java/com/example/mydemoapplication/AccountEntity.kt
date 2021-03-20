package com.example.mydemoapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class AccountEntity {

    @PrimaryKey
    @ColumnInfo (name ="Email")
    var accountEmail:  String =""

    @ColumnInfo (name ="Password")
    var accountPassword:  String =""

}
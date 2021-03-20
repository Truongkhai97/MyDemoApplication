package com.example.mydemoapplication

import androidx.room.Database
import androidx.room.RoomDatabase

@Database (entities = [(AccountEntity::class),(UserEntity::class)],version = 1)
abstract class AppDb : RoomDatabase() {

    abstract fun accountDao(): AccountDao
    abstract fun userDao(): UserDao

}
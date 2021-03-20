package com.example.mydemoapplication

import android.provider.ContactsContract
import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun saveUsers(user: UserEntity)

    @Query(value = "Select * from UserEntity")
    fun getAll(): UserEntity

//    @Query(value = "Select * from UserEntity where email = :em")
//    fun findByEmail(em: String): UserEntity

//    @Query(value = "Select count(1) from UserEntity where email = :em and password=:pw")
//    fun auth(em: String, pw: String): Int

//    @Query(value = "Select rememberPwd from UserEntity")
//    fun isRemembered():Boolean

    @Update
    fun update(user: UserEntity)

    @Query(value = "Delete from userEntity")
    fun deleteAll()

}
package com.example.mydemoapplication

import android.provider.ContactsContract
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AccountDao {
    @Insert
    fun saveAccounts(account: AccountEntity)

    @Query(value = "Select * from AccountEntity")
    fun getAllAccounts(): List<AccountEntity>

    @Query(value = "Select count(1) from AccountEntity where email = :em and password=:pw")
    fun auth(em: String, pw: String): Int

}
package com.example.mydemoapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adb = Room.databaseBuilder(applicationContext, AppDb::class.java, "AppDB")
            .allowMainThreadQueries().build()


        //Insert Case

        if (adb.accountDao().getAllAccounts() == null) {

            var accountEntity = AccountEntity()
            //fake du lieu cho account db
            accountEntity.accountEmail = "truongkhai@gmail.com"
            accountEntity.accountPassword = "truongkhai@123"
            adb.accountDao().saveAccounts(accountEntity)

            accountEntity.accountEmail = "hangvig@gmail.com"
            accountEntity.accountPassword = "hangvi99$"
            adb.accountDao().saveAccounts(accountEntity)


            accountEntity.accountEmail = "manhhoangg@gmail.com"
            accountEntity.accountPassword = "manhhoang999*"
            adb.accountDao().saveAccounts(accountEntity)
        }

        if ((adb.userDao().getAll() != null)) {
            var us: UserEntity = adb.userDao().getAll()
            txtEmail.setText(us.userEmail)
            txtPassword.setText(us.userPassword)
            cbRememberPwd.performClick()
        }


        btnLogin.setOnClickListener {


            var email = txtEmail.text.toString()
            var password = txtPassword.text.toString()

            //var us:UserEntity=udb.userDao().getAll()
            val regex =
                "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$".toRegex()
            if (!regex.matches(password) || (adb.accountDao()
                    .auth(email, password) == 0)
            ) tvWarning.text =
                "Sai tài khoản hoặc mật khẩu, vui lòng nhập lại!"
            else {
                if (cbRememberPwd.isChecked) {
                    var userEntity = UserEntity()
                    userEntity.id = 1
                    userEntity.userEmail = email
                    userEntity.userPassword = password
                    adb.userDao().update(userEntity)
                } else {
                    adb.userDao().deleteAll()
                }
                val intent: Intent = Intent(this, Home::class.java)
                startActivity(intent)
            }
        }
    }
}
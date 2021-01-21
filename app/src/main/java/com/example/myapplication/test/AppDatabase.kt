package com.shop.test

import androidx.room.Database
import androidx.room.RoomDatabase
import kotlin.reflect.KClass


@Database(entities = [User::class],version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun userDao():UserDao?
}


package com.ddona.l2011jetpack.db

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.*
import com.ddona.l2011jetpack.model.Task

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM task")
    fun getTasksLiveData(): LiveData<List<Task>>

    @Query("SELECT * FROM task")
    fun getTaskByPaging(): PagingSource<Int, Task>
}
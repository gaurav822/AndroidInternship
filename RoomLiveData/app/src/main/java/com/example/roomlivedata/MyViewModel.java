package com.example.roomlivedata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    MyRepository repository;
    LiveData<List<Student>> getallData;
    public MyViewModel(@NonNull Application application) {
        super(application);

        repository=new MyRepository(application);
        getallData = repository.readALLData();

    }

    /*This is for insert Method */

    public void insert(Student student){
        repository.insert(student);
    }

    /* This is for Update Method*/

    public void update(Student student){
        repository.update(student);
    }

    /* This is for delete method*/

    public void delete(Student student){
        repository.delete(student);
    }

    /* This is for read Data Method*/
    public LiveData<List<Student>> readData(){
        return getallData;
    }
}

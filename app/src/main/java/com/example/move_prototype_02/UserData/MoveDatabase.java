package com.example.move_prototype_02.UserData;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.move_prototype_02.UserData.Daos.HabitDao;
import com.example.move_prototype_02.UserData.Daos.UserDao;
import com.example.move_prototype_02.UserData.Entities.HabitEntity;
import com.example.move_prototype_02.UserData.Entities.UserEntity;

@Database(entities = {UserEntity.class, HabitEntity.class}, version = 1)
public abstract class MoveDatabase extends RoomDatabase {

    private static MoveDatabase instance;

    public abstract UserDao userDao();
    public abstract HabitDao habitDao();

    public static synchronized MoveDatabase getUserDatabase(Context context){

        if(instance == null)
        {
            instance = Room.databaseBuilder(context, MoveDatabase.class, "MoveDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDao userDao;
        private HabitDao habitDao;

        private PopulateDbAsyncTask(MoveDatabase db) {
            userDao = db.userDao();
            habitDao = db.habitDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            userDao.registerUser(new UserEntity("GabrielDev", "ghmdc523", "Gabriel", "Hammermeister", "gabriel.hammer523@gmail.com"));
            habitDao.insert(new HabitEntity(1, "Correr", "Km", 5));
            habitDao.insert(new HabitEntity(1, "Programar", "horas", 3));

            return null;
        }
    }
}

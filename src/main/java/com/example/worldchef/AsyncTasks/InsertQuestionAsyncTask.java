package com.example.worldchef.AsyncTasks;

import android.os.AsyncTask;

import com.example.worldchef.AppDatabase;
import com.example.worldchef.Models.Favourite;
import com.example.worldchef.Models.Quiz;
import com.example.worldchef.TaskDelegates.AsyncTaskFavouriteDelegate;
import com.example.worldchef.TaskDelegates.AsyncTaskQuizDelegate;

public class InsertQuestionAsyncTask extends AsyncTask<Quiz, Integer, String> {

    private AsyncTaskQuizDelegate delegate;

    private AppDatabase db;

    public void setDelegate(AsyncTaskQuizDelegate delegate) {
        this.delegate = delegate;
    }

    public void setDatabase(AppDatabase db) {
        this.db = db;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Quiz...quizzes) {

        db.quizDao().insertQuestion(quizzes[0]);


        return "Successfully added question!";
    }

    @Override
    protected void onPostExecute(String result) {

        delegate.handleInsertQuestionTask(result);
    }

}
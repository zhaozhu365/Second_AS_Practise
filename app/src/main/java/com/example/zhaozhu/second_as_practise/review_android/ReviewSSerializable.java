package com.example.zhaozhu.second_as_practise.review_android;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by zhaozhu on 17/4/25.
 */

public class ReviewSSerializable {

    private final String TAG = getClass().getSimpleName();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                new ReviewSSerializable().writeObject();
                new ReviewSSerializable().readObject();
            }
        }).start();
    }

    public static class User implements Serializable {
        private static final long serialVersionUID = -1983937440766080840L;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String name;
        public int age;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static final String CACHE_PATH = "/Users/zhaozhu/Desktop/cache_path";
    public static final String CACHE_FILE_PATH = "/Users/zhaozhu/Desktop/cache_path/cache.txt";

    public void writeObject() {
        User user = new User("zz", 20);
        File dir = new File(CACHE_PATH);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File cachedFile = new File(CACHE_FILE_PATH);
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(cachedFile));
            out.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readObject() {
        User user = null;
        File cachedFile = new File(CACHE_FILE_PATH);
        if (!cachedFile.exists()) {
            return;
        }
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(cachedFile));
            user = (User) in.readObject();
//            Log.d(TAG, "recover user :" + user);
            System.out.print("recover user :" + user.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

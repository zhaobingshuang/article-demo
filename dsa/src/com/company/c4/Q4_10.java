package com.company.c4;

import java.io.File;

public class Q4_10 {

//    public int size(String path) {
//
//
//    }

    public long size(File file) {
        if (file.isFile()) {
            System.out.println(file.getName() + " " + file.length());
            return file.length();
        }

        long size = 0;
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File f : files) {
                size += size(f);
            }

        }
        System.out.println(file.getName() + " " + size);
        return size;
    }

    static class FileList
    {
        public void list(File f)
        {
            list(f, 0);
        }
        public void list(File f, int depth)
        {
            printName(f, depth);
            if (f.isDirectory())
            {
                File [] files = f.listFiles();
                for (File i : files) {
                    list(i, depth+1);
                }
            }
        }
        void printName(File f, int depth)
        {
            String name = f.getName();
            for (int i=0; i<depth; i++) {
                System.out.print(" ");
            }
            if (f.isDirectory()) {
                System.out.println("Dir: " + name);
            } else {
                System.out.println(f.getName() + " " + f.length());
            }
        }
    }

    public static void main(String[] args) {
        FileList L = new FileList();
        File f = new File("D:\\article");
        L.list(f);

//        Q4_10 q4_10 = new Q4_10();
//        q4_10.size(new File("D:\\article"));
    }
}

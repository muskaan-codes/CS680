package edu.umb.cs680.hw02;

public class Singleton {

        private Singleton() {};
        private static edu.umb.cs680.hw02.Singleton instance = null;

        public static edu.umb.cs680.hw02.Singleton getInstance() {
            if(instance == null) {
                instance = new edu.umb.cs680.hw02.Singleton();
            }
            return instance;
        }

}

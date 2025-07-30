class Singleton {
    private static Singleton instance = null;

    private Singleton() {
    }

    ;
    public String str;

    public static Singleton getSingleInstance() {
        if (instance == null) {
            instance = new Singleton();
            return instance;
        }
        return instance;
    }
}

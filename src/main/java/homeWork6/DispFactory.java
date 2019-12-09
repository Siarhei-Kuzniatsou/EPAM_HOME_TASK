package homeWork6;

public class DispFactory {
    private static IRepository fileDisp;
    private static IRepository sqlLiteDisp;


    public static IRepository getInstance(String param) {
        switch (param) {
            case "file":
                if (fileDisp == null) return FileDisp.getInstance();
                else return fileDisp;
            case "SQLLite":
                if (sqlLiteDisp == null) return SQLiteDisp.getInstance();
                else return sqlLiteDisp;
        }
        return null;
    }
}

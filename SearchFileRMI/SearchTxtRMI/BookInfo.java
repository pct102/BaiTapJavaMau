public class BookInfo {
    private String bookID, name, author, releaseDate, type;

    public BookInfo(String bookID, String name, String author, String releaseDate, String type) {
        this.bookID = bookID;
        this.author = author;
        this.name = name;
        this.releaseDate = releaseDate;
        this.type = type;
    }

    public String GetBookID(){
        return this.bookID;
    }

    public void SetBookID(String bookID){
        this.bookID = bookID;

    }
    

    public String GetName(){
        return this.name;
    }

    public void SetName(String name){
        this.name = name;

    }

    public void SetAuthor(String author){
        this.author = author;

    }

    public String GetAuthor(){
        return this.author;
    }

    public String GetReleaseDate(){
        return this.releaseDate;
    }

    public void SetReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;

    }

    public void SetType(String type){
        this.type = type;

    }

    public String GetType(){
        return this.type;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.author + ", " + this.releaseDate + ", " +  this.type;
    }
}

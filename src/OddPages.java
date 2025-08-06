import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OddPages {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        Document [] documents = new Document[4];
        for(int i=0; i<4; i++){
            int id = sc.nextInt();
            sc.nextLine();
            String title = sc.nextLine();
            String name = sc.nextLine();
            int pg = sc.nextInt();
            documents[i] = new Document(id, title, name, pg);
        }
        Document [] res = docsWithOddPages(documents);
        for(Document doc: res){
            System.out.println(doc.getId()+" "+ doc.getTitle()+" " + doc.getFolderName()+" " + doc.getPages());
        }
    }
    public static Document [] docsWithOddPages(Document [] documents){
        List<Document> res = new ArrayList<>();
        for(Document doc: documents){
            if(doc.getPages()%2==1){res.add(doc);}
        }

        Collections.sort(res, new Comparator<Document>() {
            public int compare(Document d1, Document d2) {
                return Integer.compare(d1.getId(), d2.getId());
            }
        });

        return res.toArray(new Document[0]);
    }
}

class Document{
    private int id;
    private String title;
    private String folderName;
    private int pages;

    public int getId(){return this.id;}
    public String getTitle(){return this.title;}
    public String getFolderName(){return this.folderName;}
    public int getPages(){return this.pages;}

    Document(int id, String title, String name, int pg){
        this.id = id;
        this.title = title;
        this.folderName = name;
        this.pages = pg;
    }
}
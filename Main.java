import java.util.*;
public class Main{
    public static class Note{
        private int id;
        private String title;
        private String text;
        public Note(int id,String title,String text){
            this.id=id;
            this.title=title;
            this.text=text;
        }
        public int getid(){
            return id;
        }
        public String gettitle(){
            return title;
        }
        public String gettext(){
            return text;
        }
        public void setid(int id){
            this.id=id;
        }
        public void settitle(String title){
            this.title=title;
        }
        public void settext(String text){
            this.text=text;
        }
    }
    static ArrayList<Note> notes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int noteId = 1;
    public static void main(String[] args){
        System.out.println("=== Notes ===");
        while (true) {
            System.out.println();
            System.out.println("One - Create");
            System.out.println("Two - View");
            System.out.println("Three - Update");
            System.out.println("Four - Delete");
            System.out.println("Five - View All notes");
            System.out.println("Six - Exit");
            System.out.print("Choose any one from above : ");
            String choice = sc.nextLine();
            switch (choice) {
                case "One":
                    create();
                    break;
                case "Two":
                    System.out.println("NoteID to view");
                    int id=sc.nextInt();
                    sc.nextLine();
                    view(id);
                    break;
                case "Three":
                    update();
                    break;
                case "Four":
                    delete();
                    break;
                case "Five":
                    viewAll();
                    break;
                case "Six":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Please choose a number from 1 to 5.");
            }
        }
    }
    //Create note
    public static void create(){
        System.out.println("Creating a note !!! ");
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.println("Text : ");
        String text=sc.nextLine();
        Note n=new Note(noteId,title,text);
        notes.add(n);
        System.out.println("NoteID : " + noteId + " Created Successfully.");
        noteId++;
    }
    //View all notes
    public static void viewAll(){
        System.out.println("View all notes !!!");
        if(notes.isEmpty()){
            System.out.println("No notes are currently available to view.");
            return;
        }
        else{
            for(Note n:notes){
                printNote(n);
            }
        }
    }
    //View note
    public static void view(int id){
        for(Note n:notes){
            if(n.getid()==id){
                printNote(n);
                return;
            }
        }
        System.out.println("NoteID : "+id+" not found.");
    }

    private static void printNote(Note n){
        System.out.println("ID : "+n.getid());
        System.out.println("Title : "+n.gettitle());
        System.out.println("Text : "+n.gettext());
    }
    //Update note
    public static void update(){
        if(notes.isEmpty()){
            System.out.println("No notes are currently available to update.");
            return;
        }
        else{
            System.out.println("NoteId to update : ");
            int id=sc.nextInt();
            sc.nextLine();
            for(Note n:notes){
                if(n.getid()==id){
                    System.out.println("Title : ");
                    String title=sc.nextLine();
                    System.out.println("Text : ");
                    String text=sc.nextLine();
                    n.settitle(title);
                    n.settext(text);
                    System.out.println("NoteID : "+id+" Updated Successfully.");
                    return;
                }
            }
            System.out.println("Not found");
        }
    }
    //Delete note
    public static void delete(){
        if(notes.isEmpty()){
            System.out.println("No notes are currently available to delete.");
            return;
        }
        else{
            System.out.println("NoteId to delete : ");
            int id=sc.nextInt();
            sc.nextLine();
            for(Note n:notes){
                if(n.getid()==id){
                    notes.remove(n);
                    System.out.println("NoteID : "+id+" Deleted Successfully.");
                    return;
                }
                else{
                    System.out.println("Not found");
                }
            }
        }
    }
}

package LinkedLists;

import java.util.*;

class TextEditor {

    StringBuilder sb;
    int cursor;
    
    public TextEditor() {
        sb = new StringBuilder();
        cursor = 0;
    }
    
    public void addText(String text) {
        sb.insert(cursor, text);
        cursor += text.length();
    }

    // int deleteText(int k) Deletes k characters to the 
    // left of the cursor. Returns the number of characters 
    // actually deleted.

    public int deleteText(int k) {
        int prev = cursor;
        cursor = Math.max(0, cursor-k);

        sb.delete(cursor, prev);

        return (prev - cursor);
    }

    // string cursorLeft(int k) Moves the cursor to the left k times. 
    // Returns the last min(10, len) characters to the left of the cursor, 
    // where len is the number of characters to the left of the cursor.

    public String cursorLeft(int k) {
        cursor = Math.max(0, cursor-k);
        int left = Math.max(0, cursor-10);

        return sb.substring(left, cursor);
    }
    
    public String cursorRight(int k) {
        cursor = Math.min(sb.length(), cursor + k);
        int left = Math.max(0, cursor-10);

        return sb.substring(left, cursor);
    }
}


public class designATextEditor {
    
}

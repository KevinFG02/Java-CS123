package Week9.sets;

import java.util.Arrays;

// Incomplete

public class Set implements ISet{
    //Constants
    private static final int INT_TABLE_LEN = 10;
    private static final double LOAD_FACTOR = .6;
    private static final int RESIZE_FACTOR = 2;

    //Fields
    private TableElement[] table;
    private int size;

    //Constructor
    public Set(){
        table = new TableElement[INT_TABLE_LEN];
    }

    public boolean add(Object obj) {
        if((size + 1.0) / table.length > LOAD_FACTOR){
            resize();
        }

        // Find Target Index
        int index = Math.abs(obj.hashCode()) % table.length;

        // Scan until empty spot is found
        while(table[index] != null){
            if(table[index].obj.equals(obj)) return false; // Duplicate

            index = (index + 1) % table.length;
        }
        table[index] = new TableElement(obj);
        size++;
        return true;
    }

    private void resize(){
        //Create a new array
        TableElement[] newTable = new TableElement[(int) (table.length * RESIZE_FACTOR)];

        // Hash the elements from the old one into the new one
        for(int i = 0; i < table.length; i++){
            TableElement elem = table[i];

            // Hash into the new table
            if(elem != null && elem.active){
                int index = Math.abs(elem.obj.hashCode()) % newTable.length;

                while(newTable[index] != null){
                    index = (index + 1) % newTable.length;
                }

                newTable[index] = new TableElement(elem.obj);
            }
        }

        // Resign the table
        table = newTable;
    }

    public boolean contains(Object obj) {
        int index = Math.abs(obj.hashCode()) % table.length;

        while(table[index] != null){
            if(table[index].obj.equals(obj) && table[index].active) return true;

            index = (index + 1) % table.length;
        }

        return false;
    }

    public boolean remove(Object obj) {
        int index = Math.abs(obj.hashCode()) % table.length;

        // Scan until empty spot is found
        while(table[index] != null){
            if(table[index].obj.equals(obj)){
                table[index].active = false;
                return true;
            }

            index = (index + 1) % table.length;
        }

        size--;
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Set union(Set otherSet) {
        Set union = new Set();

        TableElement[] setATable = this.table;
        TableElement[] setBTable = otherSet.table;

        for(int i = 0; i < setATable.length; i++){
            if(setATable[i] != null && setATable[i].active){
                union.add(setATable[i].obj);
            }
        }

        for(int i = 0; i < setBTable.length; i++){
            if(setBTable[i] != null && setBTable[i].active){
                union.add(setBTable[i].obj);
            }
        }

        return union;
    }

    public Set intersection(Set otherSet) {
        return null;
    }

    public Set difference(Set otherSet) {
        return null;
    }

    public boolean subset(Set otherSet) {
        return false;
    }

    public String toString(){
        return Arrays.toString(table);
    }

    private class TableElement{
        private Object obj;
        private boolean active;

        public TableElement(Object obj){
            this.obj = obj;
            active = true;
        }

        public String toString(){
            return "(" + obj.toString() + "," + active + ")";
        }
    }
}

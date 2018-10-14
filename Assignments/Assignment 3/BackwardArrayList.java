/*************
 * @author Spencer Davis
 * Assignment 2
 * Completed on 09-07-18
 * Worked on assignment for 7 hours
 * Windows 10
 * Visual studio code
 * Program is a backwards array list 
 **********/

public class BackwardArrayList{

// variables to be used in the class
private int[] arrayList = new int[20];
private int size = 0;
private boolean tOrF;
private int lastPos;

/********************
 * Simple metod that returns the size of the list
 * @return Current size of the lsit
 ********************/
public int theSize(){
    return size;
}

/********************
 * Method addds something to the begining of the list
 * @param value  The value that will be put into the list
 * @return       True / Falese if value was added to the list
 ********************/
public boolean addSomething(int value){
    lastPos = arrayList.length - size;
    // This is if the list is already populated it will shift all the elements down one index
    // before the new element is put in.
    if(size > 0){
        for(int i = lastPos; i < arrayList.length - 1; i++){
           arrayList[i] = arrayList[i + 1];
        }
    }

    arrayList[arrayList.length -1] = value;
    size += 1;

    // This calls the makeBigger method if the list has become full, BEFORE a new item is added to the list
    if(size == arrayList.length){
        makeBigger();
    }

    // Setting the boolean
    if(arrayList[arrayList.length - 1] == value){
        tOrF = true;
    }
    else{
        tOrF = false;
    }
    return tOrF;
}

/********************
 * Method adds something to the list at a position which is given
 * @param pos     Position that the value is going to be stored at
 * @param value   Value that will be stored in the list
 * @return        True / False if the value is in the position given
 ********************/
public boolean addSomething(int pos, int value){
    int posWanted = arrayList.length - pos;
    lastPos = arrayList.length - size;

    // Shifting all values down one index, starting from 0 to the position that the user wants to put
    // the new value in.
    for(int i = lastPos; i < posWanted; i++){
       arrayList[i] = arrayList[i + 1];
    }
    
    arrayList[posWanted] = value;
    size += 1;

    // This calls the makeBigger method if the list has become full, BEFORE a new item is added to the list
    if(size == arrayList.length){
        makeBigger();
    }
    // Setting the boolean
    if(arrayList[posWanted] == value){
        tOrF = true;
    }
    else{
        tOrF = false;
    }
    return tOrF;
}

/*******************
 * Takes a position in the list and removes the element in that position
 * @param pos   Position in which the value is to be removed
 * @return      True / False if the item was removed
 ********************/
public boolean removeSomething(int pos){
    int usrPos = arrayList.length - pos; // index position of the array
    lastPos = arrayList.length - size;   // Last position of the array
    int oldSize = size;                  // Size of the list before removing

    for(int i = usrPos; i > lastPos; i--){
        arrayList[i] = arrayList[i - 1];
    }

    size -= 1;
    if(oldSize == size){
        tOrF = false;
    }
    else{
        tOrF = true;
    }
    return tOrF;
}
/********************
 * Finds a given value in the list
 * @param wntdVal   The value that is wanted to be found in the list
 * @return          The position that that value is found. If the value isn't found returns -1
 ********************/
public int findSomething(int wntdVal){
    int indexPos = 0;
    lastPos = arrayList.length - size;     // Last position of the list in index
    int firstPos = arrayList.length - 1;   // First Position of the list in index

    for(int i = firstPos; i > lastPos; i--){
        
        if(wntdVal == arrayList[i]){
            indexPos = i;
            break;
        }
        else{
            indexPos = -1;
        }

    }
    
    return arrayList.length - indexPos;
}

/********************
 * Method called to make the current array size bigger by 1.5
 * @return Whether or not the makeBigger function worked
 ********************/
private boolean makeBigger(){
    int newLength = (int)(arrayList.length * 1.5);
    int[] temparrayList = new int[arrayList.length];
    int listLength = arrayList.length;
    
    
    for(int i = arrayList.length - 1; i > 0; i--){
        temparrayList[i] = arrayList[i];
    }
    
    arrayList = new int[newLength];

    for(int j = listLength - 1; j > 0; j--){
        arrayList[newLength -1] = temparrayList[j];
        newLength -= 1;
    }

    if(listLength == arrayList.length){
        tOrF = false;
    }
    else{
        tOrF = true;
    }
    
    return tOrF;
}

} // end of BackwardarrayListList class
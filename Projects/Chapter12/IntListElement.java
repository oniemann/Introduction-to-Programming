class IntListElement { 
  IntListElement(int value) { data = value; }
  
  IntListElement next; //self-referential
  int data; 
}
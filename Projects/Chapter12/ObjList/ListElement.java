//a generic list element
/*have to declare type
  e.g. int
    ListElement elem1 = new ListElement(new Integer(3))
       String
                                       ("element 3")
       float 
                                       (new Float(3)) 
*/ 
class ListElement {
  ListElement(Object value) {data = value; }

  ListElement next;
  Object data;
}
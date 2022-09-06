package Package_one;

import java.util.Vector ;

public class Objects {

    protected Vector<Fields> fields;
    protected Vector<Objects> objects;
    protected String name ;
    protected char type ;
    protected char mano;

     public Objects()
     {}

     public Objects(String name, char type, char mano) {
          this.fields = new Vector<Fields>();
          this.objects = new Vector<Objects>();
          this.name = name;
          this.type = type;
          this.mano = mano;
     }

     public void setFields(Vector<Fields> fields) {
          this.fields = fields;
     }

     public void setName(String name) {
          this.name = name;
     }

     public void setType(char type) {
          this.type = type;
     }

     public void setMano(char mano) {
          this.mano = mano;
     }

     public void setObjects(Vector<Objects> objects) {
          this.objects = objects;
     }

     public Vector<Fields> getFields() {
          return fields;
     }

     public String getName() {
          return name;
     }

     public char getType() {
          return type;
     }

     public char getMano() {
          return mano;
     }

     public Vector<Objects> getObjects() {
          return objects;
     }

     @Override
     public String toString ()
     {
          return "name : " + this.name + "\ntype : " + this.type + "\nmandatory : " + this.mano + "\nchild objects " + this.objects.toString() + "\nfields names :" + this.fields.toString();
     }
}

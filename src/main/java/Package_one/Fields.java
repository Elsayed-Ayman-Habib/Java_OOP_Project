package Package_one;

public class Fields {

    protected String name ;
    protected String value ;

     public Fields()
     {}

     public Fields( String name ,String value)
     {
          this.name = name ;
          this.value = value;
     }

    public void setName(String name) {
        this.name = name;
    }

     public String getName() {
          return name;
     }

    public void setValue(String value) {
        this.value = value;
    }

     public String getValue() {
          return value;
     }

     @Override
     public String toString ()
     {
          return "name : " + this.name;
     }
}

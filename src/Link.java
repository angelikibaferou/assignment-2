public class Link
{
  int knob;
  int burden;

       public Link(int knob, int burden)
 {
        this.knob = knob;
        this.burden = burden;
     }

     public void setKnob( int knob)
     {
   this.knob = knob;
  }

  public int getKnob()
  {
   return knob;
  }

  public void setBurden(int burden)
  {
   this.burden=burden;
  }

  public int getBurden()
  {
   return burden;
  }



  public String toString()
  {return("("+knob+","+burden+")");}}


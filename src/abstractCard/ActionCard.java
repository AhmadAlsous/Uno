package abstractCard;

public abstract class ActionCard implements Card{
  private Color color;
  
  protected ActionCard(Color color){
    this.color=color;
  }
  
  public Color getColor() {
    return color;
  }
  
  public abstract String getCardName();
  
  public abstract void print();
}

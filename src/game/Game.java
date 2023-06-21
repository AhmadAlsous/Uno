package game;

public abstract class Game {
  private Options options;
  protected Game(){
    Options defaultOptions=new Options();
    setOptions(defaultOptions);
  }
  public void setOptions(Options options){
    this.options=options;
  }
  public abstract void play();
}

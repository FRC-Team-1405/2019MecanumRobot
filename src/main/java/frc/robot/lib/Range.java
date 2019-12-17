package frc.robot.lib;

public class Range {
  private int min;
  private int max; 
  public Range(int min, int max) {
    this.min = min;
    this.max = max;
  }
  public double toPercent(int position){
    return (position-min)/(max-min);
  }
  public int toPosition(double percent){
    return (int)((max-min)*percent+min);
  } 
}

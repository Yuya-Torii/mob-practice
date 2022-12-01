package jp.co.saison.mob;

public class WeatherRecord {
  private int dy;
  private int mxt;
  private int mnt;

  public WeatherRecord(int dy, int mxt, int mnt) {
    this.dy = dy;
    this.mxt = mxt;
    this.mnt = mnt;
  }

  public int getTemperatureDiff() {
    return this.mxt - this.mnt;
  }

}

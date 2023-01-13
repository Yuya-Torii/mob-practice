package jp.co.saison.mob;

public class WeatherRecord implements KataRecord{
  private final int dy;
  private final int mxt;
  private final int mnt;

  public WeatherRecord(int dy, int mxt, int mnt) {
    this.dy = dy;
    this.mxt = mxt;
    this.mnt = mnt;
  }

  public int getTemperatureDiff() {
    return this.mxt - this.mnt;
  }

  @Override
  public String getDisplayName() {
    return String.valueOf(dy);
  }

  @Override
  public int getDiff() {
    return this.mxt - this.mnt;
  }
}
